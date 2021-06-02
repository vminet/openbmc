#!/bin/sh -eu

show_error() {
    echo "$@" >&2
}

sync_hostname() {
    mac=`busctl get-property xyz.openbmc_project.GxpFruDevice /xyz/openbmc_project/FruDevice/HPE xyz.openbmc_project.FruDevice MAC0 | cut -c 4-20`
    hostnamectl set-hostname $(hostname)-${mac}
}

[ "$(hostname)" = "{MACHINE}" ] && sync_hostname

systemctl disable first-boot-set-hostname.service
