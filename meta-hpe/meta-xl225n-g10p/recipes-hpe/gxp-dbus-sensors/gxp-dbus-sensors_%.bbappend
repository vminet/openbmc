SYSTEMD_SERVICE_${PN}_remove = "xyz.openbmc_project.GxpFanSensor.service"

do_install_append() {
        rm ${D}/usr/bin/gxpfansensor
        rm ${D}/lib/systemd/system/xyz.openbmc_project.GxpFanSensor.service
}

