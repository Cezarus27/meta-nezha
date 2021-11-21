# Nezha D1 board - known issues using Yocto code

## Known issues

### rng-tools

This package contains many tools. One of them is *Random Numbers Generator
daemon* - `rngd`. This daemon feeds data from a random number generator to the
kernel's random number entropy pool, after first checking the data to ensure
that it is properly random.

From some reason it crush during start with `SIGSEGV` in `libc-2.33.so`:
```log
[   10.792295] rngd[139]: unhandled signal 11 code 0x2 at 0x0000003fc72e1378 in libc-2.33.so[3fc727e000+fd000]
[   10.948096] CPU: 0 PID: 139 Comm: rngd Not tainted 5.14.0-rc4-nezha #1
```

This problem doesn't exist when the haveged random number generator is used in
the build.
