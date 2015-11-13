FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += "\
           file://0001-compositor-drm-Add-new-gbm-struct-to-allow-for-a-sep.patch \
           file://0002-compositor-drm-Add-support-for-Tegra-Jetson-TK1.patch \
"
