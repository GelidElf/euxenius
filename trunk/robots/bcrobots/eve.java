package bcrobots;
import robocode.*;
import java.util.Random;
import java.awt.Color;

/**
 * eve - a robot by Euxenius
 */
public class eve extends Robot
{

		Random r = new Random(System.currentTimeMillis());

	public void run(){
		setColors(Color.red,Color.black,Color.white);
		while(true){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
getOthers();
getOthers();
}else{
getHeading();
doNothing();
}
}else{
doNothing();
turnGunLeft(r.nextDouble());
}
}else{
getOthers();
doNothing();
}
}else{
if (r.nextBoolean()){
doNothing();
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
getHeading();
getOthers();
}
}else{
turnLeft(r.nextDouble());
turnGunRight(r.nextDouble());
}
}
}
		}
	}

	public void onBulletHit(BulletHitEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
getEnergy();
turnLeft(r.nextDouble());
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
turnGunLeft(r.nextDouble());
getOthers();
}
}else{
if (r.nextBoolean()){
doNothing();
turnLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
getOthers();
getName();
}else{
doNothing();
getName();
}
}else{
if (r.nextBoolean()){
getHeading();
doNothing();
}else{
getHeading();
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
getOthers();
e.getBearing();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}else{
turnGunLeft(r.nextDouble());
getHeading();
}
}else{
ahead(r.nextDouble());
turnGunRight(r.nextDouble());
}
}else{
doNothing();
turnGunLeft(r.nextDouble());
}
	}

	public void onHitRobot(HitRobotEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
getOthers();
turnGunLeft(r.nextDouble());
}else{
doNothing();
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
e.getBearing();
getEnergy();
}else{
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
}}}}}else{
if (r.nextBoolean()){
e.getBearing();
fire(r.nextDouble());
fire(r.nextDouble());
}else{
e.getBearing();
turnLeft(r.nextDouble());
turnLeft(r.nextDouble());
}}	}

	public void onHitWall(HitWallEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
turnRight(r.nextDouble());
getOthers();
getHeading();
}else{
doNothing();
doNothing();
ahead(r.nextDouble());
}
}else{
fire(r.nextDouble());
turnRight(r.nextDouble());
}
	}

	public void onScannedRobot(ScannedRobotEvent e){
if (r.nextBoolean()){
turnGunRight(r.nextDouble());
turnLeft(r.nextDouble());
}else{
ahead(r.nextDouble());
getEnergy();
}
	}

}