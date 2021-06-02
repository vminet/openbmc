SUMMARY = "recovery-image-validator"
DESCRIPTION = "Small program to validate the MTD signature"

SRC_URI = "git://github.com/HewlettPackard/openbmc-chksig.git;branch=main"
SRCREV = "85eb37b2a0d653553ebb01c4fbd04b7627c3d2a2"

PV = "0.1+git${SRCPV}"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

INSECURE_KEY = "${@'${SIGNING_KEY}' == '${STAGING_DIR_NATIVE}${datadir}/OpenBMC.priv'}"
DEPENDS += "openssl-native"
DEPENDS += "${@oe.utils.conditional('INSECURE_KEY', 'True', 'phosphor-insecure-signing-key-native', '', d)}"

S =  "${WORKDIR}/git"
inherit cmake 

SIGNING_KEY ?= "${STAGING_DIR_NATIVE}${datadir}/OpenBMC.priv"
SIGNING_KEY_TYPE = "${@os.path.splitext(os.path.basename('${SIGNING_KEY}'))[0]}"

do_install () {
	install -d ${D}${base_sbindir}
	install -m 755 ${B}/check_signature ${D}${base_sbindir}/check_signature

	openssl pkey -in "${SIGNING_KEY}" -pubout -out ${WORKDIR}/publickey

	idir="${D}${sysconfdir}/activationdata/${SIGNING_KEY_TYPE}"
	install -d ${idir}
	install -m 644 ${WORKDIR}/publickey ${idir}
}
