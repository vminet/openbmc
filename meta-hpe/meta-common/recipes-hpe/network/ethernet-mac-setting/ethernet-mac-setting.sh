#!/bin/sh

if [ "$1" == "0" ]; then
  mac=`busctl get-property xyz.openbmc_project.GxpFruDevice /xyz/openbmc_project/FruDevice/HPE xyz.openbmc_project.FruDevice MAC0 | cut -c 4-20`
elif [ "$1" == "1" ]; then
  echo 2 > /sys/class/soc/xreg/sideband_sel  >/dev/null 2>&1
  mac=`busctl get-property xyz.openbmc_project.GxpFruDevice /xyz/openbmc_project/FruDevice/HPE xyz.openbmc_project.FruDevice MAC1 | cut -c 4-20`
fi

if [ `echo $mac | egrep "^([a-fA-F0-9]{2}:){5}[a-fA-F0-9]{2}$"` ]
then
        echo "eth$1:set mac addr to $mac"
        ifconfig eth$1 down
        ifconfig eth$1 hw ether $mac
else
        echo "eth$1:invalid mac addr"
fi

