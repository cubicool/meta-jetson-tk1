DESCRIPTION = "NVIDIA Linux Driver Packages"
HOMEPAGE = "https://developer.nvidia.com/"
LICENSE = "CLOSED"

SRC_URI = "http://developer.download.nvidia.com/mobile/tegra/l4t/r21.1.0/Tegra124_Linux_R21.1.0_armhf.tbz2 \
           file://ld.so.conf"

#SRC_URI = "file://Tegra124_Linux_R21.1.0_armhf.tbz2 \
#           file://ld.so.conf"

SRC_URI[md5sum] = "53335e0500a4ae735405011a9d8bef74"
SRC_URI[sha256sum] = "fe068c12a4e2c38ae0400c67a97552ef85c2786a579e5dcfaf36992e41a46801"

PR = "r0" 

DEPENDS = "virtual/libx11 alsa-lib libxext"

INSANE_SKIP_${PN} = "ldflags"

PACKAGE_ARCH = "${MACHINE_ARCH}"

S = "${WORKDIR}/l4tdrv"


PACKAGES =+ "${PN}-firmware"

INSANE_SKIP_${PN}-dev = "ldflags"

FILES_${PN} =  "${bindir}/* ${libdir}/* ${sysconfdir}/* ${sysconfdir}/*/*"
RRECOMMENDS_${PN} = "xserver-xorg-module-libwfb"

FILES_${PN}-firmware = "${base_libdir}/firmware/* ${base_libdir}/firmware/tegra12x/* "

INHIBIT_PACKAGE_STRIP = "1"
#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

INSANE_SKIP_${PN} += "dev-so"

do_compile () {
    tar xjf ${WORKDIR}/Linux_for_Tegra/nv_tegra/config.tbz2 -C ${S}
}

do_install () {
    tar xjf ${WORKDIR}/Linux_for_Tegra/nv_tegra/nvidia_drivers.tbz2 -C ${D}
    cp ${S}/etc/asound* ${D}/etc/
    cp -r ${S}/etc/udev ${D}/etc/
    mkdir ${D}/etc/X11/
    cp ${S}/etc/X11/xorg.conf* ${D}/etc/X11/
    cp ${WORKDIR}/ld.so.conf ${D}/etc/
}

