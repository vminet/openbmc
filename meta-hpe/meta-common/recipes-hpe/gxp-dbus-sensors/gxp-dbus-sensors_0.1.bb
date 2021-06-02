SUMMARY = "gxp-dbus-sensors"
DESCRIPTION = "For exporting GXP sensors to dbus"

SRC_URI = "git://github.com/HewlettPackard/openbmc-gxp-dbus-sensors.git;branch=main"
SRCREV = "${AUTOREV}"

PV = "0.1+git${SRCPV}"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "boost nlohmann-json sdbusplus i2c-tools libgpiod"

SYSTEMD_SERVICE_${PN} += " xyz.openbmc_project.GxpTempSensor.service"
SYSTEMD_SERVICE_${PN} += " xyz.openbmc_project.GxpFanSensor.service"

S =  "${WORKDIR}/git"
inherit cmake systemd

EXTRA_OECMAKE = ""
