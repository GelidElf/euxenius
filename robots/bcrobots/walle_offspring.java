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
if (r.nextBoolean()){
getOthers();
turnRight(r.nextDouble());
}else{
ahead(r.nextDouble());
getOthers();
}
}else{
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
getHeading();
getOthers();
}
turnRight(r.nextDouble());
}
		}
	}

	public void onBulletHit(BulletHitEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
turnGunLeft(r.nextDouble());
doNothing();
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
doNothing();
}else{
doNothing();
}
}else{
getHeading();
doNothing();
}
}
turnLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
getName();
if (r.nextBoolean()){
getHeading();
doNothing();
}else{
getOthers();
doNothing();
}
}else{
turnGunLeft(r.nextDouble());
turnRight(r.nextDouble());
}
}
	}

	public void onHitByBullet(HitByBulletEvent e){
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
doNothing();
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
e.getBearing();
e.getBearing();
}else{
getName();
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
}else{
turnGunLeft(r.nextDouble());
if (r.nextBoolean()){
if (r.nextBoolean()){
getOthers();
getName();
}else{
doNothing();
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

	public void onHitRobot(HitRobotEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
turnGunRight(r.nextDouble());
turnGunRight(r.nextDouble());
}else{
getName();
if (r.nextBoolean()){
getOthers();
getOthers();
}else{
getName();
getOthers();
}}}else{
e.getBearing();
ahead(r.nextDouble());
}	}

	public void onHitWall(HitWallEvent e){
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
getHeading();
getOthers();
}
}else{
if (r.nextBoolean()){
turnGunRight(r.nextDouble());
turnGunLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
e.getBearing();
e.getBearing();
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
turnGunLeft(r.nextDouble());
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
}else{
if (r.nextBoolean()){
turnLeft(r.nextDouble());
turnGunLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
e.getBearing();
doNothing();
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

	public void onScannedRobot(ScannedRobotEvent e){
if (r.nextBoolean()){
doNothing();
getVelocity();
}else{
e.getBearing();
turnGunLeft(r.nextDouble());
}
	}

}
