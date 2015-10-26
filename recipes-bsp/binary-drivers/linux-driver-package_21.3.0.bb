DESCRIPTION = "NVIDIA Linux Driver Packages"
HOMEPAGE = "https://developer.nvidia.com/"
LICENSE = "CLOSED"

SRC_URI = "http://developer.download.nvidia.com/embedded/L4T/r21_Release_v3.0/Tegra124_Linux_R21.3.0_armhf.tbz2 \
           file://ld.so.conf \
           file://nv.conf \
           file://xorg.conf.add"

#SRC_URI = "file://Tegra124_Linux_R21.3.0_armhf.tbz2 \
#           file://ld.so.conf \
#           file://nv.conf \
#           file://xorg.conf.add"

SRC_URI[md5sum] = "5e875672c09451393e447169d3d97cc7"
SRC_URI[sha256sum] = "0643f2eb3532eebbb066c75d5616f1d0014576f515062700347de9d799cf2e90"

PR = "r2" 

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
    ln -sf ./libcuda.so.1.1 ${D}/usr/lib/arm-linux-gnueabihf/tegra/libcuda.so
    ln -sf ./arm-linux-gnueabihf/tegra/libcuda.so ${D}/usr/lib/libcuda.so
    ln -sf ./arm-linux-gnueabihf/tegra/libGL.so.1 ${D}/usr/lib/libGL.so
    cp ${S}/etc/asound* ${D}/etc/
    cp -r ${S}/etc/udev ${D}/etc/
    mkdir ${D}/etc/X11/ 
    cp ${S}/etc/X11/xorg.conf* ${D}/etc/X11/
    cat ${S}/etc/X11/xorg.conf.jetson-tk1 ${WORKDIR}/xorg.conf.add > ${D}/etc/X11/xorg.conf.jetson-tk1
    cp ${WORKDIR}/ld.so.conf ${D}/etc/
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
