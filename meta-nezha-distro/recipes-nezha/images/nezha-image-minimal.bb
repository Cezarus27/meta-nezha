DESCRIPTION = "nezha image"

IMAGE_FEATURES += " \
    ssh-server-openssh \
    debug-tweaks \
"

IMAGE_INSTALL:append = " \
    packagegroup-nezha-tools \
    packagegroup-nezha-test \
    packagegroup-nezha-network \
    packagegroup-nezha-python \
    linux-firmware \
"

LICENSE = "MIT"

inherit core-image
