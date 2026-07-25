# networkmanager_%.bbappend
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://eth0.nmconnection"

do_install:append() {
    # Create the destination directory if it doesn't exist
    install -d ${D}${sysconfdir}/NetworkManager/system-connections

    # Install the connection file with strict 0600 permissions
    install -m 0600 ${UNPACKDIR}/eth0.nmconnection ${D}${sysconfdir}/NetworkManager/system-connections/eth0.nmconnection
}

# Ensure the file is tracked in the main networkmanager package
FILES:${PN} += "${sysconfdir}/NetworkManager/system-connections/eth0.nmconnection"
