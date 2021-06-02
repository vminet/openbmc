SUMMARY = "gxp-fru-device"
DESCRIPTION = "Export the HPE board's FRU info to a dbus object with xyz.openbmc_project.FruDevice interface"

SRC_URI = "git://github.com/HewlettPackard/openbmc-gxp-fru-device.git;branch=main"
SRCREV = "${AUTOREV}"

PV = "0.1+git${SRCPV}"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "boost nlohmann-json sdbusplus i2c-tools libgpiod valijson"

SYSTEMD_SERVICE_${PN} += " xyz.openbmc_project.GxpFruDevice.service"

S = "${WORKDIR}/git"
inherit cmake systemd

EXTRA_OECMAKE = ""
