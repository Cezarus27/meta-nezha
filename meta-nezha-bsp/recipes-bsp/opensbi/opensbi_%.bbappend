# Mainline OpenSBI supports the C906 out of the box, but it needs a few tweaks
# and a new reset driver for the sunxi watchdog.
SRCREV = "efbc2b8c7372067622d4169cf59378fd58fe3ec3"
SRC_URI = "git://github.com/Cezarus27/opensbi.git;branch=d1-wip \
           file://0001-Makefile-Don-t-specify-mabi-or-march.patch \
          "

EXTRA_OEMAKE += "CROSS_COMPILE=${TARGET_PREFIX} FW_PIC=y"

do_install() {
    autotools_do_install
}

INSANE_SKIP_${PN} += "ldflags"
