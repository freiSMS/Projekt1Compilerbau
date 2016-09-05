
// Usercode Section ===========================================================

package edu.uap;

import java_cup.runtime.Symbol;

%%

// Options and Declarations Section ===========================================

/*
 * Options
 */
%class Lexer  // Name of the lexer class will be Lexer.java
%line         // Enables line count, accessed by yyline
%column       // Enables column count, accessed by yycolumn
%cup          // CUP compatibility mode

/*
 * Declarations
 */
%{
    /*
     * Creates a new java_cup.runtime.Symbol with given type
     * and no value, saves current line and column count
     * @param type - the type of the new symbol
     */
    private Symbol createSymbol(int type)
    {
        return new Symbol(type, yyline, yycolumn);
    }


    /*
     * Creates a new java_cup.runtime.Symbol with given type
     * and value, saves current line and column count
     * @param type - the type of the new symbol
     * @param attribute - the attribute of the new symbol
     */
    private Symbol createSymbol(int type, Object attribute)
    {
        return new Symbol(type, yyline, yycolumn, attribute);
    }
%}


/*
 * Macro Declarations
 */

LineTerminator  = \r | \n | \r\n
WhiteSpace      = {LineTerminator} | [ \t\f]
PositiveInteger = 0 | [1-9][0-9]*
Identifier      = [A-Za-z_][A-Za-z_0-9]*

%%

// Lexical Rules Section ======================================================

/* Lexical Rules */
<YYINITIAL> {

    // Keyword tokens
	"let"  { return createSymbol(sym.LET); }
	"in"   { return createSymbol(sym.IN); }
    "if"   { return createSymbol(sym.IF); }
    "then" { return createSymbol(sym.THEN); }
    "else" { return createSymbol(sym.ELSE); }

    // Parentheses tokens
    "(" { return createSymbol(sym.LPAR); }
    ")" { return createSymbol(sym.RPAR); }
    "{" { return createSymbol(sym.LBRA); }
    "}" { return createSymbol(sym.RBRA); }

    // Assign token
    "="  { return createSymbol(sym.ASSIGN); }

    // Operator tokens
    "+"  { return createSymbol(sym.ADD); }
    "-"  { return createSymbol(sym.SUB); }
    "*"  { return createSymbol(sym.MULT); }
    "/"  { return createSymbol(sym.DIV); }
    "==" { return createSymbol(sym.EQ); }
    "!=" { return createSymbol(sym.NEQ); }
    ">"  { return createSymbol(sym.GT); }
    "<"  { return createSymbol(sym.LT); }

    // Semicolon/comma tokens
	";" { return createSymbol(sym.SEMI); }
	"," { return createSymbol(sym.COMMA); }
	
	//new
	"lazy"	{return createSymbol(sym.LAZY);}
	"var"	{return createSymbol(sym.VAR);	}

	// Positive integers
    {PositiveInteger} { return createSymbol( sym.CONST, new Integer(yytext()) ); }

    // Identifiers
    {Identifier} { return createSymbol( sym.ID, yytext() ); }

    // White space
    {WhiteSpace} { /* do nothing */ }

}

// If the input did not match one of the rules above, throw an illegal character IOException
[^] { throw new java.io.IOException("Illegal character <" + yytext() + "> at line " + yyline + ", column " + yycolumn); }

