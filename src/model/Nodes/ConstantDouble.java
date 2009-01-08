package model.Nodes;

import java.util.Random;

public class ConstantDouble extends Node {

	public ConstantDouble(){
		super(new String (new Double(new Random().nextInt(100)).toString()),0,"[]");
		
	}
	
}
