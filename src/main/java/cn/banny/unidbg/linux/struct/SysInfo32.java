package cn.banny.unidbg.linux.struct;

import cn.banny.unidbg.linux.struct.types.*;
import cn.banny.unidbg.pointer.UnicornStructure;
import com.sun.jna.Pointer;

import java.util.Arrays;
import java.util.List;

public class SysInfo32 extends UnicornStructure {

    public SysInfo32(Pointer p) {
        super(p);
    }

    public long uptime = 10806460;
    public UnsignedLong[] loads = { new UnsignedLong(359136), new UnsignedLong(341952), new UnsignedLong(363296) };
    public UnsignedLong totalram = new UnsignedLong(3020779520L);
    public UnsignedLong freeram = new UnsignedLong(105689088);
    public UnsignedLong sharedram = new UnsignedLong(0);
    public UnsignedLong bufferram = new UnsignedLong(96862208);
    public UnsignedLong totalswap = new UnsignedLong(0);
    public UnsignedLong freeswap = new UnsignedLong(0);
    public UnsignedShort procs = new UnsignedShort(2186);
    public UnsignedShort pad = new UnsignedShort();
    public UnsignedLong totalhigh = new UnsignedLong(0);
    public UnsignedLong freehigh = new UnsignedLong(0);
    public UnsignedInt mem_unit = new UnsignedInt(0);
    public byte[] _f = new byte[8]; // Padding to 64 bytes

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("uptime", "loads", "totalram", "freeram", "sharedram", "bufferram", "totalswap",
                "freeswap", "procs", "pad", "totalhigh", "freehigh", "mem_unit", "_f");
    }
}
