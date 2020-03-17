import java.util.HashMap;

public class CodeImpl implements Code {
    HashMap<String, String> dest;
    HashMap<String, String> compA;
    HashMap<String, String> compNA;
    HashMap<String, String> jump;
    public CodeImpl(){

        dest = new HashMap<String, String>();
        dest.put("A", "100");
        dest.put("M", "001");
        dest.put("D", "010");
        dest.put("AM", "101");
        dest.put("AD", "110");
        dest.put("AMD", "111");
        dest.put("MD", "011");
        

        compA = new HashMap<String, String>();
        compA.put("M", "110000");
        compA.put("!M",  "110001");
        compA.put("-M",  "110011");
        compA.put("M+1", "110111");
        compA.put("M-1", "110010");
        compA.put("D+M", "000010");
        compA.put("D-M",  "010011");
        compA.put("M-D", "000111");
        compA.put("D&M", "000000");
        compA.put("D|M", "010101");
        
        compNA = new HashMap<String, String>();
        compNA.put("0", "101010");
        compNA.put("1", "111111");
        compNA.put("-1", "111010");
        compNA.put("D", "001100");
        compNA.put("A", "110000");
        compNA.put("!D", "001101");
        compNA.put("!A", "001111");
        compNA.put("-D", "001111");
        compNA.put("-A", "110011");
        compNA.put("D+1", "011111");
        compNA.put("A+1", "110111");
        compNA.put("D-1", "001110");
        compNA.put("A-1", "110010");
        compNA.put("D+A", "000010");
        compNA.put("D-A", "010011");
        compNA.put("A-D", "000111");
        compNA.put("D&A", "000000");
        compNA.put("D|A", "010101");
        
        jump = new HashMap<String, String>();
        jump.put("JGT", "001");
        jump.put("JEQ", "010");
        jump.put("JGE", "011");
        jump.put("JLT", "100");
        jump.put("JNE", "101");
        jump.put("JLE", "110");
        jump.put("JMP", "111");
    }

    @Override
    public String dest(String mnemonic){ 

        if (mnemonic == null) {
            return "000";
        }

        return dest.get(mnemonic);
        

         
    }

    @Override 
    public String comp(String mnemonic){
        if ( mnemonic.contains("M")){
            return "1111"+compA.get(mnemonic);
        }

        return "1110"+compNA.get(mnemonic);
    }

    @Override
    public String jump(String mnemonic){ 

        if (mnemonic == null) {
            return "000";
        }
        return jump.get(mnemonic);
    }



}
