FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

DEPENDS += "linux-driver-package "

SRC_URI += "file://tegra-path-add.pcp "

do_install_append() {
   cd ${D}
   patch -p1 < ${WORKDIR}/tegra-path-add.pcp

}
