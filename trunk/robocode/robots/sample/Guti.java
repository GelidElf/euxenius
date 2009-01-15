package sample;
import robocode.*;
import java.awt.Color;

/**
 * TerminatorI - a robot by Yago Saez
 */
public class Guti extends Robot
{
private int sentido = -1;
private int enfrente = 0;

public void run(){
setColors(Color.white,Color.white,Color.white,Color.white,Color.white);

while(true){
ahead(sentido * 80);
if (sentido == -1) turnGunLeft(270);
else turnRight(45);
sentido *= -1;
}
}	
public void onScannedRobot(ScannedRobotEvent enemigo){
String s;
s=enemigo.getName();	
if (s.equals("sample.Robben"))
		{
			if (enemigo.getDistance() <= 300)
			{
				turnLeft(enemigo.getBearing()+180);
				ahead(300);
			}
		}
		else
{if (enemigo.getBearing() == 0 || enemigo.getBearing() == 180){
enfrente++;
if (enfrente > 1){
fire(2.0);
fire(1.0);
fire(3.0);
}
}else{
if (enemigo.getDistance() <= 3){
fire(3.0);
fire(3.0);
fire(3.0);
}else if (enemigo.getDistance() <= 300){
fire(131.0/enemigo.getDistance() + 1.5);
}else if (enemigo.getDistance() < 1){
fire(575.0/enemigo.getDistance());
}else{
fire(3.0/enemigo.getDistance());
}
enfrente = 0;
}
}
}

public void onHitByBullet(HitByBulletEvent e) {
ahead(400);
}

public void onHitWall(HitWallEvent e)
{
turnLeft(160);
ahead(350);
}
}

