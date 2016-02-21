package com.flurry.sdk;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.zip.CRC32;

public class ea extends MessageDigest {
    private CRC32 a;

    public ea() {
        super("CRC");
        this.a = new CRC32();
    }

    public byte[] a() {
        return engineDigest();
    }

    public int b() {
        return ByteBuffer.wrap(engineDigest()).getInt();
    }

    protected byte[] engineDigest() {
        long value = this.a.getValue();
        return new byte[]{(byte) ((int) ((-16777216 & value) >> 24)), (byte) ((int) ((16711680 & value) >> 16)), (byte) ((int) ((65280 & value) >> 8)), (byte) ((int) ((value & 255) >> 0))};
    }

    protected void engineReset() {
        this.a.reset();
    }

    protected void engineUpdate(byte b) {
        this.a.update(b);
    }

    protected void engineUpdate(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }
}