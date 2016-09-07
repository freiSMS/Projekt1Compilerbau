package edu.uap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Vector;

import edu.uap.Instruction;

import edu.uap.nodes.*;

public class CompilerFabrik {
	//Aufgabe 1a)
	public static void flachklopfen(Node klopfknoten) {
		String k = klopfknoten.getType();
		for (int i = 0; i < klopfknoten.getChildren().size(); i++) {
			Node kind = klopfknoten.getChildren().get(i);
			if (k.equals("SEMI") || k.equals("DEF") || k.equals("ARGS") || k.equals("PARAMS")) {
				// Falls ein doppelter Knoten gefunden wird soll er entfernt und
				// dessen Kinder an seiner Stelle eingef�gt werden.
				if (kind.getType() == k) {
					System.out.println("Doppelter Knoten vom Typ " + k + " gefunden.");
					klopfknoten.getChildren().addAll(i + 1, kind.getChildren()); // f�gt die Kinder hinter dem zu l�schenden Element ein...
					klopfknoten.getChildren().remove(i); // ...und l�scht es
					i--; // der Index muss durch das L�schen des Kindes korrigiert werden
				}
			}

		}
		for (int i = 0; i < klopfknoten.getChildren().size(); i++) { // rekursiver Aufruf der Funktion, falls das Kind nicht entfernt wird
			Node kind = klopfknoten.getChildren().get(i);
			flachklopfen(kind);
		}
	}
	
	//Aufgabe 1b)
	public static int labelCount = 0;
	static int top = 0; //gibt die erste freie Stelle in der HashMap an
	//static int nl =0; //Das nesting Level startet bei 0 und erh�ht sich bei jedem Funktionsaufruf
	
//	static HashMap<String, AddressPair> rho = new HashMap<String, AddressPair>(); 	//Speicher fuer Variablen und Labels
//	static LinkedList<HashMap<String, AddressPair>> speicher = new LinkedList<HashMap<String, AddressPair>>();
	
	//Initialisiert den Speicher mit Nesting Level 0 -> 
//	static {
//		speicher.add(rho);	//enth�lt pro Nesting Level eine HashMap
//	}
	
	
	//Da die code Funktionsaufrufe immer mit dem Typ Node erfolgen gibt es eine Weiterleitung je nach tats�chlichem Tyo
	public static Vector<Instruction> code (Node node, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		switch (node.getType())	{
		case "ARGS":
			tramCode.addAll(code((ArgsNode) node, nl, rho));
			break;
		case "ASSIGN":
			tramCode.addAll(code((AssignNode) node, nl, rho));
			break;
		case "CONST":	
			tramCode.addAll( code((ConstNode) node, nl, rho));
			break;
		case "BODY":
			tramCode.addAll(code((BodyNode) node, nl, rho));
			break;	
		case "CALL":
			tramCode.addAll(code((CallNode) node, nl, rho));
			break;		
		case "COND":
			tramCode.addAll(code((CondNode) node, nl, rho));
			break;		
		case "DEF":
			tramCode.addAll(code((DefNode) node, nl, rho));
			break;		
		case "ELSE":
			tramCode.addAll(code((ElseNode) node, nl, rho));
			break;		
		case "EXPR":
			tramCode.addAll(code((ExprNode) node, nl, rho));
			break;		
		case "FUNC":
			tramCode.addAll(code((FuncNode) node, nl, rho));
			break;		
		case "ID":
			tramCode.addAll(code((IDNode) node, nl, rho));
			break;		
		case "IF":
			tramCode.addAll(code((IfNode) node, nl, rho));
			break;		
		case "LET":
			tramCode.addAll(code((LetNode) node, nl, rho));
			break;		
		case "OP":
			tramCode.addAll(code((OpNode) node, nl, rho));
			break;		
		case "PARAMS":
			tramCode.addAll(code((ParamsNode) node, nl, rho));
			break;		
		case "PAR":
			tramCode.addAll(code((ParNode) node, nl, rho));
			break;		
		case "READ":
			tramCode.addAll(code((ReadNode) node, nl, rho));
			break;		
		case "SEMI":
			tramCode.addAll(code((SemiNode) node, nl, rho));
			break;		
		case "THEN":
			tramCode.addAll(code((ThenNode) node, nl, rho));
			break;		
		}
		return tramCode;
	}
	
