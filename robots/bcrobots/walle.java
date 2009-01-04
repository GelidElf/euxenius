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
turnGunLeft(r.nextDouble());
turnGunLeft(r.nextDouble());
getOthers();
}else{
if (r.nextBoolean()){
doNothing();
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
if (r.nextBoolean()){
getHeading();
getHeading();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}
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
turnGunLeft(r.nextDouble());
}
}
		}
	}

	public void onBulletHit(BulletHitEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
fire(r.nextDouble());
turnRight(r.nextDouble());
}else{
fire(r.nextDouble());
ahead(r.nextDouble());
}
}else{
turnGunRight(r.nextDouble());
turnGunLeft(r.nextDouble());
}
	}

	public void onHitByBullet(HitByBulletEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
turnLeft(r.nextDouble());
turnRight(r.nextDouble());
}else{
ahead(r.nextDouble());
fire(r.nextDouble());
}
fire(r.nextDouble());
}else{
getName();
e.getBearing();
}
	}

	public void onHitRobot(HitRobotEvent e){
if (r.nextBoolean()){
ahead(r.nextDouble());
fire(r.nextDouble());
}else{
if (r.nextBoolean()){
turnLeft(r.nextDouble());
getOthers();
}else{
turnRight(r.nextDouble());
turnLeft(r.nextDouble());
}}	}

	public void onHitWall(HitWallEvent e){
if (r.nextBoolean()){
getHeading();
turnLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
fire(r.nextDouble());
turnGunLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
getHeading();
e.getBearing();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}else{
if (r.nextBoolean()){
e.getBearing();
getHeading();
}else{
getHeading();
e.getBearing();
}
}
}
}
	}

	public void onScannedRobot(ScannedRobotEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
getEnergy();
ahead(r.nextDouble());
}else{
turnGunRight(r.nextDouble());
getHeading();
}
}else{
fire(r.nextDouble());
getName();
}
}else{
if (r.nextBoolean()){
turnLeft(r.nextDouble());
getVelocity();
e.getDistance();
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
e.getDistance();
getEnergy();
}
}
getEnergy();
}
	}

}
