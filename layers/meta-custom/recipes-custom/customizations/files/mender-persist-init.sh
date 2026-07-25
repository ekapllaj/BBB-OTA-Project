#!/bin/sh
set -e

# list of folders we want to bind mount.
FOLDER_LIST="ssh NetworkManager mender"
mkdir -p /data/etc
for folder in $FOLDER_LIST
do
	if [ ! -d /data/etc/$folder ]; then
		echo "Missing $folder on data partition, initializing..."
		cp -a /etc/$folder /data/etc/
	fi
	# bind mount the folder:
	mount --bind /data/etc/$folder /etc/$folder
done
