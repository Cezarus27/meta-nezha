# Mainline OpenSBI supports the C906 out of the box, but it needs a few tweaks
# and a new reset driver for the sunxi watchdog.
SRCREV = "b9125c6f8909d1cc0417795737fc13cb6297ff11"
SRC_URI = "git://github.com/smaeul/opensbi.git;branch=d1-wip \
           file://0001-Makefile-Don-t-specify-mabi-or-march.patch \
          "

EXTRA_OEMAKE += "CROSS_COMPILE=${TARGET_PREFIX} FW_PIC=y"

do_install() {
    autotools_do_install
}

INSANE_SKIP_${PN} += "ldflags"