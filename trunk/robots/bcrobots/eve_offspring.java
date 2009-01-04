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
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
getHeading();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}else{
turnGunLeft(r.nextDouble());
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
getOthers();
getOthers();
}
}else{
if (r.nextBoolean()){
getOthers();
getHeading();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}
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
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
getOthers();
getHeading();
}
}
}else{
turnRight(r.nextDouble());
ahead(r.nextDouble());
}
}
		}
	}

	public void onBulletHit(BulletHitEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
turnLeft(r.nextDouble());
turnGunLeft(r.nextDouble());
}else{
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
ahead(r.nextDouble());
turnGunRight(r.nextDouble());
}
}
}else{
turnRight(r.nextDouble());
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
getOthers();
doNothing();
}
}else{
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
}
}
	}

	public void onHitByBullet(HitByBulletEvent e){
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
e.getBearing();
e.getBearing();
}
}else{
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
}
}else{
if (r.nextBoolean()){
doNothing();
doNothing();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
e.getBearing();
}
}else{
fire(r.nextDouble());
turnRight(r.nextDouble());
}
	}

	public void onHitRobot(HitRobotEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
e.getBearing();
turnGunLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
getName();
getEnergy();
getHeading();
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}}}}else{
turnLeft(r.nextDouble());
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}}}	}

	public void onHitWall(HitWallEvent e){
if (r.nextBoolean()){
doNothing();
turnLeft(r.nextDouble());
getOthers();
}else{
e.getBearing();
e.getBearing();
}
	}

	public void onScannedRobot(ScannedRobotEvent e){
if (r.nextBoolean()){
turnRight(r.nextDouble());
getName();
}else{
doNothing();
getName();
}
	}

}
