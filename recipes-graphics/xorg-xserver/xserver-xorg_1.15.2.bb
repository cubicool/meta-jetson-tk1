require recipes-graphics/xorg-xserver/xserver-xorg.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=15b5bf9327341c81089137aec4830bfd"

# Misc build failure for master HEAD
SRC_URI += "file://crosscompile.patch \
            file://fix_open_max_preprocessor_error.patch \
            file://mips64-compiler.patch \
            file://xorg-CVE-2013-6424.patch \
            file://xshmfence-option.patch \
            file://present-module.patch \
            file://0001-use-__GLIBC__-guard-for-glibc-specific-code.patch \
            file://arm-no-inx-outx.patch \
           "
SRC_URI[md5sum] = "69229fe5cdf3f20f74665d57b7601d26"
SRC_URI[sha256sum] = "3c0585607c654ded836da43a45a75492fc13454ff4149704fb08dac39f051163"

# These extensions are now integrated into the server, so declare the migration
# path for in-place upgrades.

RREPLACES_${PN} =  "${PN}-extension-dri \
                    ${PN}-extension-dri2 \
                    ${PN}-extension-record \
                    ${PN}-extension-extmod \
                    ${PN}-extension-dbe \
                   "
RPROVIDES_${PN} =  "${PN}-extension-dri \
                    ${PN}-extension-dri2 \
                    ${PN}-extension-record \
                    ${PN}-extension-extmod \
                    ${PN}-extension-dbe \
                   "
RCONFLICTS_${PN} = "${PN}-extension-dri \
                    ${PN}-extension-dri2 \
                    ${PN}-extension-record \
                    ${PN}-extension-extmod \
                    ${PN}-extension-dbe \
                   "
