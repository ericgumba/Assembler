import java.io.IOException;
import java.util.BitSet;

interface Code { 
    BitSet dest(String mnemonic);
    BitSet comp(String mnemonic);
    BitSet jump(String mnemonic);
}