package bcrobots;
import robocode.*;
import java.util.Random;
import java.awt.Color;

/**
 * walle - a robot by Euxenius
 */
public class walle extends Robot
{

		Random r = new Random(System.currentTimeMillis());

	public void run(){
		setColors(Color.red,Color.black,Color.white);
		while(true){
if (r.nextBoolean()){
turnRight(r.nextDouble());
turnLeft(r.nextDouble());
}else{
turnRight(r.nextDouble());
turnLeft(r.nextDouble());
}
		}
	}

	public void onBulletHit(BulletHitEvent e){
if (r.nextBoolean()){
turnGunLeft(r.nextDouble());
turnGunRight(r.nextDouble());
}else{
getHeading();
doNothing();
}
	}

	public void onHitByBullet(HitByBulletEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
doNothing();
}else{
getHeading();
e.getBearing();
}
doNothing();
}else{
turnRight(r.nextDouble());
turnRight(r.nextDouble());
}
}else{
turnGunLeft(r.nextDouble());
if (r.nextBoolean()){
e.getBearing();
getOthers();
}else{
getHeading();
e.getBearing();
}
turnGunRight(r.nextDouble());
}
	}

	public void onHitRobot(HitRobotEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
getHeading();
getOthers();
getName();
}else{
if (r.nextBoolean()){
e.getBearing();
e.getBearing();
}else{
e.getBearing();
getName();
}}}else{
turnGunRight(r.nextDouble());
fire(r.nextDouble());
}}else{
if (r.nextBoolean()){
doNothing();
turnGunRight(r.nextDouble());
}else{
if (r.nextBoolean()){
turnLeft(r.nextDouble());
getHeading();
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}else{
getHeading();
getHeading();
}}}}	}

	public void onHitWall(HitWallEvent e){
if (r.nextBoolean()){
turnGunLeft(r.nextDouble());
turnGunLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
getHeading();
turnGunLeft(r.nextDouble());
}else{
turnGunRight(r.nextDouble());
doNothing();
getOthers();
}
}
	}

	public void onScannedRobot(ScannedRobotEvent e){
if (r.nextBoolean()){
getName();
turnRight(r.nextDouble());
}else{
turnLeft(r.nextDouble());
if (r.nextBoolean()){
turnRight(r.nextDouble());
getEnergy();
}else{
fire(r.nextDouble());
turnGunRight(r.nextDouble());
}
}
	}

}
