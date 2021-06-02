LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

# TODO:  Manually copy the U-Boot signing key here:
HPE_GXP_KEY_FILES_DIR = "${COREBASE}/meta-hpe/meta-gxp/recipes-bsp/image/files"

SRC_URI = "git://github.com/HewlettPackard/gxp-bootblock.git;branch=master"
SRCREV = "bab416f8ca8c8465d308cfeb7f8d5abc21ba343b"
S = "${WORKDIR}/git"

inherit deploy

do_deploy () {
  install -d ${DEPLOYDIR}

  # Copy in the bootblock
  install -m 644 gxp-bootblock.bin ${DEPLOYDIR}/gxp-bootblock.bin

  # Copy in files from the files subdirectory
  install -m 644 ${HPE_GXP_KEY_FILES_DIR}/header.sig ${DEPLOYDIR}/hpe-uboot-header.section
}

addtask deploy before do_build after do_compile

