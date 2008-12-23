package eve;
import robocode.*;
import java.util.Random;
//import java.awt.Color;

/**
 * [%&AV#] - a robot by Euxenius
 */
public class bcrobots extends Robot
{

		Random r = new Random(System.currentTimeMillis());

	public void run(){
		setColors(Color.red,Color.black,Color.white);
		while(true){
if (r.nextBoolean()){
getHeading();}else{
getOthers();}
		}
	}
}
