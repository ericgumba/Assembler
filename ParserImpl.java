import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParserImpl implements Parser {
    FileReader fr;
    BufferedReader br;
    String command;

    public ParserImpl(File asmFile) throws FileNotFoundException {

        br = new BufferedReader(new FileReader(asmFile));
    }

    @Override //Are there more commands in the input?
    public boolean hasMoreCommands() throws IOException {  
        return br.ready();  
    }

    /*Reads the next command from
the input and makes it the current
command. Should be called only
if hasMoreCommands() is true.
Initially there is no current command. */
    @Override
    public void advance() throws IOException { 

        if (hasMoreCommands()){
            command = br.readLine();
            command.trim();
            command=command.replaceAll("\\s+", ""); // replace whitespace
            command=command.replaceAll("//.*", ""); // replace comment 
            if (command.length() == 0){ 
                advance();
            } else{
            System.out.println(command);
            }
        }else{
            System.out.print("you suck");
        }

    }

    /*Returns the type of the current
command:
m A_COMMAND for @Xxx where
Xxx is either a symbol or a
decimal number
m C_COMMAND for
dest=comp;jump

m L_COMMAND (actually, pseudo-
command) for (Xxx) where Xxx

is a symbol.*/
    @Override
    public Command commandType() { 

        if ( command.startsWith("@") ){
            System.out.println(Command.A_COMMAND);
            return Command.A_COMMAND;
        } else if ( command.startsWith("(") ){
            System.out.println(Command.L_COMMAND);
            return Command.L_COMMAND;
        } else {
            System.out.println(Command.C_COMMAND);
            return Command.C_COMMAND;
        } 

    }

    @Override
    public String symbol() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String dest() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String comp() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String jump() {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) throws IOException { 
 
        Parser p = new ParserImpl(new File("asd.asm"));
 
        p.advance();  
        p.commandType();
        p.advance();   
        p.commandType();  
        p.advance();      
        p.commandType();     
        p.advance();    
        p.commandType();
        p.advance();     
        p.commandType();
        p.advance();  
        p.commandType();
        p.advance();    
        p.commandType();
        p.advance();     
        p.commandType();
        p.advance();      
        p.commandType();     
        p.advance();    
        p.commandType();
        p.advance();     
        p.commandType();
        p.advance();      
        p.commandType();     
        p.advance();    
        p.commandType();
        p.advance();     
        p.commandType();
        p.advance();    
        p.commandType();
        p.advance();   
        p.commandType();  
    }
    
}