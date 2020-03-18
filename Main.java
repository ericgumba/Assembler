import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static Parser p;
    static FileWriter fw;
    static SymbolTable st;
    static Code c;
    static int address = 15;

    public static void firstPass( ) throws IOException {

        int addr = 0;
        while ( p.hasMoreCommands() ) {
            p.advance();
            if( p.commandType() == Command.L_COMMAND){
                st.addEntry( p.symbol() , addr ); 
            } else {
                addr += 1;
            }
        }
    }

    
    public static String to16Binary(int i){
        String binary = Integer.toBinaryString(i);
        int zeroes = 16 - binary.length();
        for(int index = 0; index < zeroes; index++) { binary =  "0" + binary; }
        return binary;
    }

    public static String handleSymbol( String symbol){
 

        String nonSymbol = symbol.replace("R", ""); 
        if (nonSymbol.matches("\\d+") ){ 
            return to16Binary( Integer.parseInt( nonSymbol ));
        }
        if ( st.contains(symbol) ){
            return to16Binary( st.getAddress(symbol) );
        }
        address += 1;
        
        System.out.println(symbol + "  " + String.valueOf(address) );

        st.addEntry(symbol, address);
        return to16Binary(address); 
    }

    public static String processCommand(){

        if (p.symbol() != null) { 
                    
            return handleSymbol( p.symbol() );           
        } else {
            return c.comp(p.comp()) + c.dest(p.dest()) + c.jump( p.jump() ); 
        }
    }

    public static void main(String[] args) throws IOException {

        p = new ParserImpl(new File("Pong.asm"));
        fw = new FileWriter("Pong.hack");
        st = new SymbolTableImpl();
        firstPass();
        p = new ParserImpl(new File("Pong.asm"));

        c = new CodeImpl();

        while(p.hasMoreCommands()){
            String lineToWrite = "";
            p.advance();

            if ( p.commandType() != Command.L_COMMAND ){
                lineToWrite = processCommand();
                fw.write(lineToWrite + "\n");
            } 

        }
        fw.close();
    }

}