DESCRIPTION = "NVIDIA Linux Bootloader config"
HOMEPAGE = "https://developer.nvidia.com/"
LICENSE = "CLOSED"
SECTION = "base"

SRC_URI = "file://jetson-tk1_extlinux.conf.sdcard"
PR = "r0" 

PACKAGE_ARCH = "${MACHINE_ARCH}"

PACKAGES = "${PN}"
FILES_${PN} = "/boot/extlinux/*"

do_install () {
    mkdir ${D}/boot
    mkdir ${D}/boot/extlinux
    cp ${WORKDIR}/jetson-tk1_extlinux.conf.sdcard ${D}/boot/extlinux/extlinux.conf
}
