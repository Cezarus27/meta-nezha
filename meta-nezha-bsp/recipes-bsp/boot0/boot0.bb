LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://common/lzma/license.txt;md5=8ecc4f7ef807bbf661bf65387dc7cd08"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
	git://github.com/Cezarus27/sun20i_d1_spl;protocol=https;branch=mainline \
	file://0001-config.mk-provide-path-to-linux-headers.patch \
"

PV = "1.0-dev"
SRCREV = "771192d0b3737798d7feca87263c8fa74a449787"

S = "${WORKDIR}/git"

CFLAGS += " --sysroot=${RECIPE_SYSROOT}"

EXTRA_OEMAKE = "CROSS_COMPILE=${TARGET_PREFIX} p=sun20iw1p1 mmc"
EXTRA_OEMAKE += "STAGING_INCDIR=${STAGING_INCDIR_NATIVE}"

GCC_INCLUDE = "${RECIPE_SYSROOT_NATIVE}${libdir}/${TARGET_SYS}/gcc/${TARGET_SYS}/*/include"

inherit deploy

do_configure () {
	cp -r ${GCC_INCLUDE}/* ${STAGING_INCDIR_NATIVE}
}

do_compile () {
	unset LDFLAGS
	oe_runmake
}

do_deploy() {
    install -m 644 ${S}/nboot/boot0_sdcard_sun20iw1p1.bin ${DEPLOYDIR}
}

addtask deploy before do_build after do_compile
