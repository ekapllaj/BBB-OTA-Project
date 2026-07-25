SUMMARY = "RTL88X2BU WiFi driver"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module

PR = "r0"

BRANCH = "5.8.7.1_35809.20191129_COEX20191120-7777"
SRC_URI = " \
    git://github.com/cilynx/rtl88x2bu.git;protocol=https;branch=${BRANCH} \
    file://makefile.patch \
"
SRCREV = "fc158d1f71b9e5dfcd1fccaf4d28725b65086e3b"

# Automatically load the driver on target boot
KERNEL_MODULE_AUTOLOAD += "88x2bu"

# Environment mapping for the rtl88x2bu Makefile
export KSRC = "${STAGING_KERNEL_BUILDDIR}"
export KBASE = "${STAGING_KERNEL_BUILDDIR}"
export KVER = "${KERNEL_VERSION}"
export MODDESTDIR = "${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless"

# Standard manual installation since the custom Makefile lacks typical module targets
do_install() {
    install -d ${MODDESTDIR}
    install -m 0644 ${S}/88x2bu.ko ${MODDESTDIR}/
}

ALLOW_EMPTY:${PN} = "1"
RDEPENDS:${PN} += "kernel-module-88x2bu-${KERNEL_VERSION}"
