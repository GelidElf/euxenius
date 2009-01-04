package bcrobots;
import robocode.*;
import java.util.Random;
import java.awt.Color;

/**
 * walle_offspring - a robot by Euxenius
 */
public class walle_offspring extends Robot
{

		Random r = new Random(System.currentTimeMillis());

	public void run(){
		setColors(Color.red,Color.black,Color.white);
		while(true){
if (r.nextBoolean()){
turnRight(r.nextDouble());
turnGunLeft(r.nextDouble());
ahead(r.nextDouble());
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
ahead(r.nextDouble());
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
		}
	}

	public void onBulletHit(BulletHitEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
getEnergy();
getHeading();
}
getHeading();
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
getName();
getOthers();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}else{
getOthers();
getName();
ahead(r.nextDouble());
}
}
}else{
if (r.nextBoolean()){
getOthers();
getOthers();
}else{
turnRight(r.nextDouble());
fire(r.nextDouble());
}
}
	}

	public void onHitByBullet(HitByBulletEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
getHeading();
getOthers();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
turnRight(r.nextDouble());
fire(r.nextDouble());
}
}else{
if (r.nextBoolean()){
getOthers();
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
getName();
doNothing();
}
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
getHeading();
getOthers();
}else{
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}else{
getHeading();
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}
}
}
	}

	public void onHitRobot(HitRobotEvent e){
if (r.nextBoolean()){
ahead(r.nextDouble());
ahead(r.nextDouble());
}else{
if (r.nextBoolean()){
getOthers();
turnLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
e.getBearing();
getOthers();
getHeading();
}else{
getName();
turnGunRight(r.nextDouble());
}}}	}

	public void onHitWall(HitWallEvent e){
if (r.nextBoolean()){
doNothing();
turnRight(r.nextDouble());
}else{
fire(r.nextDouble());
turnGunRight(r.nextDouble());
}
	}

	public void onScannedRobot(ScannedRobotEvent e){
if (r.nextBoolean()){
fire(r.nextDouble());
e.getDistance();
}else{
if (r.nextBoolean()){
getName();
getVelocity();
}else{
getOthers();
turnLeft(r.nextDouble());
}
}
	}

}
