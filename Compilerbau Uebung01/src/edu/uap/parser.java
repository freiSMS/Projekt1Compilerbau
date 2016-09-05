
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Fri Jul 01 12:34:32 CEST 2016
//----------------------------------------------------

package edu.uap;

import java_cup.runtime.Scanner;
import java_cup.runtime.Symbol;
import edu.uap.nodes.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Fri Jul 01 12:34:32 CEST 2016
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\030\000\002\002\004\000\002\002\005\000\002\002" +
    "\006\000\002\002\003\000\002\002\006\000\002\002\005" +
    "\000\002\002\005\000\002\002\005\000\002\002\005\000" +
    "\002\002\005\000\002\002\005\000\002\002\005\000\002" +
    "\002\005\000\002\002\005\000\002\002\003\000\002\002" +
    "\005\000\002\002\010\000\002\003\003\000\002\003\005" +
    "\000\002\004\003\000\002\004\004\000\002\006\011\000" +
    "\002\005\003\000\002\005\005" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\014\004\006\006\011\011\007\030\004\031" +
    "\005\001\002\000\044\002\ufffe\007\ufffe\010\ufffe\011\063" +
    "\012\ufffe\014\ufffe\015\064\016\ufffe\017\ufffe\020\ufffe\021" +
    "\ufffe\022\ufffe\023\ufffe\024\ufffe\025\ufffe\026\ufffe\027\ufffe" +
    "\001\002\000\040\002\ufff3\007\ufff3\010\ufff3\012\ufff3\014" +
    "\ufff3\016\ufff3\017\ufff3\020\ufff3\021\ufff3\022\ufff3\023\ufff3" +
    "\024\ufff3\025\ufff3\026\ufff3\027\ufff3\001\002\000\004\030" +
    "\044\001\002\000\014\004\006\006\011\011\007\030\004" +
    "\031\005\001\002\000\026\002\041\016\020\017\021\020" +
    "\013\021\022\022\017\023\016\024\023\025\024\026\015" +
    "\001\002\000\014\004\006\006\011\011\007\030\004\031" +
    "\005\001\002\000\026\007\014\016\020\017\021\020\013" +
    "\021\022\022\017\023\016\024\023\025\024\026\015\001" +
    "\002\000\014\004\006\006\011\011\007\030\004\031\005" +
    "\001\002\000\014\004\006\006\011\011\007\030\004\031" +
    "\005\001\002\000\014\004\006\006\011\011\007\030\004" +
    "\031\005\001\002\000\014\004\006\006\011\011\007\030" +
    "\004\031\005\001\002\000\014\004\006\006\011\011\007" +
    "\030\004\031\005\001\002\000\014\004\006\006\011\011" +
    "\007\030\004\031\005\001\002\000\014\004\006\006\011" +
    "\011\007\030\004\031\005\001\002\000\014\004\006\006" +
    "\011\011\007\030\004\031\005\001\002\000\014\004\006" +
    "\006\011\011\007\030\004\031\005\001\002\000\014\004" +
    "\006\006\011\011\007\030\004\031\005\001\002\000\030" +
    "\002\ufff8\007\ufff8\010\ufff8\012\ufff8\014\ufff8\016\020\017" +
    "\021\020\013\021\022\026\ufff8\027\ufff8\001\002\000\030" +
    "\002\ufff7\007\ufff7\010\ufff7\012\ufff7\014\ufff7\016\020\017" +
    "\021\020\013\021\022\026\ufff7\027\ufff7\001\002\000\040" +
    "\002\ufff9\007\ufff9\010\ufff9\012\ufff9\014\ufff9\016\ufff9\017" +
    "\ufff9\020\ufff9\021\ufff9\022\ufff9\023\ufff9\024\ufff9\025\ufff9" +
    "\026\ufff9\027\ufff9\001\002\000\040\002\ufffb\007\ufffb\010" +
    "\ufffb\012\ufffb\014\ufffb\016\ufffb\017\ufffb\020\013\021\022" +
    "\022\ufffb\023\ufffb\024\ufffb\025\ufffb\026\ufffb\027\ufffb\001" +
    "\002\000\040\002\ufffc\007\ufffc\010\ufffc\012\ufffc\014\ufffc" +
    "\016\ufffc\017\ufffc\020\013\021\022\022\ufffc\023\ufffc\024" +
    "\ufffc\025\ufffc\026\ufffc\027\ufffc\001\002\000\030\002\ufff6" +
    "\007\ufff6\010\ufff6\012\ufff6\014\ufff6\016\020\017\021\020" +
    "\013\021\022\026\ufff6\027\ufff6\001\002\000\030\002\ufff5" +
    "\007\ufff5\010\ufff5\012\ufff5\014\ufff5\016\020\017\021\020" +
    "\013\021\022\026\ufff5\027\ufff5\001\002\000\040\002\000" +
    "\007\000\010\000\012\000\014\000\016\020\017\021\020" +
    "\013\021\022\022\017\023\016\024\023\025\024\026\000" +
    "\027\000\001\002\000\026\010\036\016\020\017\021\020" +
    "\013\021\022\022\017\023\016\024\023\025\024\026\015" +
    "\001\002\000\014\004\006\006\011\011\007\030\004\031" +
    "\005\001\002\000\040\002\ufff1\007\ufff1\010\ufff1\012\ufff1" +
    "\014\ufff1\016\ufff1\017\ufff1\020\ufff1\021\ufff1\022\ufff1\023" +
    "\ufff1\024\ufff1\025\ufff1\026\ufff1\027\ufff1\001\002\000\040" +
    "\002\ufffa\007\ufffa\010\ufffa\012\ufffa\014\ufffa\016\ufffa\017" +
    "\ufffa\020\ufffa\021\ufffa\022\ufffa\023\ufffa\024\ufffa\025\ufffa" +
    "\026\ufffa\027\ufffa\001\002\000\004\002\001\001\002\000" +
    "\026\012\043\016\020\017\021\020\013\021\022\022\017" +
    "\023\016\024\023\025\024\026\015\001\002\000\040\002" +
    "\ufff4\007\ufff4\010\ufff4\012\ufff4\014\ufff4\016\ufff4\017\ufff4" +
    "\020\ufff4\021\ufff4\022\ufff4\023\ufff4\024\ufff4\025\ufff4\026" +
    "\ufff4\027\ufff4\001\002\000\004\011\052\001\002\000\006" +
    "\005\uffee\030\uffee\001\002\000\006\005\050\030\044\001" +
    "\002\000\006\005\uffed\030\uffed\001\002\000\014\004\006" +
    "\006\011\011\007\030\004\031\005\001\002\000\040\002" +
    "\uffff\007\uffff\010\uffff\012\uffff\014\uffff\016\020\017\021" +
    "\020\013\021\022\022\017\023\016\024\023\025\024\026" +
    "\015\027\uffff\001\002\000\004\030\053\001\002\000\006" +
    "\012\uffeb\027\uffeb\001\002\000\006\012\056\027\055\001" +
    "\002\000\004\030\053\001\002\000\004\013\057\001\002" +
    "\000\014\004\006\006\011\011\007\030\004\031\005\001" +
    "\002\000\026\014\061\016\020\017\021\020\013\021\022" +
    "\022\017\023\016\024\023\025\024\026\015\001\002\000" +
    "\006\005\uffec\030\uffec\001\002\000\006\012\uffea\027\uffea" +
    "\001\002\000\014\004\006\006\011\011\007\030\004\031" +
    "\005\001\002\000\014\004\006\006\011\011\007\030\004" +
    "\031\005\001\002\000\040\002\ufff2\007\ufff2\010\ufff2\012" +
    "\ufff2\014\ufff2\016\020\017\021\020\013\021\022\022\017" +
    "\023\016\024\023\025\024\026\ufff2\027\ufff2\001\002\000" +
    "\006\012\071\027\070\001\002\000\030\012\ufff0\016\020" +
    "\017\021\020\013\021\022\022\017\023\016\024\023\025" +
    "\024\026\015\027\ufff0\001\002\000\014\004\006\006\011" +
    "\011\007\030\004\031\005\001\002\000\040\002\ufffd\007" +
    "\ufffd\010\ufffd\012\ufffd\014\ufffd\016\ufffd\017\ufffd\020\ufffd" +
    "\021\ufffd\022\ufffd\023\ufffd\024\ufffd\025\ufffd\026\ufffd\027" +
    "\ufffd\001\002\000\030\012\uffef\016\020\017\021\020\013" +
    "\021\022\022\017\023\016\024\023\025\024\026\015\027" +
    "\uffef\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\070\000\004\002\007\001\001\000\002\001\001\000" +
    "\002\001\001\000\006\004\045\006\044\001\001\000\004" +
    "\002\041\001\001\000\002\001\001\000\004\002\011\001" +
    "\001\000\002\001\001\000\004\002\037\001\001\000\004" +
    "\002\034\001\001\000\004\002\033\001\001\000\004\002" +
    "\032\001\001\000\004\002\031\001\001\000\004\002\030" +
    "\001\001\000\004\002\027\001\001\000\004\002\026\001" +
    "\001\000\004\002\025\001\001\000\004\002\024\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\002" +
    "\036\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\004\006\046\001\001\000\002" +
    "\001\001\000\004\002\050\001\001\000\002\001\001\000" +
    "\004\005\053\001\001\000\002\001\001\000\002\001\001" +
    "\000\004\005\061\001\001\000\002\001\001\000\004\002" +
    "\057\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\006\002\066\003\065\001\001\000\004\002" +
    "\064\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\002\071\001\001\000\002\001\001\000" +
    "\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    /*
     * Extended error reporting with line and column numbers
     * provided by the given Symbol object
     */
    public void report_error(String message, Object info)
    {
        String str = "Error";

        if (info instanceof Symbol)
        {
            Symbol symbol = ((Symbol) info);

            if (symbol.left >= 0)
            {
                str += " at line " + (symbol.left+1);

                if (symbol.right >= 0)
                {
                    str += ", column " + (symbol.right+1);
                }
            }
            
            str += ", " + symbol.value;
        }

        str += " : " + message;

        System.err.println(str);
    }


    /*
     * Extended fatal error reporting with line and column numbers
     * provided by the given Symbol object
     */
    public void report_fatal_error(String message, Object info)
    {
        report_error(message, info);
        System.exit(1);
    }

    
}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // V ::= V COMMA V 
            {
              Node RESULT =null;
		int v1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int v1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node v1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int v2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int v2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node v2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          ParamsNode paramsNode = new ParamsNode();

          paramsNode.addChild(v1);
          paramsNode.addChild(v2);

          RESULT = paramsNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("V",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // V ::= ID 
            {
              Node RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          RESULT = new IDNode(id);
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("V",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // DPart ::= ID LPAR V RPAR LBRA E RBRA 
            {
              Node RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-6)).value;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Node v = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
          FuncNode funcNode = new FuncNode();
          ParamsNode paramsNode = new ParamsNode();
          BodyNode bodyNode = new BodyNode();

          paramsNode.addChild(v);
          bodyNode.addChild(e);
          
          funcNode.addChild( new IDNode(id) );
          funcNode.addChild( paramsNode );
          funcNode.addChild( bodyNode );

          RESULT = funcNode;
          
       
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DPart",4, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-6)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // D ::= D DPart 
            {
              Node RESULT =null;
		int d1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int d1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node d1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int d2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int d2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node d2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          DefNode defNode = new DefNode();

          defNode.addChild(d1);
          defNode.addChild(d2);

          RESULT = defNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("D",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // D ::= DPart 
            {
              Node RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node d = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
        RESULT = d;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("D",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // A ::= A COMMA E 
            {
              Node RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node a = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          ArgsNode argsNode = new ArgsNode();

          argsNode.addChild(a);
          argsNode.addChild(e);

          RESULT = argsNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("A",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // A ::= E 
            {
              Node RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          ArgsNode argsNode = new ArgsNode();
        argsNode.addChild(e);

      RESULT = argsNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("A",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // E ::= IF E THEN E ELSE E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e3left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e3right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e3 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          IfNode ifNode = new IfNode();
          CondNode condNode = new CondNode();
          ThenNode thenNode = new ThenNode();
          ElseNode elseNode = new ElseNode();

          condNode.addChild(e1);
          thenNode.addChild(e2);
          elseNode.addChild(e3);

          ifNode.addChild(condNode);
          ifNode.addChild(thenNode);
          ifNode.addChild(elseNode);

          RESULT = ifNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // E ::= ID ASSIGN E 
            {
              Node RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          AssignNode assignNode = new AssignNode();

          assignNode.addChild( new IDNode(id) );
          assignNode.addChild(e);

          RESULT = assignNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // E ::= CONST 
            {
              Node RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Integer c = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          RESULT = new ConstNode(c);
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // E ::= LPAR E RPAR 
            {
              Node RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
          ParNode parNode = new ParNode();

          parNode.addChild(e);

          RESULT = parNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // E ::= E NEQ E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          Node op = new OpNode(OpNode.NEQ);
          op.addChild(e1);
          op.addChild(e2);

          RESULT = op;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // E ::= E EQ E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          Node op = new OpNode(OpNode.EQ);
          op.addChild(e1);
          op.addChild(e2);

          RESULT = op;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // E ::= E GT E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          Node op = new OpNode(OpNode.GT);
          op.addChild(e1);
          op.addChild(e2);

          RESULT = op;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // E ::= E LT E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          Node op = new OpNode(OpNode.LT);
          op.addChild(e1);
          op.addChild(e2);

          RESULT = op;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // E ::= E DIV E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          Node op = new OpNode(OpNode.DIV);
          op.addChild(e1);
          op.addChild(e2);

          RESULT = op;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // E ::= E MULT E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          Node op = new OpNode(OpNode.MULT);
          op.addChild(e1);
          op.addChild(e2);

          RESULT = op;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // E ::= E SUB E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          Node op = new OpNode(OpNode.SUB);
          op.addChild(e1);
          op.addChild(e2);

          RESULT = op;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // E ::= E ADD E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          Node op = new OpNode(OpNode.ADD);
          op.addChild(e1);
          op.addChild(e2);

          RESULT = op;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // E ::= ID LPAR A RPAR 
            {
              Node RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node a = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		
          CallNode callNode = new CallNode();

          callNode.addChild( new IDNode(id) );
          callNode.addChild(a);

          RESULT = callNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // E ::= ID 
            {
              Node RESULT =null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          ReadNode readNode = new ReadNode();

          readNode.addChild( new IDNode(id) );

          RESULT = readNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // E ::= LET D IN E 
            {
              Node RESULT =null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node d = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          LetNode letNode = new LetNode();
          DefNode defNode = new DefNode();
          BodyNode bodyNode = new BodyNode();
          
          defNode.addChild(d);
          letNode.addChild(defNode);
          
          bodyNode.addChild(e);
          letNode.addChild(bodyNode);
          
          RESULT = letNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // E ::= E SEMI E 
            {
              Node RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Node e1 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Node e2 = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		
          SemiNode semiNode = new SemiNode();

          semiNode.addChild(e1);
          semiNode.addChild(e2);

          RESULT = semiNode;
      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= E EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Node start_val = (Node)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

