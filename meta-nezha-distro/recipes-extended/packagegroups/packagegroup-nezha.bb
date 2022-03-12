SUMMARY = "Nezha support packagegroup"
DESCRIPTION = "Support packagegroups which allow to take advantage of the \
Nezha board features"
PR = "r1"

inherit packagegroup

PACKAGES = " \
    packagegroup-nezha-test \
    packagegroup-nezha-network \
    "

RDEPENDS:${PN}-test = " \
    phoronix-test-suite \
    stressapptest \
    iperf3 \
    "

RDEPENDS:${PN}-network = " \
    networkmanager \
    networkmanager-nmcli \
    xradio \
"
