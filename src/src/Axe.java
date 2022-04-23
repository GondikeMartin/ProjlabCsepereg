package src;


/**
 * 
 * Axe
 * Inherited from Equipment.
 * It implements the equipment "Axe". Use this equipment to kill a virologist who had been affected by BearDance agent.
 *
 */
public class Axe extends Equipment{
	
	/**
	 * Constructor for axe.
	 */
	public Axe() {
		super();
		useTime = 1;
	}

	/**
	 * Decrease the equipment's effect time
	 */
	@Override
	public void DecreaseEffectTime(Virologist v) {
		//�res
	}
	
	/**
	 * The Axe kills the Virologist in the parameters
	 * @param v - Virologist that is going to be killed
	 * 
	 */
	public void Affect(Virologist v) {
		v.setDead();
	}
	
	/**
	 * Returns the equipment's reduced use-time.
	 * <br>Reduces the use time by one.
	 * @return the reduces value
	 */
	public int DecreaseUseTime() {
		return --useTime;
	}
	
	
	/**
	 * Returns the name of the Effect the Equipment has. 
	 * @return a string containing the name of the Effect
	 */
	public String GetEffectName() {
		return "Axe";
	}
	
	/**
	 * Writes the Attributes of the Equipment in a string.
	 * @return string
	 */
	public String toString() {
		System.out.println("ToString");
		return "Axe" + this.ID;
	}

}