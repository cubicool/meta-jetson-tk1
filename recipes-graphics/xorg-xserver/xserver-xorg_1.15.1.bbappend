# The NVidia driver needs this enabled.
EXTRA_OECONF += " --enable-xinerama "

PACKAGECONFIG_jetson-tk1-l4t := "${@oe_filter_out('glx', '${PACKAGECONFIG}', d)}"

