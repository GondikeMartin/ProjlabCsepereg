package src;

import java.util.ArrayList;

public class BearDance extends Agent {
	
	public BearDance() {
		
	}

	@Override
	public void Affect(Virologist v) {
		v.RandomField();
		
	}

	@Override
	public String GetEffectName() {
		return "BearDance";
	}

}
