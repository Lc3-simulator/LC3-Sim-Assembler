/**
 * This is the instance for an instance of a computer with the LC3 architecture
 */
public class LC3Instance {
    char conditionCode;
    short programCounter;
    short instructionRegister;
    short[] memoryArray = new short[65536];
    short[] tempRegisters = new short[8];

    /**
     * Method that lets user manually access and edit memory contents after initializing instance with assembler
     * @param address
     * @param contents
     */
    void set(String address, String contents){
        short memAddress =  Short.parseShort("0x"+ address);
        memoryArray[memAddress] = Short.parseShort("0x"+contents);
    }

void add(short dest, short reg1, short reg2, short offset) {
        tempRegisters[dest] = (short) (reg1 + reg2 + offset);
    }
    void not(short dest, short reg1) {
        // short = (short) ~short
        tempRegisters[dest] = (short) ~reg1;
    }
    void and(short dest, short reg1, short reg2) {
        // accumulator = (short) (accumulator & value);
        tempRegisters[dest] = (short) (reg1 & reg2);

    }




}
