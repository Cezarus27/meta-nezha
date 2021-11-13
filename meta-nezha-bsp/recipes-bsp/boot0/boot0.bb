# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   common/lzma/license.txt
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://common/lzma/license.txt;md5=8ecc4f7ef807bbf661bf65387dc7cd08"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
SRC_URI = " \
	git://github.com/smaeul/sun20i_d1_spl;protocol=https;branch=mainline \
	file://0001-config.mk-provide-path-to-linux-headers.patch \
"

# Modify these as desired
PV = "1.0-dev"
SRCREV = "70d35f23b4d366af6d7c0c17a56ba40e7f977be7"

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

#do_install () {
#	install -d ${D}/boot
#	install -m 0644 ${S}/nboot/boot0_sdcard_sun20iw1p1.bin ${D}/boot
#}

do_deploy() {
    install -m 644 ${S}/nboot/boot0_sdcard_sun20iw1p1.bin ${DEPLOYDIR}
}

addtask deploy before do_build after do_compile

#FILES:${PN} = " \
#	boot/* \
#"
