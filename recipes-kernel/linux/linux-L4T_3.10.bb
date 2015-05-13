SECTION = "kernel"
DESCRIPTION = "Linux For Tegra R21.3.0 Kernel recipe."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
KERNEL_IMAGETYPE = "zImage"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/kernel"

PR = "r21.3.0"
SRC_URI = "http://developer.download.nvidia.com/embedded/L4T/r21_Release_v3.0/sources/kernel_src.tbz2 \
           file://0001-kernel-add-support-for-gcc-5.patch \
           file://0001-ARM-8158-1-LLVMLinux-use-static-inline-in-ARM-ftrace.patch \
           file://gcc5.patch \
	   file://defconfig_fhandle.patch \
           file://defconfig"

SRC_URI[md5sum] = "5e875672c09451393e447169d3d97cc7"
SRC_URI[sha256sum] = "0643f2eb3532eebbb066c75d5616f1d0014576f515062700347de9d799cf2e90"

KERNEL_DEVICETREE = "tegra124-jetson_tk1-pm375-000-c00-00.dtb"
