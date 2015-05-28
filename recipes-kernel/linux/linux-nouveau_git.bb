# Copyright (C) 2015 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Tegra kernel"
HOMEPAGE = "http://github.com/Gnurou/linux.git"
LICENSE = "GPL-2.0"
SECTION = "kernel"

require recipes-kernel/linux/linux-yocto.inc

SRC_URI = "git://github.com/Gnurou/linux.git;protocol=https;bareclone=1;branch=${KBRANCH}"

KBRANCH = "staging/nouveau"

SRCREV = "12c466def1571ed53c33d06e5c8fe1068b342391"

LINUX_VERSION ?= "4.0"

SRCREV="${AUTOREV}"

COMPATIBLE_MACHINE = "(jetson-tk1|jetson-tk1-l4t)"

PV = "${LINUX_VERSION}+git${SRCPV}"

COMPATIBLE_MACHINE_jetson-tk1 = "jetson-tk1"
COMPATIBLE_MACHINE_jetson-tk1-l4t = "jetson-tk1-l4t"


KBUILD_DEFCONFIG = "tegra_defconfig"
