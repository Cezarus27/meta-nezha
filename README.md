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
  ```log
  [   10.792295] rngd[139]: unhandled signal 11 code 0x2 at 0x0000003fc72e1378 in libc-2.33.so[3fc727e000+fd000]
  [   10.948096] CPU: 0 PID: 139 Comm: rngd Not tainted 5.14.0-rc4-nezha #1
  [   11.051283] Hardware name: Allwinner D1 NeZha (DT)
  [   11.101973] epc : 0000003fc72e1378 ra : 0000003fc72e1338 sp : 0000003fc72766a0
  [   11.185902]  gp : 0000002ab2ca3800 tp : 0000003fc72778f0 t0 : 3434bfb4d190d97e
  [  OK  ] Finished Update is Completed.
  [   11.271992]  t1 : 0000002ab2c9b63c t2 : 7241a979ec7a6232 s0 : 0000003fc0000020
  [   11.342274]  s1 : 0000003fc7381b00 a0 : 0000003fc0000000 a1 : 0000000000021000
  [   11.380126] dwmac-sun8i 4500000.ethernet eth0: PHY [stmmac-0:01] driver [RTL8211F Gigabit Ethernet] (irq=POLL)
  [   11.418634]  a2 : 0000000000000003 a3 : 0000000000004022 a4 : 0000003fc0000870
  [   11.456520] dwmac-sun8i 4500000.ethernet eth0: Register MEM_TYPE_PAGE_POOL RxQ-0
  [   11.504119]  a5 : 0000003fc0000028 a6 : 0000000000000000 a7 : fffffffffffff000
  [   11.545471] dwmac-sun8i 4500000.ethernet eth0: No Safety Features support found
  [   11.578202]  s2 : 0000003fc0000000 s3 : 00000000000008c8 s4 : 0000000000000000
  [   11.652134] dwmac-sun8i 4500000.ethernet eth0: No MAC Management Counters available
  [   11.680441]  s5 : 0000000000000006 s6 : 0000003ffff6f988 s7 : 0000003fc72778f0
  [   11.732134] dwmac-sun8i 4500000.ethernet eth0: PTP not supported by HW
  [   11.742784]  s8 : 0000003fc7277150 s9 : 0000000000000001 s10: 0000003fc73a1380
  [   11.776764] dwmac-sun8i 4500000.ethernet eth0: configuring for phy/rgmii-id link mode
  [   11.792129]  s11: 0000003fc739d328 t3 : 0000003fc72e2d08 t4 : c965677f28d98c6d
  [   11.824305]  t5 : 0000000000000000 t6 : 611318ec7d54a35b
  [   11.848138] status: 0000000200004020 badaddr: 0000003fc0000028 cause: 0000000000000007
  [   11.948165] systemd[142]: unhandled signal 11 code 0x2 at 0x0000003fe938e330 in libpthread-2.33.so[3fe9387000+13000]
  [   11.959545] systemd[141]: unhandled signal 11 code 0x2 at 0x0000003fe92df378 in libc-2.33.so[3fe927c000+fd000]
  [   11.996127] CPU: 0 PID: 142 Comm: systemd Not tainted 5.14.0-rc4-nezha #1
  [   12.003474] CPU: 0 PID: 141 Comm: systemd Not tainted 5.14.0-rc4-nezha #1
  [  OK  ] Started Network Tim[   12.019165] Hardware name: Allwinner D1 NeZha (DT)
  e Synchronizatio[   12.025837] Hardware name: Allwinner D1 NeZha (DT)
  n.
  [   12.044145] epc : 0000003fe92df378 ra : 0000003fe92df338 sp : 0000003fe912f3f0
  [   12.051853] epc : 0000003fe938e330 ra : 0000003fe938e30a sp : 0000003fe892e7a0
  [   12.076148]  gp : 0000002ad1589250 tp : 0000003fe9130820 t0 : 000000000000bb87
  [   12.083846]  gp : 0000002ad1589250 tp : 0000003fe892f820 t0 : 000000000000bb87
  [   12.104131]  t1 : 0000003fe929f7bc t2 : 0000000000004389 s0 : 0000003fe4000020
  [   12.112118]  t1 : 0000003fe938ceac t2 : 0000000000004389 s0 : 0000003fe892e8e0
  [   12.132148]  s1 : 0000003fe937fb00 a0 : 0000003fe4000000 a1 : 0000000000021000
  [   12.144100]  s1 : 0000003fe892f49c a0 : 0000000000000000 a1 : 0000003fe892f770
  [   12.164144]  a2 : 0000000000000003 a3 : 0000000000004022 a4 : 0000003fe4000870
  [   12.171835]  a2 : 0000000000000000 a3 : 0000000000000008 a4 : 0000000000000000
  [   12.196146]  a5 : 0000003fe4000028 a6 : 0000000000000000 a7 : fffffffffffff000
  [   12.203889]  a5 : 0000000000000000 a6 : 0000003fe892f150 a7 : 0000000000000087
  [   12.228150]  s2 : 0000003fe4000000 s3 : 00000000000008c8 s4 : 0000000000000006
  [   12.235847]  s2 : 0000003fff9d53b6 s3 : 0000003fff9d53b7 s4 : 0000000000000000
  [   12.252130]  s5 : 0000000000000000 s6 : 0000003fff9d54f0 s7 : 0000003fe95f12b0
  [   12.259833]  s5 : 0000000000000006 s6 : 0000003fff9d54f0 s7 : 0000003fe892f820
  [   12.284151]  s8 : 0000003fe9130080 s9 : 0000000000000000 s10: 0000003fe939f380
  [   12.291879]  s8 : 0000003fe892f080 s9 : 0000000000000000 s10: 0000003fe939f380
  [   12.316110]  s11: 0000003fe939b328 t3 : 0000003fe92e0d08 t4 : 0000002adfe073a0
  [   12.323787]  s11: 0000003fe939b328 t3 : 0000003fe92ae6d4 t4 : 0000002adfe073a0
  [   12.348141]  t5 : 0000002adfde2c60 t6 : 0000000002adfe07
  [   12.353904]  t5 : 0000002adfde2c60 t6 : 0000000002adfe07
  [   12.368140] status: 0000000200004020 badaddr: 0000003fe4000028 cause: 0000000000000007
  [   12.376530] status: 0000000200004020 badaddr: 0000003fe892f49c cause: 0000000000000007
  [   12.400371] Kernel panic - not syncing: Attempted to kill init! exitcode=0x0000000b
  [   12.408037] CPU: 0 PID: 1 Comm: systemd Not tainted 5.14.0-rc4-nezha #1
  [   12.414650] Hardware name: Allwinner D1 NeZha (DT)
  [   12.419435] Call Trace:
  [   12.421882] [<ffffffff80003df0>] walk_stackframe+0x0/0xc8
  [   12.427297] [<ffffffff805bc364>] panic+0x128/0x314
  [   12.432100] [<ffffffff8000e490>] do_exit+0x888/0x900
  [   12.437072] [<ffffffff800db5d8>] kmem_cache_free.part.0+0x1a4/0x390
  [   12.443355] [<ffffffff8000e578>] do_group_exit+0x30/0xc0
  [   12.448672] [<ffffffff80019c2c>] get_signal+0x1c4/0x838
  [   12.453903] [<ffffffff80003168>] do_notify_resume+0x78/0x418
  [   12.459568] [<ffffffff80002118>] ret_from_syscall_rejected+0x8/0xc
  [   12.465766] ---[ end Kernel panic - not syncing: Attempted to kill init! exitcode=0x0000000b ]---
  ```

### 13.11.2021

All code, for now, is at the `develop` branch. At this moment `build` process
passes but the image **not running** at the board.

* `u-boot` can't uncompress the `fitImage`:
  ```
  Error: inflate() returned -5
  gzip compressed: uncompress error -1
  ```
