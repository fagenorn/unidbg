package cn.banny.unidbg.debugger.gdb;

import cn.banny.unidbg.Emulator;
import cn.banny.unidbg.arm.ARM;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import unicorn.Unicorn;

class RegistersCommand implements GdbStubCommand {

    private static final Log log = LogFactory.getLog(RegistersCommand.class);

    @Override
    public boolean processCommand(Emulator emulator, GdbStub stub, String command) {
        Unicorn unicorn = emulator.getUnicorn();
        if (log.isDebugEnabled()) {
            if (emulator.getPointerSize() == 4) {
                ARM.showRegs(unicorn, null);
            } else {
                ARM.showRegs64(unicorn, null);
            }
        }

        if (command.startsWith("g")) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < stub.registers.length; i++) {
                long value = ((Number) unicorn.reg_read(stub.registers[i])).longValue();
                if (emulator.getPointerSize() == 4) {
                    String hex = String.format("%08x", Integer.reverseBytes((int) (value & 0xffffffffL)));
                    sb.append(hex);
                } else {
                    String hex = String.format("%016x", Long.reverseBytes(value));
                    sb.append(hex);
                }
            }
            stub.makePacketAndSend(sb.toString());
            return true;
        } else {
            for (int i = 0; i < stub.registers.length; i++) {
                if (emulator.getPointerSize() == 4) {
                    long value = Long.parseLong(command.substring(1 + 8 * i, 9 + 8 * i), 16);
                    unicorn.reg_write(stub.registers[i], Integer.reverseBytes((int) (value & 0xffffffffL)));
                } else {
                    long value = Long.parseLong(command.substring(1 + 16 * i, 9 + 16 * i), 16);
                    unicorn.reg_write(stub.registers[i], Long.reverseBytes(value));
                }
            }
            return true;
        }
    }

}
