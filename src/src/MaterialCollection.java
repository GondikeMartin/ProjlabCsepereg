package src;
import java.io.Serializable;

/**
* MaterialCollecton
* amino - An AminoAcid with amount
* nucle - An Nucleotid with amount
* It represent a collection of the Materials that a player can find on the map.
**/
public class MaterialCollection implements Serializable {
	
	/**The AminoAcid in the collection*/
	private AminoAcid amino;
	
	/**The Nucleotid in the collection*/
	private Nucleotid nucle;
	
	/**
	 * default constructor
	 */
	public MaterialCollection() {

		amino = new AminoAcid();
		nucle = new Nucleotid();
	}

	
	/**
	* Getter to the AminoAcid
	* @return amino
	**/
	public AminoAcid GetAmino(){
		System.out.println("GetAmino");
		return amino;
	}
	
	/**
	* Getter to the Nucleotid
	* @return nucle
	**/
	public Nucleotid GetNucle() {
		System.out.println("GetNucle");
		return nucle;
	}
	
	/**
	 * Sets the amount of the Materials to zero.
	 */
	public void DestroyMaterials() {
		amino.RemoveAmount(amino.GetAmount());
		nucle.RemoveAmount(nucle.GetAmount());
	}
}
