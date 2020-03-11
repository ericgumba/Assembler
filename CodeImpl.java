import java.util.BitSet;
import java.util.HashMap;

public class CodeImpl implements Code {

    public CodeImpl(){

        HashMap<String, String> dest = new HashMap<String, String>();
        dest.put("A", "100");
        dest.put("M", "001");
        dest.put("D", "010");
        

        HashMap<String, String> compA = new HashMap<String, String>();
        compA.put("M", " 110000");
        compA.put("!M",  "110001");
        compA.put("-M",  "110011");
        compA.put("M+1", "110111");
        compA.put("M-1", "110010");
        compA.put("D+M", "000010");
        compA.put("D-M",  "010011");
        compA.put("M-D", "000111");
        compA.put("D&M", "000000");
        compA.put("D|M", "010101");

        HashMap<String, String> jump = new HashMap<String, String>();
        jump.put("JGT", "001");
        jump.put("JEQ", "010");
        jump.put("JGE", "011");
        jump.put("JLT", "100");
        jump.put("JNE", "101");
        jump.put("JLE", "110");
        jump.put("JMP", "111");
    }

    @Override
    public BitSet dest(String mnemonic){


        BitSet bs = new BitSet(3); 
        

        
        return null;
    }

    @Override 
    public BitSet comp(String mnemonic){
        BitSet bs = new BitSet(7);
        return null;
    }

    @Override
    public BitSet jump(String mnemonic){
        BitSet bs = new BitSet(3);
        return null;
    }



}