	//Sucht im Speicher nach dem key in allen kleineren Nesting Leveln
/*	private static AddressPair speicherSuche(String key, int startNL)	{
		int i = startNL;
		AddressPair idSpeicherinhalt = speicher.get(i).get(key);		
		while(idSpeicherinhalt == null && i>0)	{
			idSpeicherinhalt = speicher.get(i).get(key);
		}
		return idSpeicherinhalt;
	}*/
	
	public static Vector<Instruction> code(ReadNode read, int nl, HashMap<String, AddressPair> rho)	{
		//Hilfsvariablen
		IDNode id = (IDNode) read.getChildren().get(0);
		
		//Sucht im Speicher nach der ID in allen kleineren Nesting Leveln
		AddressPair idSpeicherinhalt = rho.get(id.getAttribute().toString());	//evtl. Fehlermeldung einbauen, wenn null zur�ckgeliefert wird

		int k = (Integer) idSpeicherinhalt.loc;
		int nl1 = idSpeicherinhalt.nl;
		
		//Instructionerzeugung
		Vector<Instruction> tramCode = new Vector<Instruction>();
		tramCode.add(new Instruction(Instruction.LOAD,k, nl - nl1));
		return tramCode;
	}
	

	public static Vector<Instruction> code(AssignNode asignNode, int nl, HashMap<String, AddressPair> rho)	{
		//Erstellung von Hilfsvariablen zur besseren Codelesbarkeit  
		Node E = asignNode.getChildren().get(1);
		IDNode ID = (IDNode) asignNode.getChildren().get(0);

		//Suche die ID im Speicher
		AddressPair variable = rho.get(ID.getAttribute().toString());
		
		
		//k und nl1 ergeben sich aus roh(id)
		int nl1=variable.nl;
		int k = (Integer) variable.loc;
		
		//Instructioneugung
		Vector<Instruction> tramCode = code(E, nl, rho);
		tramCode.add(new Instruction((Instruction.STORE),k, nl- nl1));
		tramCode.add(new Instruction((Instruction.LOAD),k, nl- nl1));	
		return tramCode;
	}
	
	public static Vector<Instruction> code (OpNode opNode, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		tramCode.addAll(code(opNode.getChildren().get(0), nl, rho));
		tramCode.addAll(code(opNode.getChildren().get(1), nl, rho));
		
		// Instruktionsaufruf je nachdem, welche Operation der Knoten darstellt
		int instruktionsNummer =0;
		switch (opNode.getAttribute().toString())	{
		case "==":
			instruktionsNummer = Instruction.EQ;
			break;
		case "!=":
			instruktionsNummer = Instruction.NEQ;
			break;
		case "&lt":
			instruktionsNummer = Instruction.LT;
			break;
		case "&gt":
			instruktionsNummer = Instruction.GT;
			break;
		case "+":
			instruktionsNummer = Instruction.ADD;
			break;
		case "-":
			instruktionsNummer = Instruction.SUB;
			break;
		case "*":
			instruktionsNummer = Instruction.MUL;
			break;
		case "/":
			instruktionsNummer = Instruction.DIV;
			break;
		}
		tramCode.add(new Instruction(instruktionsNummer));
		return tramCode;
		
		
	}
	
	public static Vector<Instruction> code (ConstNode con, int nl, HashMap<String, AddressPair> rho)	{
		//Hilfsvariablen
		Integer konstantenWert = Integer.decode(con.getAttribute().toString());
		
		//Codeerzeugung
		Vector<Instruction> tramCode = new Vector<Instruction>();
		tramCode.add(new Instruction(Instruction.CONST, konstantenWert));
		return tramCode;
	}
	
	public static Vector<Instruction> code(ParNode parNode, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		tramCode.addAll(code(parNode.getChildren().get(0), nl, rho));
		return tramCode;
	}
	
