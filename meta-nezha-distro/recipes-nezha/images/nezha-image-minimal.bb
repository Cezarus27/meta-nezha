DESCRIPTION = "nezha image"

IMAGE_FEATURES += " \
    ssh-server-openssh \
    debug-tweaks \
"

IMAGE_INSTALL_append = " \
    packagegroup-nezha-test \
    packagegroup-nezha-network \
"

LICENSE = "MIT"

inherit core-image
