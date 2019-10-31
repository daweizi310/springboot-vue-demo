//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.maxton.utils;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class UUID implements Serializable, Comparable<UUID> {
    private static final long serialVersionUID = -4856846361193249489L;
    private final long mostSigBits;
    private final long leastSigBits;

    private UUID(byte[] var1) {
        long var2 = 0L;
        long var4 = 0L;

        assert var1.length == 16 : "data must be 16 bytes in length";

        int var6;
        for(var6 = 0; var6 < 8; ++var6) {
            var2 = var2 << 8 | (long)(var1[var6] & 255);
        }

        for(var6 = 8; var6 < 16; ++var6) {
            var4 = var4 << 8 | (long)(var1[var6] & 255);
        }

        this.mostSigBits = var2;
        this.leastSigBits = var4;
    }

    public UUID(long var1, long var3) {
        this.mostSigBits = var1;
        this.leastSigBits = var3;
    }

    public static UUID randomUUID() {
        SecureRandom var0 = UUID.Holder.numberGenerator;
        byte[] var1 = new byte[16];
        var0.nextBytes(var1);
        var1[6] = (byte)(var1[6] & 15);
        var1[6] = (byte)(var1[6] | 64);
        var1[8] = (byte)(var1[8] & 63);
        var1[8] = (byte)(var1[8] | 128);
        return new UUID(var1);
    }

    public static UUID nameUUIDFromBytes(byte[] var0) {
        MessageDigest var1;
        try {
            var1 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var3) {
            throw new InternalError("MD5 not supported", var3);
        }

        byte[] var2 = var1.digest(var0);
        var2[6] = (byte)(var2[6] & 15);
        var2[6] = (byte)(var2[6] | 48);
        var2[8] = (byte)(var2[8] & 63);
        var2[8] = (byte)(var2[8] | 128);
        return new UUID(var2);
    }

    public static UUID fromString(String var0) {
        String[] var1 = var0.split("-");
        if (var1.length != 5) {
            throw new IllegalArgumentException("Invalid UUID string: " + var0);
        } else {
            for(int var2 = 0; var2 < 5; ++var2) {
                var1[var2] = "0x" + var1[var2];
            }

            long var6 = Long.decode(var1[0]);
            var6 <<= 16;
            var6 |= Long.decode(var1[1]);
            var6 <<= 16;
            var6 |= Long.decode(var1[2]);
            long var4 = Long.decode(var1[3]);
            var4 <<= 48;
            var4 |= Long.decode(var1[4]);
            return new UUID(var6, var4);
        }
    }

    public long getLeastSignificantBits() {
        return this.leastSigBits;
    }

    public long getMostSignificantBits() {
        return this.mostSigBits;
    }

    public int version() {
        return (int)(this.mostSigBits >> 12 & 15L);
    }

    public int variant() {
        return (int)(this.leastSigBits >>> (int)(64L - (this.leastSigBits >>> 62)) & this.leastSigBits >> 63);
    }

    public long timestamp() {
        if (this.version() != 1) {
            throw new UnsupportedOperationException("Not a time-based UUID");
        } else {
            return (this.mostSigBits & 4095L) << 48 | (this.mostSigBits >> 16 & 65535L) << 32 | this.mostSigBits >>> 32;
        }
    }

    public int clockSequence() {
        if (this.version() != 1) {
            throw new UnsupportedOperationException("Not a time-based UUID");
        } else {
            return (int)((this.leastSigBits & 4611404543450677248L) >>> 48);
        }
    }

    public long node() {
        if (this.version() != 1) {
            throw new UnsupportedOperationException("Not a time-based UUID");
        } else {
            return this.leastSigBits & 281474976710655L;
        }
    }

    public String toString() {
        return digits(this.mostSigBits >> 32, 8) + "-" + digits(this.mostSigBits >> 16, 4) + "-" + digits(this.mostSigBits, 4) + "-" + digits(this.leastSigBits >> 48, 4) + "-" + digits(this.leastSigBits, 12);
    }

    private static String digits(long var0, int var2) {
        long var3 = 1L << var2 * 4;
        return Long.toHexString(var3 | var0 & var3 - 1L).substring(1);
    }

    public int hashCode() {
        long var1 = this.mostSigBits ^ this.leastSigBits;
        return (int)(var1 >> 32) ^ (int)var1;
    }

    public boolean equals(Object var1) {
        if (null != var1 && var1.getClass() == UUID.class) {
            UUID var2 = (UUID)var1;
            return this.mostSigBits == var2.mostSigBits && this.leastSigBits == var2.leastSigBits;
        } else {
            return false;
        }
    }

    public int compareTo(UUID var1) {
        return this.mostSigBits < var1.mostSigBits ? -1 : (this.mostSigBits > var1.mostSigBits ? 1 : (this.leastSigBits < var1.leastSigBits ? -1 : (this.leastSigBits > var1.leastSigBits ? 1 : 0)));
    }

    private static class Holder {
        static final SecureRandom numberGenerator = new SecureRandom();

        private Holder() {
        }
    }
}