	//Durch das flachklopfen hat jeder Semi Node beliebig viele Kinder
	public static Vector<Instruction> code (SemiNode semi, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		for(int i =0; i<semi.getChildren().size()-1; i++)	{
			tramCode.addAll(code(semi.getChildren().get(i), nl, rho));
			//***Pop Instruction einf�gen ****tramCode.add(Instruction.)
		}
		//f�ge f�r das letzte Kind des Semi Knoten den Code manuell hinzu, weil darauf kein pop folgt
		tramCode.addAll(code(semi.getChildren().get(semi.getChildren().size()-1), nl, rho));
		return tramCode;
	}
	
	public static void addLabel(int nl, HashMap<String, AddressPair> rho)	{
		rho.put(Integer.toString(labelCount), new AddressPair(new TramLabel(-1),nl));
		labelCount++;
	}
	
	public static Vector<Instruction> code(IfNode ifNode, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();	
		
		Vector<Instruction> e1 = code(ifNode.getChildren().get(0).getChildren().get(0), nl, rho);
		Vector<Instruction> e2 = code(ifNode.getChildren().get(1).getChildren().get(0), nl, rho);
		Vector<Instruction> e3 = code(ifNode.getChildren().get(2).getChildren().get(0), nl, rho);
		
		tramCode.addAll(e1);
		//Es wird ein neues Label erstellt zu dem gesprungen werden soll, wenn if(e1) true ergibt
		//Die Adresse steht zu Anfang auf -1 -> sp�ter muss man die Instructions durchlaufen bis zum
		//...dazugeh�renden Else Node -> das ist die SprungAdresse
					//rho.put(Integer.toString(labelCount), new AddressPair(new TramLabel(-1),nl));	//l1
					//labelCount++;
		addLabel(nl, rho);	//l1
		
		//Hilfsvariablen f�r Pseudoinstruktion 1
		int label1 = labelCount;
		Instruction einzusetzendeInstruktion = new Instruction(Instruction.IFZERO,-1);
		int einsetzStelle = 1;
		
		//Pseudoinstruktion1
		tramCode.add(new Instruction(Instruction.TRAMLABELCALLER, Integer.toString(label1), einzusetzendeInstruktion , einsetzStelle));	//Hinter label1 steht der sp�ter einzusetzende Maschinenbefehl
		//tramCode.add(new Instruction(Instruction.IFZERO, label1));	//in LabelCount steht der Key zum Label in der HashMap
		tramCode.addAll(e2);
		
		//Hilfsvariablen f�r Pseudoinstruktion 2
		addLabel(nl, rho);
		int label2 = labelCount;
		einzusetzendeInstruktion = new Instruction(Instruction.GOTO,-1);	//einsetzStelle wie oben
		
		
		
		tramCode.add(new Instruction(Instruction.TRAMLABELCALLER, Integer.toString(label2), einzusetzendeInstruktion, einsetzStelle));
		tramCode.add(new Instruction(Instruction.TRAMLABEL, Integer.toString(label1)));
		tramCode.addAll(e3);
		tramCode.add(new Instruction(Instruction.TRAMLABEL, Integer.toString(label2)));
		tramCode.add(new Instruction(Instruction.NOP));

		return tramCode;
	}
	
	//Muss ich hier das Nesting Level erh�hen?
	public static Vector<Instruction> code(CallNode call, int nl, HashMap<String, AddressPair> rho)	{

		//nl++;	//ein Call Node erh�ht das NestingLevel
		
		Vector<Instruction> tramCode = new Vector<Instruction>();
		
		ArgsNode args = (ArgsNode)call.getChildren().get(1);
		tramCode.addAll(code(args, nl, rho));

		
		//Hilfsvariablen
		String idName = call.getChildren().get(0).getAttribute().toString();
		int anzahlFunktionsparameter = call.getChildren().size() -1; //Da das erste Kind der IDNode ist
		AddressPair idSpeicherInhalt = rho.get(idName);
		int nestingLevelDifferenz = nl - idSpeicherInhalt.nl;
		int spaetereEinsetzposition = 2;
		Instruction invokeInstruction = new Instruction(Instruction.INVOKE, anzahlFunktionsparameter, -1, nestingLevelDifferenz);	//idName muss sp�ter mit der Instruktionsnummer dieses Labels ersetzt werden
				
		tramCode.add(new Instruction(Instruction.TRAMLABELCALLER, idName, invokeInstruction, spaetereEinsetzposition));
		//nl++;	//???? Nur die Funktionsdefinitionen bekommen bei der Definition ein h�heres Nesting Level??
		return tramCode;
	}
	
