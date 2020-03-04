import java.io.IOException;

interface Parser {
    boolean hasMoreCommands() throws IOException;
    void advance() throws IOException;
    Command commandType();
    String symbol();
    String dest();
    String comp();
    String jump();
}