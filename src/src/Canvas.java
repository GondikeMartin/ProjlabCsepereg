package src;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.IntStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Canvas extends JPanel{
	
	private Field f;
	/**
	 * 
	*/
	private static final long serialVersionUID = -3199843376415906925L;
	
	/**The number of neighbours.*/
	protected int verticesNum;
	
	/**The component on which the drawings happen.*/
	protected Graphics graphics;
	
	/**The visual representer of the enemy virologist if there is any.*/
	protected EnemyView enemy;
	
	/**The visual representer of the equipment if there is any.*/
	protected EquipmentView equipment;
	
	/**The visual representer of the materials if there is any.*/
	protected MaterialView material;
	
	/**The visual representer of the genCode if there is any.*/
	protected GenCodeView genCode;
	
	/**The visual representer of the Bear dancer virologist if there is any.*/
	protected BearView bear;
	
	/**The visual representer of the field where the virologist stands*/
	protected View field;
	
	/**The buttons the user interacts with.*/
	protected JButton[] buttons;
	
	
	/**
	 * default constructor
	 */
	public Canvas(int vert,Field f) {
		
		/*verticesNum = vert;
		 *
		buttons = new JButton[verticesNum];
		for(int i = 0; i < verticesNum; i++) {
			String name=Integer.toString(i+1);
			buttons[i] = new JButton(name);
			this.add(buttons[i]);
		}*/
		//this.setSize(800,700);
		verticesNum = vert;
			//buttons[i].addActionListener(new NumberButtonPressed());

		this.f=f;
		enemy = new EnemyView();
		equipment = new EquipmentView();
		material = new MaterialView();
		genCode = new GenCodeView();
		bear = new BearView();
	}
	
	/**
	 * Responsible for adding the buttons representing the choice which way the user want to move.
	 */
	public void Draw(int vertices) {
		
		switch(vertices) {
		case 3:
			buttons[0].setBounds(200, 350, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(350, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 300, 150, 100);
			buttons[2].setVisible(true);
			
			
			break;
		case 4:
			buttons[0].setBounds(350, 100, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(600, 350, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 600, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(100, 600, 150, 100);
			buttons[3].setVisible(true);
			break;
		case 5:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			break;
		case 6:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			buttons[5].setBounds(350, 150, 150, 100);
			buttons[5].setVisible(true);
			break;
		case 7:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			buttons[5].setBounds(350, 150, 150, 100);
			buttons[5].setVisible(true);
			buttons[6].setBounds(150, 150, 150, 100);
			buttons[6].setVisible(true);
			break;
		case 8:
			buttons[0].setBounds(450, 150, 150, 100);
			buttons[0].setVisible(true);
			buttons[1].setBounds(400, 400, 150, 100);
			buttons[1].setVisible(true);
			buttons[2].setBounds(350, 500, 150, 100);
			buttons[2].setVisible(true);
			buttons[3].setBounds(300, 400, 150, 100);
			buttons[3].setVisible(true);
			buttons[4].setBounds(250, 150, 150, 100);
			buttons[4].setVisible(true);
			buttons[5].setBounds(350, 150, 150, 100);
			buttons[5].setVisible(true);
			buttons[6].setBounds(150, 150, 150, 100);
			buttons[6].setVisible(true);
			buttons[7].setBounds(150, 400, 150, 100);
			buttons[7].setVisible(true);
			break;
		default:
			break;
			
		}

	}
	
	/**
	 * Action listener for numbered buttons. This method selects the field on which the virologist will move to.
	 * @param e button event
	 */
	public class NumberButtonPressed implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			/**iterates through the list of buttons*/
			for(int i = 0; i < buttons.length; i++) {
				/**if the i-th button was pressed...*/
				if(buttons[i].getModel().isPressed()) {
					/**...the attribute "f" gets set to the i-th neighbour of the current "f" field*/
					f = f.GetNeighbours().get(i);
				}
			/**screen gets refreshed*/
			Refresh(graphics, f);
			}
			
		}
	}
	

	public void Refresh(Graphics g,Field f) {
		
		this.f=f;
		verticesNum = f.GetNeighbours().size();
		buttons = new JButton[verticesNum];
		for(int i = 0; i < verticesNum; i++) {
			String name=Integer.toString(i+1);
			buttons[i] = new JButton(name);
			this.add(buttons[i]);
		}
		switch(f.toString()) {
			case "Warehouse":
			{
				field = new WarehouseView(verticesNum);
				material.Draw(g, new Point(300, 300));
				
				break;
			}
			case "Shelter":
			{
				field = new ShelterView(verticesNum);
				break;
			}
			case "Laboratory":
			{
				field = new LaborView(verticesNum);
				genCode.Draw(g, new Point(350, 350));
				break;
			}
			default:
			{
				field = new FieldView(verticesNum);
				break;
			}
		}
		field.Draw(graphics, new Point(100,100));
		thingsPaint(g);
		this.repaint();
	}
	
	public void thingsPaint(Graphics g) {
		for(Thing t : f.GetThings())
		{
			switch(t.toString()) {
				case "Virologist":{
					enemy.Draw(g, new Point(200,200));
					break;
				}
				case "Axe":{
					equipment.Draw(g, new Point(250, 250));
					break;
				}
				case "Cloak":{
					equipment.Draw(g, new Point(250, 250));
					break;
				}
				case "Gloves":{
					equipment.Draw(g, new Point(250, 250));
					break;
				}
				case "Sack":{
					equipment.Draw(g, new Point(250, 250));
					break;
				}
				default:
					break;
			}
		}
		ArrayList<Virologist> viro= new ArrayList<Virologist>();
		for(Thing t : f.GetThings()) {
			if(t.toString().equals("Virologist"))
				viro.add((Virologist)t);
		}
		for(Virologist v : viro) {
			if(v.isBear()) {
				bear.Draw(g, new Point(400,400));
			}		
		}
			
	}
	
	/**
	 * Responsible for drawing the elements on this field.
	 */
	public void paintComponent(Graphics g) {
		graphics=g;
		super.paintComponent(graphics);
		//
		Refresh(graphics,f);
		/*Point p = new Point(100,100);
		field.Draw(g,p);
		enemy.Draw(g, new Point(200,200));
		equipment.Draw(g, new Point(250, 250)); 
		material.Draw(g, new Point(300, 300));
		genCode.Draw(g, new Point(350, 350));
		bear.Draw(g, new Point(400,400));
		
		/*g.setColor(Color.black);
		Dimension dimension = new Dimension(700, 700);
        g.fillRect(0, 0, dimension.width, dimension.height);*/
		
		//graphics.dispose();
	}

	

}
