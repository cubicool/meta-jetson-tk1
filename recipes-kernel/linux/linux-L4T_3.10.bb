SECTION = "kernel"
DESCRIPTION = "Linux For Tegra R21.4.0 Kernel recipe."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
KERNEL_IMAGETYPE = "zImage"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

DEFAULT_PREFERENCE = "-1"

COMPATIBLE_MACHINE = "(jetson-tk1|jetson-tk1-l4t)"

S = "${WORKDIR}/kernel"

PR = "r21.4.0"
SRC_URI = "http://developer.download.nvidia.com/embedded/L4T/r21_Release_v4.0/source/kernel_src.tbz2 \
           file://0001-kernel-add-support-for-gcc-5.patch \
           file://0001-ARM-8158-1-LLVMLinux-use-static-inline-in-ARM-ftrace.patch \
           file://gcc5.patch \
           file://defconfig_fhandle.patch \
           file://defconfig"

SRC_URI[md5sum] = "bf17f67bbb68cb296d37ff03fa9fde5e"
SRC_URI[sha256sum] = "737f01305c3fb870eed68c3835728ce3f188052d9c8f321fe69efd1d0f9a455e"

KERNEL_DEVICETREE = "tegra124-jetson_tk1-pm375-000-c00-00.dtb"
