package model.Nodes;

import java.util.Random;

public class ConstantDoubleDistance extends Node {

	public ConstantDoubleDistance(){
		super(new String (new Double(new Random().nextInt(100)).toString()),0,"[]");
		
	}
	
}
