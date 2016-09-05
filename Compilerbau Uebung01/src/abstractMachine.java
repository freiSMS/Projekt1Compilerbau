

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class abstractMachine {
	private int PC; // Programm Counter
	private int PP; // Parameter Pointer
	private int FP; // Frame Pointer
	private int top; // Oberste Position auf dem Stack
	private Instruction[] prog;
	private boolean initialized = false;	//wird true, wenn ein gültiges Programm geladen wurde
	private boolean debug = false; //bestimmt ob sich das Programm im debug Modus befindet
	//private int[] stack;
	private ArrayList<Integer> stack;

	// private static Stack stack = new Stack ();

	// Konstruktor der Abstrakten Maschine
	public abstractMachine(Instruction[] p) {
		PC = 0;
		PP = 0;
		FP = 0;
		top = 0;
		stack = new ArrayList<Integer>();
		prog = p;
		initialized = true;
	}
	
	public abstractMachine(int pp, int fp, int TOP)	{
		PC = 0;
		PP = pp;
		FP = fp;
		top = TOP;
		stack = new ArrayList<Integer>(TOP +1);
		//Initialisiere die Speicher für die Variablen:
		for (int i = 0; i< top +1; i++)	{
			stack.add(0);
		}
	}

	public abstractMachine() {
		PC = 0;
		PP = 0;
		FP = 0;
		top = 0;
		stack = new ArrayList<Integer>();		
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
					CONST(aktuelleInstruktion.getArg1());
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
				default:
					System.out.println("Die Instruktion an Position " + PC
							+ " wurde nicht als gültiger Maschinenbefehl erkannt.");
					nichterkannteOperationen++;
				}
				

				// Stack auslesen
				StringBuilder deb = new StringBuilder();
				for (Integer s: stack)	{
					deb.append(s + ", ");
				}
				System.out.println("Stack: " + deb.toString() + " \n  " +
						"oberstes Stackelement = " + stack.get(top) + ", Top = " + top
								+ ", PC = " + PC + ", PP: " + PP + ", FP: " + FP);
				
				
				// Ausgabe der Variablen pro Schritt, falls der Debuger eingeschaltet ist. 
				if (debug) {

					System.out.println("Stack: " + deb.toString() + " \n  " +
							"oberstes Stackelement = " + stack.get(top) + ", Top = " + top
									+ ", PC = " + PC + ", PP: " + PP + ", FP: " + FP);
					JOptionPane.showMessageDialog(null,
							"Stack: " + deb.toString() + " \n  " +
							"oberstes Stackelement = " + stack.get(top-1) + ", Top = " + top
									+ ", PC = " + PC + ", PP: " + PP + ", FP: " + FP,
							"Debugmodus", JOptionPane.INFORMATION_MESSAGE);

				}
			}
			System.out.println("Die Ausführung des Programmes war erfolgreich. Währendessen gab es "
					+ nichterkannteOperationen + " nicht erkannte Operationen");
		}
	}

	// Definition der Maschinenbefehle
	private void CONST(int k) {
		stack.add(k);
		top++;
		PC++;
	}

	private void STORE(int k, int d) {
		stack.set(SPP(d, PP, FP) + k, stack.get(top));
		stack.remove(top);
		top--;
		PC++;
	}

	private void LOAD(int k, int d) {
		stack.add(stack.get(SPP(d, PP, FP) + k));
		top++;
		PC++;
	}

	private int SPP(int d, int pp, int fp) {
		if (d == 0) {
			return pp;
		} else {
			return (SPP(d - 1, stack.get(fp + 2), stack.get(fp + 3)));
		}
	}

	private int SFP(int d, int pp, int fp) {
		if (d == 0) {
			return fp;
		} else {
			return (SFP(d - 1, stack.get(fp + 2), stack.get(fp + 3)));
		}
	}

	private void ADD() {
		stack.set(top - 1, stack.get(top - 1) + stack.get(top));
		top--;
		PC++;
	}

	private void SUB() {
		stack.set(top - 1, stack.get(top - 1) - stack.get(top));
		stack.remove(top);
		top--;
		PC++;
	}

	private void MUL() {
		stack.set(top - 1, stack.get(top - 1) * stack.get(top));
		stack.remove(top);
		top--;
		PC++;
	}

	private void DIV() {
		stack.set(top - 1, stack.get(top - 1) / stack.get(top));
		stack.remove(top);
		top--;
		PC++;
	}

	private void LT() {
		if (stack.get(top -1) < stack.get(top)) {
			stack.set(top - 1, 1);
		} else {
			stack.set(top - 1, 0);
		}
		stack.remove(top);
		top--;
		PC++;
	}

	private void GT() {
		if (stack.get(top - 1) > stack.get(top)) {
			stack.set(top - 1, 0);
		} else {
			stack.set(top - 1, 1);
		}
		stack.remove(top);
		top--;
		PC++;
	}

	private void EQ() {
		if (stack.get(top - 1) == stack.get(top)) {
			stack.set(top - 1, 1);
		} else {
			stack.set(top - 1, 0);
		}
		stack.remove(top);
		top--;
		PC++;
	}

	private void NEQ() {
		if (stack.get(top - 1) != stack.get(top)) {
			stack.set(top - 1, 1);
		} else {
			stack.set(top - 1, 0);
		}
		stack.remove(top);
		top--;
		PC++;
	}

	private void GOTO(int p) {
		PC = p;
	}

	private void IFZERO(int p) {
		if (stack.get(top) == 0) {
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
		stack.add( PP);	//top + 1
		stack.add( FP); //top + 2
		stack.add(SPP(d, PP, FP)); //top + 3
		stack.add(SFP(d, PP, FP)); // top + 4
		stack.add(PC + 1); //top + 5
		PP = top - n + 1;
		FP = top + 1;
		top = top + 5;
		PC = p;
	}

	private void RETURN() {
		int res = stack.get(top);
		top = PP;
		PP = stack.get(FP);
		PC = stack.get(FP + 4);
		FP = stack.get(FP + 1);
		stack.set(top, res);
		
		//Entferne alle Stack Einträge > top
		for(int i = stack.size()-1; i>top ;i--)	{
			stack.remove(i);
		}
	}

}
