import java.io.File; 
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("x");   

        Parser p = new ParserImpl( new File("asd.asm") );

        Code c = new CodeImpl();
        while(p.hasMoreCommands()){
            p.advance();
            if (p.symbol() != null) { 
                int i = Integer.parseInt( p.symbol() );
                String binary = Integer.toBinaryString(i);
                int zeroes = 16 - binary.length();

                for(int index = 0; index < zeroes; index++) { binary =  "0" + binary; }

                System.out.println(binary);
                                
            } else {
                System.out.println(  c.comp(p.comp()) + c.dest(p.dest()) + c.jump( p.jump() ));
            } 
        }
    }

}