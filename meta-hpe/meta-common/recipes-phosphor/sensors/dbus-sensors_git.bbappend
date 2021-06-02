# For HPE Proliant servers, fansensor is replaced by GxpFanSensor

SYSTEMD_SERVICE_${PN}_remove = "xyz.openbmc_project.fansensor.service"

do_install_append() {
        rm ${D}/usr/bin/fansensor
        rm ${D}/lib/systemd/system/xyz.openbmc_project.fansensor.service
}