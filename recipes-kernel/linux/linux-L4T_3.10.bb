SECTION = "kernel"
DESCRIPTION = "Linux For Tegra R21.1.0 Kernel recipe."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
KERNEL_IMAGETYPE = "zImage"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/kernel"

PR = "r21.1.0"
SRC_URI = "http://developer.download.nvidia.com/mobile/tegra/l4t/r21.1.0/sources/kernel_src.tbz2 \
           file://defconfig"

SRC_URI[md5sum] = "beffd0ca511918abc09bcace4bc68e24"
SRC_URI[sha256sum] = "3343ece79449c96721b32bf22d1ec9316d37504676b8b1275745a5271baf8f88"

KERNEL_DEVICETREE = "tegra124-jetson_tk1-pm375-000-c00-00.dtb"
