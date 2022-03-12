# Mainline OpenSBI supports the C906 out of the box, but it needs a few tweaks
# and a new reset driver for the sunxi watchdog.
SRCREV = "c9024b561c01aa469bed3c2266d78e6ae76882ff"
SRC_URI = "git://github.com/tekkamanninja/opensbi.git;branch=allwinner_d1 \
          "

EXTRA_OEMAKE += "CROSS_COMPILE=${TARGET_PREFIX} FW_PIC=y"

do_install() {
    autotools_do_install
}

INSANE_SKIP_${PN} += "ldflags"
