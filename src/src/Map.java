package src;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Vili
 * Map
 * It is responsible for drawing fields.
 *
 */
public class Map {
	
	/**
	 * Stores all the fields.
	 */
	List<Field> fields;
	
	
	public Map() {
		fields = new ArrayList<Field>();
	}
	/**
	 * It creates the fields for the game and sets their neighbours.
	 */
	public void GenerateFields(ArrayList<Virologist> players) {
		Field hereWeAre = new Field();
		Warehouse warehouse = new Warehouse();
		Shelter shelter = new Shelter();
		Laboratory labor = new Laboratory();
		try {
			hereWeAre.Accept(players.get(0));
			warehouse.Accept(players.get(0));
			shelter.Accept(players.get(0));
		}
		catch(NullPointerException e) {
			System.out.println("Nincs kezdomezo!");
		}
		
		hereWeAre.AddNeighbours(labor);
		hereWeAre.AddNeighbours(warehouse);
		hereWeAre.AddNeighbours(shelter);
		
		labor.CreateGenCode();
		shelter.CreateEquipment();
		warehouse.CreateMaterials();
		
	}
}
