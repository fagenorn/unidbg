package cn.banny.unidbg.linux.struct.types;

import com.sun.jna.IntegerType;

public class UnsignedShort extends IntegerType {
    public UnsignedShort() {
        super(2, true);
    }

    public UnsignedShort(long value) {
        super(2, value, true);
    }
}