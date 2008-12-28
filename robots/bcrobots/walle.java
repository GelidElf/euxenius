package bcrobots;
import robocode.*;
import java.util.Random;
//import java.awt.Color;

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
doNothing();
turnGunRight(r.nextDouble());
}else{
turnGunLeft(r.nextDouble());
turnGunRight(r.nextDouble());
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
getOthers();
getOthers();
turnGunRight(r.nextDouble());
}
}
}else{
turnLeft(r.nextDouble());
turnGunLeft(r.nextDouble());
}
		}
	}
/n	public void onBulletHit(BulletHitEvent e){
if (r.nextBoolean()){
getName();
getHeading();
turnGunRight(r.nextDouble());
getName();
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
turnGunLeft(r.nextDouble());
getHeading();
getOthers();
}else{
turnLeft(r.nextDouble());
getOthers();
}
}else{
getName();
getOthers();
}
}
	}
/n	public void onHitByBullet(HitByBulletEvent e){
if (r.nextBoolean()){
getOthers();
fire(r.nextDouble());
}else{
if (r.nextBoolean()){
doNothing();
getBearing();
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
getHeading();
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
/n	public void onHitRobot(HitRobotEvent e){
if (r.nextBoolean()){
ahead(r.nextDouble());
turnLeft(r.nextDouble());
}else{
turnGunRight(r.nextDouble());
turnLeft(r.nextDouble());
}	}
/n	public void onHitWall(HitWallEvent e){
if (r.nextBoolean()){
if (r.nextBoolean()){
if (r.nextBoolean()){
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
}else{
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
}
}else{
turnGunRight(r.nextDouble());
getHeading();
}
}else{
ahead(r.nextDouble());
getHeading();
getBearing();
}
	}
/n	public void onScannedRobot(ScannedRobotEvent e){
if (r.nextBoolean()){
ahead(r.nextDouble());
turnGunLeft(r.nextDouble());
}else{
if (r.nextBoolean()){
if (r.nextBoolean()){
turnRight(r.nextDouble());
getName();
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
getVelocity();
getHeading();
}
}
	}
/n}
