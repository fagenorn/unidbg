package cn.banny.unidbg.linux.struct.types;

import com.sun.jna.IntegerType;

public class UnsignedLong extends IntegerType {
    public UnsignedLong() {
        super(4, true);
    }

    public UnsignedLong(long value) {
        super(4, value, true);
    }
}