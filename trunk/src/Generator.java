import java.util.Random;
import java.util.Vector;

import model.Solution;
import model.Nodes.*;


public class Generator {


	
	private Catalogue _catalog = new Catalogue(); 
	
	private Solution _robot = null;
	
	private Random r = new Random(System.currentTimeMillis());
	private int _depthLimit = 5;
//	private int _length = 0;
	
	public Generator(String team, String name){
		_robot = new Solution(team, name);
	}
	
	public void createRobot(){
		//_length = 0;
		_robot.set_run(generateRunTree());
		System.out.println("\n\n"+1+"\n\n");
		//_length = 0;
		_robot.set_bulletHit(generateBulletHitTree());
		System.out.println("\n\n"+2+"\n\n");
		//_length = 0;
		_robot.set_hitByBullet(generateHitByBulletTree());
		System.out.println("\n\n"+3+"\n\n");
		//_length = 0;
		_robot.set_hitRobot(generateHitRobot());
		System.out.println("\n\n"+4+"\n\n");
		//_length = 0;
		_robot.set_hitWall(generateHitWall());
		System.out.println("\n\n"+5+"\n\n");
		//_length = 0;
		_robot.set_scannedRobot(generateScannedRobot());
		System.out.println("\n\n"+6+"\n\n");
		
	}

	private Node generateScannedRobot() {
		Node n = new IfScannedRobot();
		n.set_depth(0);
		return generateNode(n);
	}

	private Node generateHitWall() {
		Node n = new IfHitWall();
		n.set_depth(0);
		return generateNode(n);
	}

	private Node generateHitRobot() {
		Node n = new IfHitRobot();
		n.set_depth(0);
		return generateNode(n);
	}

	private Node generateHitByBulletTree() {
		Node n = new IfHitByBullet();
		n.set_depth(0);
		return generateNode(n);
	}

	private Node generateBulletHitTree() {
		Node n = new IfBulletHit();
		n.set_depth(0);
		return generateNode(n);
	}

	private Node generateRunTree() {
		Node n = new IfThenElse();
		n.set_depth(0);
		return generateNode(n);
	}
	
	private Node generateNode(Node parent){
		Node[] children = new Node[parent.get_numberOfChildren()];
		Node childAux = null;
		int[] types = null;
		int numChild = 0;
		int[] typesAux = null;
		int numAux = 0;
		int pos = 0;
		int posAux = 0;
		boolean aux = false;
		//try{
		//If the node has children
		if (parent.get_numberOfChildren() > 0){
			//For each children we'll do...
			for (int i = 0; i < parent.get_numberOfChildren(); i++){
				//Copy the possible types into array 'types'
				types = parent.get_childType(i);
				//Store number of types available for this children
				numChild = parent.get_childType(i).length;
				//If we're reaching maximum depth...
				if(parent.get_depth() == (_depthLimit-1)){
					aux = true; //We'll use an auxiliary array for types
					//Count number of terminal available from types
					for(int j = 0; j < types.length; j++)
						if(Catalogue.isTerminal(types[j]))
							numAux++;
					//Define dimension for auxiliary types array
					typesAux = new int[numAux];
					//Copy terminals from array 'types'
					for(int j = 0; posAux < numAux; j++){
						if(Catalogue.isTerminal(types[j])){
							typesAux[posAux] = types[j];
							posAux++;
						}
					}
				}
				//Choose random position from array we're using and create child
				if (aux){
					if(numAux != 0){
						pos = r.nextInt(numAux);
						childAux = Catalogue.getNode(typesAux[pos]);
					}
					else
						childAux = Catalogue.getNode(8); //Returns node doNothing()
				}
				else{
					pos = r.nextInt(numChild);	
					childAux = Catalogue.getNode(types[pos]);
				}
				childAux.set_depth(parent.get_depth()+1);
				children[i] = generateNode(childAux);
				children[i].set_father(parent);
				//System.out.println(parent.get_depth()+". "+parent.get_value()+"\n");
				//Reset variables
				aux = false;	
				numAux = 0;
				posAux = 0;
				pos = 0;
			}
			parent.set_children(children);
		}
		/*}catch(StackOverflowError soe){
			System.out.println(parent.get_value());
		}*/
		return parent;
	}
	
	public Solution get_robot(){
		return _robot;
	}
}
