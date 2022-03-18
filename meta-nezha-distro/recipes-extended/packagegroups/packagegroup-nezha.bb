SUMMARY = "Nezha support packagegroup"
DESCRIPTION = "Support packagegroups which allow to take advantage of the \
Nezha board features"
PR = "r1"

inherit packagegroup

PACKAGES = " \
    ${PN}-tools \
    ${PN}-test \
    ${PN}-network \
    ${PN}-python \
"

RDEPENDS:${PN}-tools = " \
    make \
    gcc \
    binutils \
    binutils-dev \
"

RDEPENDS:${PN}-test = " \
    phoronix-test-suite \
    stressapptest \
    iperf3 \
    stress-ng \
    "

RDEPENDS:${PN}-network = " \
    networkmanager \
    networkmanager-nmcli \
"

RDEPENDS:${PN}-python = " \
    python3 \
    python3-dev \
    python3-pip \
    python3-setuptools \
"
