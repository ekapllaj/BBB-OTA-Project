SUMMARY = "Systemd bind-mounts for persistent configuration on /data"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit systemd

SRC_URI = " \
    file://mender-persist-init.sh \
    file://mender-persist-init.service \
"

SYSTEMD_SERVICE:${PN} = " \
    mender-persist-init.service \
"

do_install() {
    # Install helper script
    install -d ${D}${bindir}
    install -m 0755 ${UNPACKDIR}/mender-persist-init.sh ${D}${bindir}/mender-persist-init.sh

    # Install systemd units
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${UNPACKDIR}/mender-persist-init.service ${D}${systemd_system_unitdir}/

    # Crucial: Create empty placeholder mount-points in the rootfs
    install -d ${D}${sysconfdir}/ssh
    install -d ${D}${sysconfdir}/NetworkManager/system-connections
}

FILES:${PN} += " \
    ${bindir}/mender-persist-init.sh \
    ${systemd_system_unitdir} \
    ${sysconfdir}/ssh \
    ${sysconfdir}/NetworkManager/system-connections \
"
