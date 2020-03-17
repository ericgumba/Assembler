import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static Parser p;
    static FileWriter fw;
    static SymbolTable st;

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

    public static void main(String[] args) throws IOException {
        System.out.println("x");

        p = new ParserImpl(new File("Max.asm"));
        fw = new FileWriter("Max.hack");
        st = new SymbolTableImpl();
        firstPass();
        p = new ParserImpl(new File("Max.asm"));

        Code c = new CodeImpl();
        int baseAdd = 16;
        // while(p.hasMoreCommands()){

        //     String lineToWrite = "";
        //     p.advance();
        //     if (p.symbol() != null) { 
        //         int i = Integer.parseInt( p.symbol() );
        //         String binary = Integer.toBinaryString(i);
        //         int zeroes = 16 - binary.length();

        //         for(int index = 0; index < zeroes; index++) { binary =  "0" + binary; }

        //         lineToWrite = binary;
                                
        //     } else {
        //         lineToWrite = c.comp(p.comp()) + c.dest(p.dest()) + c.jump( p.jump() ); 

        //     } 
        //     fw.write(lineToWrite + "\n");
        // }
        fw.close();
    }

}