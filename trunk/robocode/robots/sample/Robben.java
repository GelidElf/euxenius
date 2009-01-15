package sample;
import robocode.*;
import java.awt.Color;

public class Robben extends Robot{
private boolean muro = false;
private int sentido = -1;
private int energia = 100;
private double posicion = 0;
private double contador = 500;
private int enfrente = 0;
public void run(){
setColors(Color.white,Color.white,Color.white,Color.white,Color.white);
ahead(1000);
while(true){

ahead(sentido*58);
if (sentido == -1) turnGunRight(180);
else turnGunLeft(180);
}
}

public void onScannedRobot(ScannedRobotEvent enemigo){
String s;
s=enemigo.getName();	
if (s.equals("sample.Guti"))
		{if (enemigo.getDistance() <= 300)
			{
				sentido*=-1;
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
if (contador == 0){
contador++;
posicion = e.getBearing();
}else{
if (e.getBearing() == posicion){
contador++;
}
}
if (contador > 3){
ahead(423);
contador = 0;
posicion = 500;
}
}

public void onHitWall(HitWallEvent e){
if (!muro){
turnLeft(getHeading()%90);
muro = true;
}else{
turnLeft(90);
}
}
}

