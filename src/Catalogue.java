//import java.util.Vector;

import model.Nodes.*;

public class Catalogue {

	//private Vector<Vector<Node>> _nodeTypes = null;
	//private Vector<Vector<Integer>> _typeEquivalents = null;
	
	
	public static  Node getNode(int i){
		switch (i){
		case 1:
			return new ConstantDouble();
		case 2:
			return new MoveAhead();
		case 3:
			return new Fire();
		case 4:
			return new TurnLeft();
		case 5:
			return new TurnRight();
		case 6:
			return new TurnGunLeft();
		case 7:
			return new TurnGunRight();
		case 8:
			return new doNothing();
		case 9:
			return new getOthers();
		case 10:
			return new getHeading();
		case 11:
			return new getBearing();
		case 12:
			return new getDistance();
		case 13:
			return new getEnergy();
		case 14:
			return new getVelocity();
		case 15:
			return new getName();
		case 16:
			return new IfThenElse();
		case 17:
			return new IfScannedRobot();
		case 18:
			return new IfBulletHit();
		case 19:
			return new IfHitRobot();
		case 20:
			return new IfHitWall();
		case 21:
			return new IfHitByBullet();
		case 22:
			return new Condition();
		/*case 23:
			return new SentenceThenElse();
		case 24:
			return new SentenceScannedRobot();
		case 25:
			return new SentenceBulletHit();
		case 26: 
			return new SentenceHitRobot();
		case 27:
			return new SentenceHitWall();
		case 28:
			return new SentenceHitByBullet();*/
		case 29:
			return new MultilineThenElse();
		case 30:
			return new MultilineScannedRobot();
		case 31:
			return new MultilineBulletHit();
		case 32:
			return new MultilineHitRobot();
		case 33:
			return new MultilineHitWall();
		case 34:
			return new MultilineHitByBullet();
		}
		return null;
	}
	
	public static boolean isTerminal(int nodeType){
		return (((nodeType >= 8 ) && (nodeType <= 15)) || (nodeType == 1) || (nodeType == 22));
	}
	
	/*public static boolean isSentence(int nodeType){
		return ((nodeType >= 23 ) && (nodeType <= 28));
	}*/
	
	public static boolean isMultiline(int nodeType){
		return ((nodeType >= 29 ) && (nodeType <= 34));
	}
	
	public static boolean isIf (int nodeType){
		return ((nodeType >= 16 ) && (nodeType <= 21));	
	}
	
}
