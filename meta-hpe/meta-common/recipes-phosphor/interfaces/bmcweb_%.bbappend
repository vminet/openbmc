FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

EXTRA_OEMESON += "-Dhttp-body-limit=36"

SRC_URI += "file://0001-Tweak-DBus-object-path-for-BIOS-factory-reset.patch"

