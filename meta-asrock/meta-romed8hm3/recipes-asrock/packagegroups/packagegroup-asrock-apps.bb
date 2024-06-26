SUMMARY = "OpenBMC for ASRock - Applications"
PR = "r1"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
        ${PN}-flash \
        ${PN}-system \
        "

PROVIDES += "virtual/obmc-flash-mgmt"
PROVIDES += "virtual/obmc-system-mgmt"

RPROVIDES:${PN}-flash += "virtual-obmc-flash-mgmt"
RPROVIDES:${PN}-system += "virtual-obmc-system-mgmt"

SUMMARY:${PN}-flash = "ASRock Flash"
RDEPENDS:${PN}-flash = " \
        phosphor-ipmi-flash \
        "

SUMMARY:${PN}-system = "ASRock System"
RDEPENDS:${PN}-system = " \
        phosphor-host-postd \
        phosphor-post-code-manager \
        phosphor-power-regulators \
        phosphor-software-manager \
        "
