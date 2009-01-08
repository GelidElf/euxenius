import java.util.Random;

import FileSystemManagement.OptionsReader;

import model.Solution;
import model.Nodes.*;


public class Generator {


	
	private Catalogue _catalog = new Catalogue(); 
	private OptionsReader _optionsReader = null;
	private Random r = new Random(System.currentTimeMillis());
	private int _depthLimit = 20;
	
	public Generator(OptionsReader op){
		_optionsReader = op;
	}
	
	public void createRobot(Solution robot){
		robot.set_run(generateRunTree());
		robot.set_bulletHit(generateBulletHitTree());
		robot.set_hitByBullet(generateHitByBulletTree());
		robot.set_hitRobot(generateHitRobotTree());
		robot.set_hitWall(generateHitWallTree());
		robot.set_scannedRobot(generateScannedRobotTree());
		
	}

	public Solution generateOffspring(Solution parent, Double prob){
		Solution offspring = new Solution(parent.get_team(),parent.get_name() + _optionsReader.get_offspring());
		
		offspring.set_run(new Node(parent.get_run()));
		offspring.set_bulletHit(new Node(parent.get_bulletHit()));
		offspring.set_hitByBullet(new Node(parent.get_hitByBullet()));
		offspring.set_hitRobot(new Node(parent.get_hitRobot()));
		offspring.set_hitWall(new Node(parent.get_hitWall()));
		offspring.set_scannedRobot(new Node(parent.get_scannedRobot()));
		mutateRobot(offspring, prob);
		
		
		return offspring;
	}
	
	private Node recombination(Node n){
		
		return n;
	}
	
	private Node recombination(Node n1, Node n2){
		
		return n1;
	}
	
	public void mutateRobot(Solution robot, Double probability){
		mutateTree(robot.get_run(),probability);
		mutateTree(robot.get_bulletHit(),probability);
		mutateTree(robot.get_hitByBullet(),probability);
		mutateTree(robot.get_hitRobot(),probability);
		mutateTree(robot.get_hitWall(),probability);
	}
	
	private void  mutateTree(Node root, Double probability){
		Random r = new Random();
		if ((r.nextDouble() > probability) && (root.get_father()!= null)){
			root = mutateNode(root);
		}else{
			for (int i = 0; i < root.get_numberOfChildren(); i++) {
				mutateTree(root.get_children()[i], probability);
			}
		}
	}
	
	private Node mutateNode (Node n){
		Node parent = n.get_father();
		int[] types = null;
		int numChild = 0;
		boolean aux = false;
		int numAux = 0;
		int[] typesAux = null;
		int posAux = 0;
		int pos = 0;
		Node childAux = null;
		for (int i = 0; i < parent.get_numberOfChildren(); i++) {
			if (parent.get_children()[i]==n){
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
				childAux = generateNode(childAux);
				childAux.set_father(parent);
			}
		}
		return childAux;
	}
	
	private Node generateScannedRobotTree() {
		Node n = new IfScannedRobot();
		n.set_depth(0);
		return generateNode(n);
	}

	private Node generateHitWallTree() {
		Node n = new IfHitWall();
		n.set_depth(0);
		return generateNode(n);
	}

	private Node generateHitRobotTree() {
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
	
	
	
}
