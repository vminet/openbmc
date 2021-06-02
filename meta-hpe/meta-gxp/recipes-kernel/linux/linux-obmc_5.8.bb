KBRANCH ?= "dev-5.8-gxp-openbmc"
LINUX_VERSION ?= "5.8.17"
SRCREV="29d3ce4f8c9e6de1a0cc24c6f640cb8adec65252"

require linux-obmc.inc
require conf/machine/include/fitimage-sign.inc

# OpenBMC loads in kernel features via other mechanisms so this check
# in the kernel-yocto.bbclass is not required
#KERNEL_DANGLING_FEATURES_WARN_ONLY="1"
