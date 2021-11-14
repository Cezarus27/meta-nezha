# meta-nezha

## Description

This repository is a Yocto Project meta layer that provides early support for a
`RISC-V` based board called Nezha. It is an educational project prepared as the
main part of a master's project.

## How to build

To build `nezha-image-minimal` you should run command below:
```
$ SHELL=bash kas-docker build meta-nezha/kas/nezha-minimal.yml
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

## Current status

### 14.11.2021

* `u-boot` problem fixed with patch:
  ```
  meta-nezha-bsp/recipes-bsp/u-boot/files/0001-sun20i-set-CONFIG_SYS_BOOTM_LEN.patch
  ```

* `kernel` is booting to this moment:
  ```
  [  OK  ] Started Network Time Synchronization.
  [   10.353220] status: 0000000200004020 badaddr: 0000003fd4000028 cause: 0000000000000007
  [   10.370102] dwmac-sun8i 4500000.ethernet eth0: No Safety Features support found
  [   10.448256] dwmac-sun8i 4500000.ethernet eth0: No MAC Management Counters available
  [   10.503685] dwmac-sun8i 4500000.ethernet eth0: PTP not supported by HW
  [   10.534405] dwmac-sun8i 4500000.ethernet eth0: configuring for phy/rgmii-id link mode
  [   10.553997] systemd[137]: unhandled signal 11 code 0x2 at 0x0000003fe0828330 in libpthread-2.33.so[3fe0821000+13000]
  [   10.567104] systemd[136]: unhandled signal 11 code 0x2 at 0x0000003fe0779378 in libc-2.33.so[3fe0716000+fd000]
  [   10.597724] CPU: 0 PID: 136 Comm: systemd Not tainted 5.14.0-rc4-nezha #1
  [   10.604928] CPU: 0 PID: 137 Comm: systemd Not tainted 5.14.0-rc4-nezha #1
  [   10.637736] Hardware name: Allwinner D1 NeZha (DT)
  [   10.642948] Hardware name: Allwinner D1 NeZha (DT)
  [   10.654528] epc : 0000003fe0779378 ra : 0000003fe0779338 sp : 0000003fe05c93f0
  [   10.665745] epc : 0000003fe0828330 ra : 0000003fe082830a sp : 0000003fdfdc87a0
  [   10.689723]  gp : 0000002ae8eb3250 tp : 0000003fe05ca820 t0 : 0000000000003345
  [   10.697357]  gp : 0000002ae8eb3250 tp : 0000003fdfdc9820 t0 : 0000000000003345
  [   10.721794]  t1 : 0000003fe07397bc t2 : 00000000000067c2 s0 : 0000003fd8000020
  [   10.729494]  t1 : 0000003fe0826eac t2 : 00000000000067c2 s0 : 0000003fdfdc88e0
  [   10.753742]  s1 : 0000003fe0819b00 a0 : 0000003fd8000000 a1 : 0000000000021000
  [   10.761437]  s1 : 0000003fdfdc949c a0 : 0000000000000000 a1 : 0000003fdfdc9770
  [   10.777739]  a2 : 0000000000000003 a3 : 0000000000004022 a4 : 0000003fd8000870
  [   10.785464]  a2 : 0000000000000000 a3 : 0000000000000008 a4 : 0000000000000000
  [   10.809723]  a5 : 0000003fd8000028 a6 : 0000000000000000 a7 : fffffffffffff000
  [   10.817360]  a5 : 0000000000000000 a6 : 0000003fdfdc9150 a7 : 0000000000000087
  [   10.841741]  s2 : 0000003fd8000000 s3 : 00000000000008c8 s4 : 0000000000000006
  [   10.849390]  s2 : 0000003fffd393b6 s3 : 0000003fffd393b7 s4 : 0000000000000000
  [   10.873743]  s5 : 0000000000000000 s6 : 0000003fffd394f0 s7 : 0000003fe0a8b2b0
  [   10.881403]  s5 : 0000000000000006 s6 : 0000003fffd394f0 s7 : 0000003fdfdc9820
  [   10.897746]  s8 : 0000003fe05ca080 s9 : 0000000000000000 s10: 0000003fe0839380
  [   10.905404]  s8 : 0000003fdfdc9080 s9 : 0000000000000000 s10: 0000003fe0839380
  [   10.929745]  s11: 0000003fe0835328 t3 : 0000003fe077ad08 t4 : 00000000001e4880
  [   10.937537]  s11: 0000003fe0835328 t3 : 0000003fe07486d4 t4 : 00000000001e4880
  [   10.953734]  t5 : 3ad4452ba5245643 t6 : 0000000000000072
  [   10.965739]  t5 : 3ad4452ba5245643 t6 : 0000000000000072
  [   10.981692] status: 0000000200004020 badaddr: 0000003fd8000028 cause: 0000000000000007
  [   10.990013] status: 0000000200004020 badaddr: 0000003fdfdc949c cause: 0000000000000007
  [   11.016415] Kernel panic - not syncing: Attempted to kill init! exitcode=0x0000000b
  [   11.024081] CPU: 0 PID: 1 Comm: systemd Not tainted 5.14.0-rc4-nezha #1
  [   11.030694] Hardware name: Allwinner D1 NeZha (DT)
  [   11.035481] Call Trace:
  [   11.037928] [<ffffffff80003bc8>] walk_stackframe+0x0/0xc8
  [   11.043342] [<ffffffff80594274>] panic+0x124/0x308
  [   11.048142] [<ffffffff8000cfa0>] do_exit+0x834/0x878
  [   11.053112] [<ffffffff8000d054>] do_group_exit+0x30/0xc0
  [   11.058428] [<ffffffff800185d4>] get_signal+0x190/0x798
  [   11.063667] [<ffffffff80002f58>] do_notify_resume+0x78/0x408
  [   11.069333] [<ffffffff80001f08>] ret_from_syscall_rejected+0x8/0xc
  [   11.075526] ---[ end Kernel panic - not syncing: Attempted to kill init! exitcode=0x0000000b ]---
  ```

### 13.11.2021

All code, for now, is at the `develop` branch. At this moment `build` process
passes but the image **not running** at the board.

* `u-boot` can't uncompress the `fitImage`:
  ```
  Error: inflate() returned -5
  gzip compressed: uncompress error -1
  ```
