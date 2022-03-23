require recipes-bsp/u-boot/u-boot-common.inc
require recipes-bsp/u-boot/u-boot.inc

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = " \
    git://github.com/tekkamanninja/u-boot.git;protocol=https;branch=allwinner_d1 \
    file://0001-sun20i-set-CONFIG_SYS_BOOTM_LEN.patch \
    file://0001-riscv-fix-build-with-binutils-2.38.patch \
    file://tftp-mmc-boot.txt \
    file://uEnv.txt \
    file://toc.cfg \
"

SRCREV = "6db9960b2443ef84b88a573cb5817f8e0ef3712e"

DEPENDS:append = " u-boot-tools-native python3-setuptools-native"

# Overwrite this for your server
TFTP_SERVER_IP ?= "127.0.0.1"

do_compile_toc1[depends] = "opensbi:do_deploy"

do_configure:prepend() {
    sed -i -e 's,@SERVERIP@,${TFTP_SERVER_IP},g' ${WORKDIR}/tftp-mmc-boot.txt
    mkimage -O linux -T script -C none -n "U-Boot boot script" \
        -d ${WORKDIR}/tftp-mmc-boot.txt ${WORKDIR}/${UBOOT_ENV_BINARY}
}

# boot0 expects to load a TOC1 image containing OpenSBI and U-Boot
# (and a DTB). This is similar to, but incompatible with, mainline U-Boot
# SPL, which expects a FIT image.
do_compile_toc1() {
    cp ${DEPLOY_DIR_IMAGE}/fw_dynamic.bin ${B}
    mkimage -T sunxi_toc1 -d ${WORKDIR}/toc.cfg ${B}/u-boot.toc1
}

do_deploy:append() {
    install -m 644 ${B}/u-boot.toc1 ${DEPLOYDIR}
    install -m 644 ${WORKDIR}/uEnv.txt ${DEPLOYDIR}
}

COMPATIBLE_MACHINE = "(nezha-allwinner-d1-512m|nezha-allwinner-d1-1g|nezha-allwinner-d1-2g)"

TOOLCHAIN = "gcc"

addtask do_compile_toc1 before do_deploy after do_compile
