package se.su.dsv.prop.seminar1;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class Tokenizer {
    private static final Map<Character, Token> SYMBOLS;
    private static final HashSet<String> NOUNS;
    private static final HashSet<String> VERBS;
    private static final HashSet<String> DETERMINERS;
    static {
        SYMBOLS = new HashMap<>();
        NOUNS = new HashSet<>();
        VERBS = new HashSet<>();
        DETERMINERS = new HashSet<>();

        // TODO: define the different constants of our grammar
    }

    private Scanner scanner = null;
    private Lexeme current = null;
    private Lexeme next = null;


    public Tokenizer() {

    }

    /**
     * Opens a file for tokenizing.
     */
    void open(String fileName) throws IOException, TokenizerException {
        scanner = new Scanner();
        scanner.open(fileName);
        scanner.moveNext();
		// I know, this is confusing
		//  * Scanner requires us to move to the first char before first use
		//  * but for the tokenizer we are not...
        //  * sorry
        next = extractLexeme();
    }

    /**
     * Returns the current token in the stream.
     */
    Lexeme current() {
        return current;
    }

    /**
     * Moves current to the next token in the stream.
     */
    void moveNext() throws IOException, TokenizerException {
        if (scanner == null)
            throw new IOException("No open file.");
        current = next;
        if (next.token() != Token.EOF)
            next = extractLexeme();
    }

    private void consumeWhiteSpaces() throws IOException {
        while (Character.isWhitespace(scanner.current())) {
            scanner.moveNext();
        }
    }

    private Lexeme extractLexeme() throws IOException, TokenizerException {
    	// TODO: implement the lexeme extraction algorithm
        return null;
    }


    public void close() throws IOException {
        if (scanner != null)
            scanner.close();
    }
}


