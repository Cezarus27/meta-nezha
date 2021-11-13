# meta-nezha

## Description

This repository is a Yocto Project meta layer that provides early support for a
`RISC-V` based board called Nezha. It is an educational project prepared as the
main part of a master's project.

## Current status

### 13.11.2021

All code, for now, is at the `develop` branch. At this moment `build` process
passes but the image **not running** at the board.

* `u-boot` can't uncompress the `fitImage`:
  ```
  Error: inflate() returned -5
  gzip compressed: uncompress error -1
  ```

## Software BoM

### Meta layers

* [poky](https://git.yoctoproject.org/git/poky)

* [meta-openembedded](https://git.openembedded.org/meta-openembedded)

* [meta-riscv](https://github.com/riscv/meta-riscv.git)

### Key repositories

`meta-nezha-bsp` layer contains custom recipes for `u-boot`, `Linux`, `OpenSBI`
and `boot0` which use a version patched / created by **smaeul**:

* [OpenSBI](https://github.com/smaeul/opensbi): `d1-wip` branch

* [u-boot](https://github.com/smaeul/u-boot): `d1-wip` branch

* [Linux](https://github.com/smaeul/linux/commits/riscv/d1-wip): `riscv/d1-wip`
  branch

* [boot0](https://github.com/smaeul/sun20i_d1_spl): `mainline` branch
