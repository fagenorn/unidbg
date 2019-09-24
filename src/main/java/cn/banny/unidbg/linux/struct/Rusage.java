package cn.banny.unidbg.linux.struct;

import cn.banny.unidbg.pointer.UnicornStructure;
import com.sun.jna.Pointer;

import java.util.Arrays;
import java.util.List;

public class Rusage extends UnicornStructure {

    public Rusage(Pointer p) {
        super(p);
    }

    public Timeval ru_utime = new Timeval(3, 647354);
    public Timeval ru_stime = new Timeval(0, 3981);
    public long ru_maxrss = 712;
    public long ru_ixrss = 0;
    public long ru_idrss = 0;
    public long ru_isrss = 0;
    public long ru_minflt = 56;
    public long ru_majflt = 0;
    public long ru_nswap = 0;
    public long ru_inblock = 0;
    public long ru_oublock = 0;
    public long ru_msgsnd = 0;
    public long ru_msgrcv = 0;
    public long ru_nsignals = 0;
    public long ru_nvcsw = 0;
    public long ru_nivcsw = 227;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("ru_utime", "ru_stime", "ru_maxrss", "ru_ixrss", "ru_idrss", "ru_isrss", "ru_minflt",
                "ru_majflt", "ru_nswap", "ru_inblock", "ru_oublock", "ru_msgsnd", "ru_msgrcv", "ru_nsignals",
                "ru_nvcsw", "ru_nivcsw");
    }
}