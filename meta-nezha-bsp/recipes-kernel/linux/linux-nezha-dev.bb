require recipes-kernel/linux/linux-mainline-common.inc
FILESEXTRAPATHS:prepend = "${FILE_DIRNAME}/linux-nezha:"
SUMMARY = "Nezha dev kernel recipe"

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
KERNEL_VERSION_SANITY_SKIP = "1"

SRCREV = "012f5a3d01be6d44e32c74bb3637ec281790b297"
FORK ?= "Cezarus27"
BRANCH ?= "riscv/d1-wip"
SRC_URI = "git://github.com/${FORK}/linux.git;protocol=git;branch=${BRANCH} \
           file://enable-autofs4.cfg \
           file://enable-cgroups.cfg \
          "

LINUX_VERSION ?= "5.14.0-rc4"
LINUX_VERSION_EXTENSION:append = "-nezha"

KBUILD_DEFCONFIG:nezha-allwinner-d1 = "nezha_defconfig"

COMPATIBLE_MACHINE = "(nezha-allwinner-d1)"
