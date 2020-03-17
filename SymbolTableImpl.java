import java.util.HashMap;

public class SymbolTableImpl implements SymbolTable{

    HashMap<String, Integer> hm;

    public SymbolTableImpl(){
        hm = new HashMap<String, Integer>();
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