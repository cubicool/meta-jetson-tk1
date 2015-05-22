DESCRIPTION = "NVIDIA Linux Driver Packages"
HOMEPAGE = "https://developer.nvidia.com/"
LICENSE = "CLOSED"

SRC_URI = "http://developer.download.nvidia.com/mobile/tegra/l4t/r21.2.0/pm375_release_armhf/Tegra124_Linux_R21.2.0_armhf.tbz2 \
           file://nv.conf \
           file://xorg.conf.add"

#SRC_URI = "file://Tegra124_Linux_R21.2.0_armhf.tbz2 \
#           file://ld.so.conf \
#           file://nv.conf \
#           file://xorg.conf.add"

SRC_URI[md5sum] = "886c6ed6d4e5bdefeca8c6da1caeb261"
SRC_URI[sha256sum] = "ebd8e71d76c1f9d4266899573336fd04944c0ef02d549866ad53e243662a25ec"

PR = "r1" 

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
    cat ${S}/etc/X11/xorg.conf.jetson-tk1 ${WORKDIR}/xorg.conf.add > ${D}/etc/X11/xorg.conf.jetson-tk1
    mkdir ${D}/etc/init.d/
    mkdir ${D}/etc/rcS.d/
    cp ${WORKDIR}/nv.conf ${D}/etc/init.d
    ln -s /etc/init.d/nv.conf ${D}/etc/rcS.d/S40nv
}

do_populate_sysroot () {
    tar xjf ${WORKDIR}/Linux_for_Tegra/nv_tegra/nvidia_drivers.tbz2 -C ${WORKDIR}/sysroot-destdir/
    rm ${WORKDIR}/sysroot-destdir/usr/lib/xorg/modules/extensions/libglx.so
    mkdir ${WORKDIR}/sysroot-destdir/sysroot-providers
    touch ${WORKDIR}/sysroot-destdir/sysroot-providers/${PN}
}
