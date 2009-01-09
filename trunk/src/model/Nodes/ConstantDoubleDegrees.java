package model.Nodes;

import java.util.Random;

public class ConstantDoubleDegrees extends Node {

	public ConstantDoubleDegrees(){
		super(new String (new Double(new Random().nextInt(360)).toString()),0,"[]");
		
	}
	
}
