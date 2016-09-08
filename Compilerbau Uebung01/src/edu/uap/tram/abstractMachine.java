package edu.uap.tram;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import edu.uap.Instruction;

public class abstractMachine {
	private int PC; // Programm Counter
	private int PP; // Parameter Pointer
	private int FP; // Frame Pointer
	private int top; // Oberste Position auf dem Stack
	private Instruction[] prog;
	private boolean initialized = false;	//wird true, wenn ein gültiges Programm geladen wurde
	private boolean debug = false; //bestimmt ob sich das Programm im debug Modus befindet
	//private int[] stack;
	private List<LazzyObject> stack = new ArrayList<LazzyObject>();
	
	
	public final static String pointer = "P";
	public final static String integer = "I";
	public final static String closure = "C";

	// private static Stack stack = new Stack ();

	// Konstruktor der Abstrakten Maschine
	public abstractMachine(Instruction[] p) {
		PC = 0;
		PP = 0;
		FP = 0;
		top = -1;
		prog = p;
		initialized = true;
	}
	
	public abstractMachine(int pp, int fp, int TOP)	{
		PC = 0;
		PP = pp;
		FP = fp;
		top = TOP;
		//Initialisiere die Speicher für die Variablen:
		for (int i = 0; i< top +1; i++)	{
			stack.add(new LazzyObject(0, abstractMachine.integer));
		}
	}

	public abstractMachine() {
		PC = 0;
		PP = 0;
		FP = 0;
		top = -1;
	}

	public void inititalize(Instruction[] p) {
		prog = p;
		initialized = true;
	}
	
	public void debug ()	{
		if (debug == false)	{
			debug = true;
			System.out.println("Der Debug Modus ist nun eingeschaltet. Rufen sie die Methode ein zweites mal auf, um ihn wieder auszuschalten.");
		}
		else	{
			debug = false;
			System.out.println("Der Debuger ist nun ausgeschaltet.");
		}
	}

	public void execute() {
		if (!initialized) {
			System.out.println(
					"Bitte rufen sie zuerst die Methode execute auf und übergeben sie ihr ein Programm, welches aus einem Instruction Array besteht.");
		}

		else {
			System.out.println("Bitte gegen sie einen relativen Dateipfad an, aus dem die Instruktionen erzeugt werden.");


			// Hilfsvariablen:
			Instruction aktuelleInstruktion;
			int nichterkannteOperationen = 0;

			// Solange nicht alle Instruktionen ausgeführt wurden läuft die
			// Schleife
			while (PC >= 0) {

				aktuelleInstruktion = prog[PC];

				// Ausführung der Instruktion auf die der ProgrammCounter zeigt
				switch (aktuelleInstruktion.getOpcode()) {
				case Instruction.CONST:
					CONST(aktuelleInstruktion.getArg1(), abstractMachine.integer);
					break;
				case Instruction.STORE:
					STORE(aktuelleInstruktion.getArg1(), aktuelleInstruktion.getArg2());
					break;
				case Instruction.LOAD:
					LOAD(aktuelleInstruktion.getArg1(), aktuelleInstruktion.getArg2());
					break;
				case Instruction.ADD:
					ADD();
					break;
				case Instruction.SUB:
					SUB();
					break;
				case Instruction.MUL:
					MUL();
					break;
				case Instruction.DIV:
					DIV();
					break;
				case Instruction.LT:
					LT();
					break;
				case Instruction.GT:
					GT();
					break;
				case Instruction.EQ:
					EQ();
					break;
				case Instruction.NEQ:
					NEQ();
					break;
				case Instruction.IFZERO:
					IFZERO(aktuelleInstruktion.getArg1());
					break;
				case Instruction.GOTO:
					GOTO(aktuelleInstruktion.getArg1());
					break;
				case Instruction.HALT:
					HALT();
					break;
				case Instruction.NOP:
					NOP();
					break;
				case Instruction.INVOKE:
					INVOKE(aktuelleInstruktion.getArg1(), aktuelleInstruktion.getArg2(),
							aktuelleInstruktion.getArg3());
					break;
				case Instruction.RETURN:
					RETURN();
					break;
				case Instruction.LAZY:
					LAZY(aktuelleInstruktion.getArg1(), aktuelleInstruktion.getArg2());
					break;
				case Instruction.LAZYRETURN:
					LAZYRETURN();
					break;
				default:
					System.out.println("Die Instruktion an Position " + PC
							+ " wurde nicht als gültiger Maschinenbefehl erkannt.");
					nichterkannteOperationen++;
				}
				

				// Stack auslesen
				StringBuilder deb = new StringBuilder();
				for (LazzyObject s: stack)	{
					deb.append(s.val + ", ");
				}
				
				deb.append("\n oberstes Stackelement: ");
				if(stack.size()>0)	{
					deb.append(stack.get(top).val);
				}
				
				System.out.println("Stack: " + deb.toString() + ", Top = " + top
								+ ", PC = " + PC + ", PP: " + PP + ", FP: " + FP);
				
				
				// Ausgabe der Variablen pro Schritt, falls der Debuger eingeschaltet ist. 
				if (debug) {

/*					System.out.println("Stack: " + deb.toString() + ", Top = " + top
									+ ", PC = " + PC + ", PP: " + PP + ", FP: " + FP);*/
/*					JOptionPane.showMessageDialog(null,
							"Stack: " + deb.toString() + ", Top = " + top
									+ ", PC = " + PC + ", PP: " + PP + ", FP: " + FP,
							"Debugmodus", JOptionPane.INFORMATION_MESSAGE);*/

					/*JOptionPane.showMessageDialog(null,
							"Stack: " + deb.toString() + " \n  " +
							"oberstes Stackelement = " + stack.get(top-1) + ", Top = " + top
									+ ", PC = " + PC + ", PP: " + PP + ", FP: " + FP,
							"Debugmodus", JOptionPane.INFORMATION_MESSAGE);
*/
				}
			}
			System.out.println("Die Ausführung des Programmes war erfolgreich. Währendessen gab es "
					+ nichterkannteOperationen + " nicht erkannte Operationen");
		}
	}

