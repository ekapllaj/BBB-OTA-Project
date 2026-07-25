# base-files_%.bbappend

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://dot.bashrc"

do_install:append() {
    # Install the bashrc to the root user's home directory path
    install -d ${D}${ROOT_HOME}
    install -m 0644 ${UNPACKDIR}/dot.bashrc ${D}${ROOT_HOME}/.bashrc
}

# Ensure the file is captured by the base-files package tracking
FILES:${PN} += "${ROOT_HOME}/.bashrc"
