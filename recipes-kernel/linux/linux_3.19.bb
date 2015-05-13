# Copyright (C) 2015 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Tegra kernel"
HOMEPAGE = "http://github.com/Gnurou/linux.git"
LICENSE = "GPL-2.0"
SECTION = "kernel"

require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/Gnurou/linux.git;protocol=https;bareclone=1;branch=${KBRANCH}"

KBRANCH = "drm"

LINUX_VERSION ?= "3.19"

SRCREV="${AUTOREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_jetson-tk1 = "jetson-tk1"
COMPATIBLE_MACHINE_jetson-tk1-l4t = "jetson-tk1-l4t"


KBUILD_DEFCONFIG = "tegra_defconfig"
