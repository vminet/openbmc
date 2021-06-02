SUMMARY = "gxp-chif-service"
DESCRIPTION = "CHIF service"

SRC_URI = "git://github.com/HewlettPackard/openbmc-chif-svc.git;branch=main"
SRCREV = "${AUTOREV}"

PV = "0.1+git${SRCPV}"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SYSTEMD_SERVICE_${PN} += " xyz.openbmc_project.GxpChif.service"

S = "${WORKDIR}/git"
inherit cmake systemd

EXTRA_OECMAKE = ""
