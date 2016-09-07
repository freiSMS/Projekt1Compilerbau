
package edu.uap.nodes;

import java.util.HashMap;

import edu.uap.AddressPair;
import edu.uap.CompilerFabrik;
import edu.uap.Elab;
import edu.uap.TramLabel;

public class FuncNode extends Node
{
    public FuncNode()
    {
        super("FUNC");
    }
    
    //Funktion, welche den Speicher des Funktionsaufruf berechnet und zurückgibt
    @Override
    public Elab elab_def(Elab elab, int nl)	{
    	//....
    	CompilerFabrik.addLabel(nl, rho);		//ist das richtig? hier ist keine zahl der key
    	int label = CompilerFabrik.labelCount;
    	
    	int nav = elab.nav;
    	HashMap<String, AddressPair> rho = elab.rho;
    	
    	IDNode d1 = (IDNode) this.getChildren().get(0);
    	rho.put(d1.getAttribute().toString(), new AddressPair(label, nl ));	//Für jedes dieser Kinder muss eine PseudoInstruktion eingefügt werden
    	
    	return elab;
    }
}
