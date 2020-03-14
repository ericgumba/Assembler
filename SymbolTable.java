/**
 * SymbolTable
 */
public interface SymbolTable {

    void addEntry(String symbol);
    boolean contains(String symbol);
    int getAddress(String symbol);
}