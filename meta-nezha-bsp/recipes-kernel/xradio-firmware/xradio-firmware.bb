DESCRIPTION = "Xradio xr829 WiFi firmware"
LICENSE = "CC0-1.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=0ceb3372c9595f0a8067e55da801e4a1"

PV = "1.0"
PR = "r0"

COMPATIBLE_MACHINE = "(nezha-allwinner-d1-512m|nezha-allwinner-d1-1g|nezha-allwinner-d1-2g)"

SRC_URI = "file://xradio-firmware.tar.gz;unpack=0"

S = "${WORKDIR}/xradio-firmware"

do_install() {
    tar -xzvf ${WORKDIR}/xradio-firmware.tar.gz --directory ${S}
    install -d ${D}${base_libdir}/firmware/xr829
    install -m 0644 ${S}/xr829/boot_xr829.bin ${D}${base_libdir}/firmware/xr829/
    install -m 0644 ${S}/xr829/sdd_xr829.bin ${D}${base_libdir}/firmware/xr829/
    install -m 0644 ${S}/xr829/sdd_xr829_40M.bin ${D}${base_libdir}/firmware/xr829/
    install -m 0644 ${S}/xr829/fw_xr829.bin ${D}${base_libdir}/firmware/xr829/
    install -m 0644 ${S}/xr829/fw_xr829_bt.bin ${D}${base_libdir}/firmware/xr829/
    install -m 0644 ${S}/xr829/fw_xr829.bin ${D}${base_libdir}/firmware/xr829/
    install -m 0644 ${S}/xr829/etf_xr829.bin ${D}${base_libdir}/firmware/xr829/
}

FILES_${PN} = "${base_libdir}/*"

PACKAGES = "${PN}"
