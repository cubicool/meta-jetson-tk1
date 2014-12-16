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

PR = "r21.2.0"
SRC_URI = "http://developer.download.nvidia.com/mobile/tegra/l4t/r21.2.0/sources/kernel_src.tbz2 \
           file://defconfig"

SRC_URI[md5sum] = "886c6ed6d4e5bdefeca8c6da1caeb261"
SRC_URI[sha256sum] = "ebd8e71d76c1f9d4266899573336fd04944c0ef02d549866ad53e243662a25ec"

KERNEL_DEVICETREE = "tegra124-jetson_tk1-pm375-000-c00-00.dtb"
