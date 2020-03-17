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
            }  
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
            return Command.A_COMMAND;
        } else if ( command.startsWith("(") ){ 
            return Command.L_COMMAND;
        } else { 
            return Command.C_COMMAND;
        } 

    }

    // dest = comp;jump
    @Override
    public String symbol() { 
        if ( commandType() == Command.A_COMMAND ){
            return command.replaceAll("@", ""); 
        }

        if ( commandType() == Command.L_COMMAND){ 
            command = command.replaceAll("\\)", "");   
            return command.replaceAll("\\(", ""); 
        }

            

        return null;
    }

    @Override
    public String dest() { 
        if (commandType() == Command.C_COMMAND ){
            if ( command.contains("=") ){
                return command.replaceAll("=.*", "");
            } 
        }
        return null;
    }

    // dest = comp;jump
    @Override
    public String comp() { 
        if (commandType() == Command.C_COMMAND ){
            if ( command.contains(";") ){
                return String.valueOf( command.charAt(0) );
            } 
            if (command.contains("=") ){
                return command.replaceAll(".*=", "");
            }
        }
        return null;
    }

    @Override
    public String jump() { 
        if (commandType() == Command.C_COMMAND ){
            if ( command.contains(";") ){
                return command.substring(2, 5);
            } 
        } 

        return null;
    }
    @Override
    public String getCommand(){
        return command;
    }

    public static void main(String[] args) {
        String a = "AM=DAWDOIWUDYH(W*&878";
        System.out.println(a.replaceAll("=.*", ""));

    }
 
    
}