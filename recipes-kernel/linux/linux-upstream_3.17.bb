SECTION = "kernel"
DESCRIPTION = "Linux upstream kernel 3.17.4"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
KERNEL_IMAGETYPE = "zImage"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

DEFAULT_PREFERENCE = "-1"

BRANCH = "linux-3.17.y"

PR = "r0"
SRCREV = "80f36e65007f232cc15cfa67193c21f2ead01fd8"
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${BRANCH} \
           file://defconfig"

S = "${WORKDIR}/git"

KERNEL_DEVICETREE_jetson-tk1 = "tegra124-jetson-tk1.dtb"
