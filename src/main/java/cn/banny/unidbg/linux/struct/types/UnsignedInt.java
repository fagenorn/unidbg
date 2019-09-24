package cn.banny.unidbg.linux.struct.types;

import com.sun.jna.IntegerType;

public class UnsignedInt extends IntegerType {
    public UnsignedInt() {
        super(4, true);
    }

    public UnsignedInt(long value) {
        super(4, value, true);
    }
}