import java.util.BitSet;

public class CodeImpl implements Code {

    public CodeImpl(){

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