	// Definition der Maschinenbefehle
	private void CONST(int k, String i) {
		stack.add(new LazzyObject(k, i));
		top++;
		PC++;
	}

	private void STORE(int k, int d) {
		stack.set(SPP(d, PP, FP) + k, stack.get(top));
		stack.remove(top);
		top--;
		PC++;
	}
	
	private void LAZY( int k, int p)	{
		stack.set(PP +k, new LazzyObject(top+1, abstractMachine.closure));
		stack.set(top+1, new LazzyObject(p,abstractMachine.pointer));
		stack.set(top+2, new LazzyObject(FP,abstractMachine.integer));  // Merke Werte der Register zum Zeitpunkt der Deklaration 
        stack.set(top+3, new LazzyObject(PP,abstractMachine.integer));
        stack.set(top, stack.get(top+3)); 
        PC = PC + 1; 
	}

	private void LOAD(int k, int d) {
		int spp = SPP(d, PP, FP);
		if (stack.get(spp + k).tag == abstractMachine.integer) {
			stack.add(stack.get(SPP(d, PP, FP) + k));
			top++;
			PC++;
		}
		else if (stack.get(spp + k).equals(abstractMachine.closure))	{
			stack.set(top+1, new LazzyObject(PC+1, abstractMachine.pointer));
			stack.set(top+2, new LazzyObject(spp+ k, abstractMachine.integer));
			stack.set(top+3, new LazzyObject(FP, abstractMachine.integer));
			stack.set(top+4, new LazzyObject(PP, abstractMachine.integer));
			top = top +4;
			PC = stack.get(stack.get(spp +k).val).val;
			FP = stack.get((stack.get(spp +k).val)+1).val;
			PP = stack.get((stack.get(spp +k).val)+2).val;
		}
	}
	
	
	private void LAZYRETURN()	{
		PC = stack.get(top -4).val;
		stack.set(stack.get(top -3).val, stack.get(top));
		FP = stack.get(top -2).val;
		PP = stack.get(top -1).val;
		stack.set(stack.get(top-4).val, stack.get(top));	//****Nochmal prüfen (siehe Folie)
		top = top -4;
	}

	private int SPP(int d, int pp, int fp) {
		if (d == 0) {
			return pp;
		} else {
			return (SPP(d - 1, stack.get(fp + 2).val, stack.get(fp + 3).val));
		}
	}

	private int SFP(int d, int pp, int fp) {
		if (d == 0) {
			return fp;
		} else {
			return (SFP(d - 1, stack.get(fp + 2).val, stack.get(fp + 3).val));
		}
	}

	private void ADD() {
		if(stack.get(top-1).tag != abstractMachine.integer || stack.get(top).tag != abstractMachine.integer)	{
			System.out.println("fehler");
			System.exit(-1);
		}
		stack.set(top - 1, new LazzyObject(stack.get(top - 1).val + stack.get(top).val, abstractMachine.integer));
		top--;
		PC++;
	}
	

