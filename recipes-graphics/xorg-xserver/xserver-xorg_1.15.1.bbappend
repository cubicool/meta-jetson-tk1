# The NVidia driver needs this enabled.
EXTRA_OECONF += " --enable-xinerama --disable-glx "

PACKAGECONFIG[glx] = ""
