import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("x");   

        Parser p = new ParserImpl( new File("asd.asm") );

        Code c = new CodeImpl();
        while(p.hasMoreCommands()){
            p.advance();
            if (p.symbol() != null) {
                System.out.println(p.symbol());
                                
            } else {
                System.out.println(  c.comp(p.comp()) + c.dest(p.dest()) + c.jump( p.jump() ));
            }
            System.out.println("^^^ command: " + p.getCommand()); 
        }
    }

}