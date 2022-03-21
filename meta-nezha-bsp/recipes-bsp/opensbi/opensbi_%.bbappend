# Mainline OpenSBI supports the C906 out of the box, but it needs a few tweaks
# and a new reset driver for the sunxi watchdog.
FILESEXTRAPATHS:prepend:nezha := "${THISDIR}/files:"

SRC_URI:append:nezha = " \
    file://0001-lib-utils-fdt-Require-match-data-to-be-const.patch \
    file://0002-lib-utils-timer-Add-a-separate-compatible-for-the-D1.patch \
"

EXTRA_OEMAKE:nezha += "CROSS_COMPILE=${TARGET_PREFIX} FW_PIC=y"

do_install:nezha() {
    autotools_do_install
}

# Remove dependencies due to dependency loop
#do_compile:nezha[deploy] = "1"

INSANE_SKIP_${PN}:nezha += "ldflags"
