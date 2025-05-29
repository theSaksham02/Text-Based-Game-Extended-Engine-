//package org.uob.a2.parser;

/**
 * Represents a token in the parsing process, consisting of a {@code TokenType} and an optional value.
 * 
 * <p>
 * Tokens are used to represent the smallest units of meaning in the command input,
 * such as keywords, or variables.
 * </p>
 */
public class Token {
    private final TokenType tokenType; // Token type
    private final String value;    // Optional value

    /**
     * Constructor for creating a token with both type and value.
     *
     * @param tokenType  The type of the token.
     * @param value The value associated with the token.
     */
    public Token(TokenType tokenType, String value) {
        this.tokenType = tokenType;
        this.value = value;
    }

    /**
     * Constructor for creating a token with only type.
     * The value will be set to null.
     *
     * @param tokenType The type of the token.
     */
    public Token(TokenType tokenType) {
        this(tokenType, null); // Call the other constructor with null value
    }

    /**
     * Gets the type of the token.
     *
     * @return The token type.
     */
    public TokenType getTokenType() {
        return tokenType;
    }

    /**
     * Gets the value of the token.
     *
     * @return The token value, or null if not set.
     */
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + tokenType +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (tokenType != token.tokenType) return false;
        return value != null ? value.equals(token.value) : token.value == null;
    }

    @Override
    public int hashCode() {
        int result = tokenType != null ? tokenType.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}