	public static Vector<Instruction> code(ArgsNode argsNode, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		
		//Alle Kinder des ArgsNodes sind Expressions, f�r die nacheinander Code erzeugt wird
		for(int i=0; i<argsNode.getChildren().size();i++)	{
			tramCode.addAll(code(argsNode.getChildren().get(i), nl, rho));
		}
		return tramCode;
	}
	
	public static Vector<Instruction> code(DefNode defNode, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		//Durch das Flachklopfen sind alle Kinder Func Nodes
		//for(int i =0; i< )
		ListIterator<Node> iterator = defNode.getChildren().listIterator();
		while(iterator.hasNext())	{
			tramCode.addAll(code(iterator.next(), nl, rho));
		}
		return tramCode;
	}
	
	public static Vector<Instruction> code(LetNode letNode, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		
		// nl wird in Aufgabe 2 zu nl +1
		Elab elab = ((DefNode)letNode.getChildren().get(0)).elab_def(rho, nl+1, 0);	//F�r jeden Def Node ist die 0 die erste freie Stelle, da sie einen eigenen Speicher hat??!?
		HashMap<String, AddressPair> rho2 = elab.rho;
		int nav = elab.nav;	//gibt die Anzahl der zu erzeugenden const_befehle an (da nav ab null hochzaehlt)
		for (int i= nav; i>0; i--){
			tramCode.add(new Instruction(Instruction.CONST, 0));
		}
		
		
		addLabel(nl, rho);
		
		//Hilfsvariablen f�r Tramlabel
		int label1 = labelCount;
		int ersatzStelle = 1;
		Instruction einsetzInstruktion = new Instruction(Instruction.GOTO, -1);
		
		tramCode.add(new Instruction(Instruction.TRAMLABELCALLER, Integer.toString(label1), einsetzInstruktion, ersatzStelle));
		
		addLabel(nl, rho);
		String label2 = Integer.toString(labelCount);
		
		tramCode.add(new Instruction(Instruction.TRAMLABEL, label2));
		tramCode.addAll(code(letNode.getChildren().get(0),nl+1, rho2));	//�bersetzung DefNode
		tramCode.addAll(code(letNode.getChildren().get(1),nl+1, rho2));	//�bersetzung BodyNode
		tramCode.add(new Instruction(Instruction.RETURN));
		
		tramCode.add(new Instruction(Instruction.TRAMLABEL, Integer.toString(label1)));
		Instruction einsetzInstruction2 = new Instruction(Instruction.INVOKE, nav, -1);	//nav entspricht der Anzahl der lokalen Variablen
		ersatzStelle = 2;
		tramCode.add(new Instruction(Instruction.TRAMLABELCALLER, label2, einsetzInstruction2, ersatzStelle));

		return tramCode;
		
	}
	
	
	public static Vector<Instruction> code(FuncNode funcNode, int nl1, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		
		IDNode signature = (IDNode) funcNode.getChildren().get(0);
		
		String funcKey = signature.getAttribute().toString();// der IDNode (Kind 0) enth�lt die Signatur der Funktion
		
		//Speichere die FunktionsID in der Hashmap mit dem Label und dem Nesting Level:
		int nl = rho.get(funcKey).nl;

		tramCode.add(new Instruction(Instruction.TRAMLABEL, funcKey));
		
		//Hinzuf�gen der Parameter in den Speicher:
		ParamsNode par = (ParamsNode) funcNode.getChildren().get(1);

		for(int i=0; i<par.getChildren().size();i++)	{
			String key = par.getChildren().get(i).getAttribute().toString();
			rho.put(key, new AddressPair(i, nl+1));
		}
		tramCode.addAll(code(funcNode.getChildren().get(2).getChildren().get(0), nl+1, rho)); //Expressioncode in body
		
		
		
		
		return tramCode;
		
	}
	
