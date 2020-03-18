import java.util.HashMap;

public class SymbolTableImpl implements SymbolTable{

    HashMap<String, Integer> hm;

    public SymbolTableImpl(){
        hm = new HashMap<String, Integer>();
        hm.put("SP", 0);
        hm.put("LCL", 1);
        hm.put("ARG", 2);
        hm.put("THIS", 3);
        hm.put("THAT", 4);
        hm.put("SCREEN", 16384);
        hm.put("KBD", 24576);
    }
    @Override
    public void addEntry(String symbol, int address) { 

        hm.put(symbol, address);

    }

    @Override
    public boolean contains(String symbol) { 

        return hm.containsKey(symbol);

 
    }

    @Override
    public int getAddress(String symbol) { 

        return hm.get(symbol); 
    }

    
}