DESCRIPTION = "nezha image"

IMAGE_FEATURES += " \
    ssh-server-openssh \
    debug-tweaks \
"

IMAGE_INSTALL_append = " \
    packagegroup-nezha-tools \
    packagegroup-nezha-test \
    packagegroup-nezha-network \
    packagegroup-nezha-python \
    linux-firmware \
"

LICENSE = "MIT"

inherit core-image
