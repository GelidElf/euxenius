package model.Nodes;

import java.util.Random;

public class ConstantDoubleFirePower extends Node {

	public ConstantDoubleFirePower(){
		super("Rules.MIN_BULLET_POWER + (r.nextDouble()*(Rules.MAX_BULLET_POWER-Rules.MIN_BULLET_POWER))",0,"[]");
		
	}
	
}
