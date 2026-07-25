
CLONE_DIR="../../layers"
mkdir $CLONE_DIR
branch="wrynose"
cd $CLONE_DIR
git clone https://git.openembedded.org/bitbake -b 2.18
git clone https://github.com/mendersoftware/meta-mender -b $branch 
git clone https://github.com/mendersoftware/meta-mender-community -b $branch 
git clone https://github.com/openembedded/meta-openembedded.git -b $branch
git clone https://git.openembedded.org/openembedded-core -b $branch 
git clone https://git.yoctoproject.org/meta-yocto -b $branch
cd -
