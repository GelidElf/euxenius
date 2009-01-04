package bcrobots;
import robocode.*;
import java.util.Random;
import java.awt.Color;

/**
 * eve_offspring - a robot by Euxenius
 */
public class eve_offspring extends Robot
{

		Random r = new Random(System.currentTimeMillis());

	public void run(){
		setColors(Color.red,Color.black,Color.white);
		while(true){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
getHeading();
}else{
getOthers();
doNothing();
}
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
getOthers();
turnGunRight(r.nextDouble());
}else{
fire(r.nextDouble());
doNothing();
getOthers();
}
}else{
doNothing();
ahead(r.nextDouble());
}
}
		}
	}

	public void onBulletHit(BulletHitEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}else{
getHeading();
turnRight(r.nextDouble());
}
}else{
getName();
doNothing();
}
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
doNothing();
doNothing();
}
}else{
getHeading();
getHeading();
}
}else{
if (r.nextBoolean()){
getName();
turnGunRight(r.nextDouble());
}else{
if (r.nextBoolean()){
getOthers();
getOthers();
}else{
getEnergy();
getHeading();
}
}
}
}
	}

	public void onHitByBullet(HitByBulletEvent e){
if (r.nextBoolean()){
fire(r.nextDouble());
turnGunRight(r.nextDouble());
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
getOthers();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}else{
if (r.nextBoolean()){
getName();
getName();
}else{
getOthers();
doNothing();
}
}
}else{
getHeading();
turnGunLeft(r.nextDouble());
}
}
	}

	public void onHitRobot(HitRobotEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}else{
getHeading();
getHeading();
}}else{
if (r.nextBoolean()){
getEnergy();
e.getBearing();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}}}else{
if (r.nextBoolean()){
turnGunRight(r.nextDouble());
fire(r.nextDouble());
}else{
if (r.nextBoolean()){
getOthers();
e.getBearing();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}}}}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
getHeading();
getName();
}else{
getName();
getOthers();
}}else{
doNothing();
getEnergy();
e.getBearing();
}}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
getOthers();
getHeading();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}}else{
getHeading();
getName();
}}}	}

	public void onHitWall(HitWallEvent e){
if (r.nextBoolean()){
turnRight(r.nextDouble());
getHeading();
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
if (r.nextBoolean()){
e.getBearing();
getHeading();
}else{
getHeading();
getOthers();
}
}
}else{
ahead(r.nextDouble());
turnGunLeft(r.nextDouble());
}
}
	}

	public void onScannedRobot(ScannedRobotEvent e){
if (r.nextBoolean()){
e.getDistance();
turnLeft(r.nextDouble());
turnRight(r.nextDouble());
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
getName();
e.getBearing();
}
turnRight(r.nextDouble());
}else{
getOthers();
e.getBearing();
}
}
	}

}
