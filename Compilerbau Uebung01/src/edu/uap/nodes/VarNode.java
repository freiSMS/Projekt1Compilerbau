
package edu.uap.nodes;

import java.util.HashMap;

import edu.uap.AddressPair;
import edu.uap.Elab;
import edu.uap.TramLabel;

public class VarNode extends Node
{
    public VarNode()
    {
        super("VAR");
    }
    
    @Override
    public Elab elab_def(Elab elab, int nl)	{

    	int nav = elab.nav;
    	HashMap<String, AddressPair> rho = elab.rho;
    	
    	//IDNode d1 = (IDNode) this.getChildren().get(0);
    	//rho.put(d1.getAttribute().toString(), new AddressPair(new TramLabel(-1),nl ));	//Für jedes dieser Kinder muss eine PseudoInstruktion eingefügt werden
    	
    	return elab;
    }
}