	public static Vector<Instruction> code(BodyNode bodyNode, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		tramCode.addAll(code(bodyNode.getChildren().get(0), nl, rho));
		return tramCode;
	}
	
	
	//Aufgabe2 -> neue code() Funktionen
	public static Vector<Instruction> code(VarNode varNode, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		
		//Hilfvariablen und Speicherabfrage:
		Node e = varNode.getChildren().get(1);
		String id = varNode.getChildren().get(0).getAttribute().toString();
		AddressPair idSpeicherInhalt = rho.get(id);
		
		
		
		tramCode.addAll(code(e, idSpeicherInhalt.nl, rho));
		tramCode.add(new Instruction(Instruction.STORE,(Integer) idSpeicherInhalt.loc, 0));
		return tramCode;
	}
	
	
	public static Vector<Instruction> code(LazyNode lazyNode, int nl, HashMap<String, AddressPair> rho)	{
		Vector<Instruction> tramCode = new Vector<Instruction>();
		
		//Labelerzeugung und Speicherabfrage der ID
		addLabel(nl, rho);
		String label1 = Integer.toString(labelCount);
		addLabel(nl,rho);
		String label2 = Integer.toString(labelCount);
		
		Node e = lazyNode.getChildren().get(1);
		String id = lazyNode.getChildren().get(0).getAttribute().toString();
		AddressPair spr = rho.get(id);
		
		
				
		
		//Codeerzeugung
		Instruction einzusetzendeInstr = new Instruction(Instruction.GOTO, -1);
		tramCode.add( new Instruction(Instruction.TRAMLABELCALLER, label1, einzusetzendeInstr, 1 ));
		tramCode.add(new Instruction(Instruction.TRAMLABEL, label2));
		tramCode.addAll(code(e, spr.nl, rho));
		tramCode.add(new Instruction(Instruction.LAZYRETURN));
		tramCode.add(new Instruction(Instruction.TRAMLABEL, label1));
		
		Instruction einzusetzendeInstruction = new Instruction(Instruction.LAZY, (Integer) spr.loc, -1);
		tramCode.add(new Instruction(Instruction.TRAMLABELCALLER, label2, einzusetzendeInstruction, 2));
		return tramCode;
		
		
	}
	
	
	
	public static Vector<Instruction> replaceTramLabels(Vector<Instruction> altProgramm)	{
		HashMap<String, Integer> rho = new HashMap<String, Integer>();
		int instruktionsNummer = 0;
		//Iterator<Instruction> it = altProgramm.iterator();
		
		//Phase1; ermittle die Instruktionsnummern aller TramLabels und entferne diese daraufhin
		while(instruktionsNummer <altProgramm.size())	{
			
			//Falls die aktuelle Instruktion ein TramLabel ist, speichere die Instruktionsnummer mit dem key in arg1 in der Hashmap
			//Und entferne das Label
			Instruction tmp = altProgramm.get(instruktionsNummer);
			if(((Integer)tmp.opcode).equals(Instruction.TRAMLABEL)){
				rho.put(tmp.key, instruktionsNummer+1);
				altProgramm.remove(instruktionsNummer);
			}
			else	{
				instruktionsNummer++;	
			}
		}

		for (int i=0; i<altProgramm.size(); i++)	{
			Instruction tmp = altProgramm.get(i);		
			//Falls die aktuelle Instruktion ein TramLabel ist, speichere die Instruktionsnummer mit dem key in arg1 in der Hashmap
			//Und entferne das Label

			if(((Integer)tmp.opcode).equals(Instruction.TRAMLABELCALLER)){
				int pos = rho.get(tmp.key);	//hole die Instruktionsnummer des Labels
				Instruction einfuegeInstruction = tmp.arg4;
				switch(tmp.erstatzStelle)	{
				case 1: einfuegeInstruction.arg1 = pos; break;
				case 2: einfuegeInstruction.arg2 = pos; break;
				case 3: einfuegeInstruction.arg3 = pos; break;
				}
				altProgramm.add(i, einfuegeInstruction);
				altProgramm.remove(i+1);
			}
		
		}
		return altProgramm;
		
	}
	
	
	
}
