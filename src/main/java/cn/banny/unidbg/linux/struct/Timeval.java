package cn.banny.unidbg.linux.struct;

import cn.banny.unidbg.pointer.UnicornStructure;

import java.util.Arrays;
import java.util.List;

public class Timeval extends UnicornStructure {
    public Timeval(long a, long b) {
        super();
        it_interval = a;
        it_value = b;
    }

    public Timeval() {
        super();
    }

    public long it_interval;
    public long it_value;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("it_interval", "it_value");
    }
}