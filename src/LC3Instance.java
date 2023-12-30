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





}
