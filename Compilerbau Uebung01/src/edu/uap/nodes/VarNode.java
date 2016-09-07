
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
    	IDNode idNode = (IDNode) this.getChildren().get(0);
    	
    	rho.put(idNode.getAttribute().toString(), new AddressPair(nav, nl));
    	elab.nav = nav +1;
    	
    	return elab;
    }
}
