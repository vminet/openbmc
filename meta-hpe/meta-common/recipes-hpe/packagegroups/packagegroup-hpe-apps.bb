SUMMARY = "OpenBMC for HPE - Applications"
PR = "r1"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
        ${PN}-chassis \
        ${PN}-fans \
        ${PN}-flash \
        ${PN}-system \
        "

PROVIDES += "virtual/obmc-chassis-mgmt"
PROVIDES += "virtual/obmc-fan-mgmt"
PROVIDES += "virtual/obmc-flash-mgmt"
PROVIDES += "virtual/obmc-system-mgmt"

RPROVIDES_${PN}-chassis += "virtual-obmc-chassis-mgmt"
RPROVIDES_${PN}-fans += "virtual-obmc-fan-mgmt"
RPROVIDES_${PN}-flash += "virtual-obmc-flash-mgmt"
RPROVIDES_${PN}-system += "virtual-obmc-system-mgmt"

SUMMARY_${PN}-chassis = "HPE Chassis"
RDEPENDS_${PN}-chassis = " \
        obmc-host-failure-reboots \
        x86-power-control \
        "

SUMMARY_${PN}-fans = "HPE Fans"
RDEPENDS_${PN}-fans = " \
        phosphor-pid-control \
        "

SUMMARY_${PN}-flash = "HPE Flash"
RDEPENDS_${PN}-flash = " \
        phosphor-software-manager \
        "

SUMMARY_${PN}-system = "HPE System"
RDEPENDS_${PN}-system = " \
        bmcweb \
        webui-vue \
        dbus-sensors \
        gxp-dbus-sensors \
        entity-manager \
        gxp-fru-device \
        phosphor-image-signing \
        ethernet-mac-setting \
        host-boot-enable \
        phosphor-sel-logger \
        uid-btn \
	gxp-chif-service \
	first-boot-set-hostname \
        "
