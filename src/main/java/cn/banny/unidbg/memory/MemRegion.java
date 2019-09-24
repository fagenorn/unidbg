package cn.banny.unidbg.memory;

import cn.banny.unidbg.spi.LibraryFile;

import java.io.IOException;

public class MemRegion implements Comparable<MemRegion> {

    public final long begin;
    public final long end;
    public final int perms;
    private final LibraryFile libraryFile;
    public final long offset;
    public final String name;

    public MemRegion(long begin, long end, int perms, LibraryFile libraryFile, long offset, String name) {
        this.begin = begin;
        this.end = end;
        this.perms = perms;
        this.libraryFile = libraryFile;
        this.offset = offset;
        this.name = name;
    }

    public String getName() {
        return name != null ? name : libraryFile.getMapRegionName();
    }

    public byte[] readLibrary() throws IOException {
        return libraryFile.readToByteArray();
    }

    @Override
    public int compareTo(MemRegion o) {
        return (int) (begin - o.begin);
    }
}
