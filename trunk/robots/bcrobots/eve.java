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
fire(r.nextDouble());
getOthers();
}else{
if (r.nextBoolean()){
getOthers();
getHeading();
}else{
getHeading();
getOthers();
}
}
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
getOthers();
}else{
doNothing();
getHeading();
}
}
}else{
if (r.nextBoolean()){
fire(r.nextDouble());
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
turnGunRight(r.nextDouble());
fire(r.nextDouble());
}
}
		}
	}

	public void onBulletHit(BulletHitEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
turnRight(r.nextDouble());
fire(r.nextDouble());
ahead(r.nextDouble());
}else{
ahead(r.nextDouble());
if (r.nextBoolean()){
getOthers();
getEnergy();
}else{
doNothing();
getOthers();
}
}
}else{
turnGunRight(r.nextDouble());
getName();
}
	}

	public void onHitByBullet(HitByBulletEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
getName();
turnLeft(r.nextDouble());
}else{
getName();
getHeading();
}
}else{
turnGunLeft(r.nextDouble());
if (r.nextBoolean()){
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
}else{
e.getBearing();
getName();
turnRight(r.nextDouble());
}
}
	}

	public void onHitRobot(HitRobotEvent e){
if (r.nextBoolean()){
turnGunRight(r.nextDouble());
getEnergy();
}else{
if (r.nextBoolean()){
turnLeft(r.nextDouble());
turnRight(r.nextDouble());
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}}else{
getHeading();
getHeading();
}getName();
}}	}

	public void onHitWall(HitWallEvent e){
if (r.nextBoolean()){
getOthers();
ahead(r.nextDouble());
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
getHeading();
}else{
e.getBearing();
e.getBearing();
}
}else{
getHeading();
turnGunRight(r.nextDouble());
getHeading();
getOthers();
}
}
	}

	public void onScannedRobot(ScannedRobotEvent e){
if (r.nextBoolean()){
ahead(r.nextDouble());
turnGunLeft(r.nextDouble());
}else{
turnGunRight(r.nextDouble());
fire(r.nextDouble());
}
	}

}
