SUMMARY = "Xradio WiFi driver for orangepi-zero"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=801f80980d171dd6425610833a22dbe6"

inherit module

PV = "0.1"
PR = "r0"

RDEPENDS_${PN} += "xradio-firmware"

COMPATIBLE_MACHINE = "(nezha-allwinner-d1-512m|nezha-allwinner-d1-1g|nezha-allwinner-d1-2g)"


SRC_URI = "file://xradio.tar.gz"

S = "${WORKDIR}/xr829"

EXTRA_OEMAKE += "-C ${STAGING_KERNEL_DIR} M=${S}"

KERNEL_MODULE_AUTOLOAD += "xradio_wlan"