	private void SUB() {
		if(stack.get(top-1).tag != abstractMachine.integer || stack.get(top).tag != abstractMachine.integer)	{
			System.out.println("fehler");
			System.exit(-1);
		}
		stack.set(top - 1, new LazzyObject(stack.get(top - 1).val - stack.get(top).val, abstractMachine.integer));
		stack.remove(top);
		top--;
		PC++;
	}

	private void MUL() {
		if(stack.get(top-1).tag != abstractMachine.integer || stack.get(top).tag != abstractMachine.integer)	{
			System.out.println("fehler");
			System.exit(-1);
		}
		stack.set(top - 1, new LazzyObject(stack.get(top - 1).val * stack.get(top).val, abstractMachine.integer));
		stack.remove(top);
		top--;
		PC++;
	}

	private void DIV() {
		if(stack.get(top-1).tag != abstractMachine.integer || stack.get(top).tag != abstractMachine.integer)	{
			System.out.println("fehler");
			System.exit(-1);
		}
		stack.set(top - 1, new LazzyObject(stack.get(top - 1).val / stack.get(top).val, abstractMachine.integer));
		stack.remove(top);
		top--;
		PC++;
	}
	

	private void LT() {
		if(stack.get(top-1).tag != abstractMachine.integer || stack.get(top).tag != abstractMachine.integer)	{
			System.out.println("fehler");
			System.exit(-1);
		}
		if (stack.get(top -1).val < stack.get(top).val) {
			stack.set(top - 1, new LazzyObject(1, abstractMachine.integer));
		} else {
			stack.set(top - 1, new LazzyObject(0, abstractMachine.integer));
		}
		stack.remove(top);
		top--;
		PC++;
	}

	private void GT() {
		if(stack.get(top-1).tag != abstractMachine.integer || stack.get(top).tag != abstractMachine.integer)	{
			System.out.println("fehler");
			System.exit(-1);
		}
		if (stack.get(top - 1).val > stack.get(top).val) {
			stack.set(top - 1, new LazzyObject(0, abstractMachine.integer));
		} else {
			stack.set(top - 1, new LazzyObject(1, abstractMachine.integer));
		}
		stack.remove(top);
		top--;
		PC++;
	}

	private void EQ() {
		if(stack.get(top-1).tag != abstractMachine.integer || stack.get(top).tag != abstractMachine.integer)	{
			System.out.println("fehler");
			System.exit(-1);
		}
		if (stack.get(top - 1).val == stack.get(top).val) {
			stack.set(top - 1, new LazzyObject(1, abstractMachine.integer));
		} else {
			stack.set(top - 1, new LazzyObject(0, abstractMachine.integer));
		}
		stack.remove(top);
		top--;
		PC++;
	}

	private void NEQ() {
		if(stack.get(top-1).tag != abstractMachine.integer || stack.get(top).tag != abstractMachine.integer)	{
			System.out.println("fehler");
			System.exit(-1);
		}
		if (stack.get(top - 1).val != stack.get(top).val) {
			stack.set(top - 1, new LazzyObject(1, abstractMachine.integer));
		} else {
			stack.set(top - 1, new LazzyObject( 0, abstractMachine.integer));
		}
		stack.remove(top);
		top--;
		PC++;
	}

	private void GOTO(int p) {
		PC = p;
	}

	private void IFZERO(int p) {
		if (stack.get(top).val == 0) {
			PC = p;
		} else {
			PC++;
		}
		stack.remove(top);
		top--;
	}

	private void HALT() {
		PC = -1;
	}

	private void NOP() {
		PC++;
	}

	private void INVOKE(int n, int p, int d) {
		stack.add( new LazzyObject(PP, abstractMachine.integer));	//top + 1
		stack.add( new LazzyObject(FP, abstractMachine.integer)); //top + 2
		stack.add(new LazzyObject(SPP(d, PP, FP), abstractMachine.integer)); //top + 3
		stack.add(new LazzyObject(SFP(d, PP, FP), abstractMachine.integer)); // top + 4
		stack.add(new LazzyObject(PC + 1, abstractMachine.pointer)); //top + 5
		PP = top - n + 1;
		FP = top + 1;
		top = top + 5;
		PC = p;
	}

	private void RETURN() {
		LazzyObject res = stack.get(top);
		top = PP;
		PP = stack.get(FP).val;
		PC = stack.get(FP + 4).val;
		FP = stack.get(FP + 1).val;
		stack.set(top, res);
		
		//Entferne alle Stack Einträge > top
		for(int i = stack.size()-1; i>top ;i--)	{
			stack.remove(i);
		}
	}

}
