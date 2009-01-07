package model;

import java.io.Serializable;
import java.util.Vector;

import model.Nodes.Node;


public class Solution implements Serializable{

	//Guarda los arboles de todos los métodos de una solucion especifica.
	//Guarda la representacion (código) de los árboles
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7662953218550600666L;
	
	private String _team = null;
	private String _name = null;
	
	private Node _run = null;
	private Node _bulletHit = null;
	private Node _hitByBullet = null;
	private Node _hitRobot = null;
	private Node _hitWall = null;
	private Node _scannedRobot = null;
	
	private Vector<Vector<String>> _textArray = null;
	private int _length = 0;
	
	public Solution( String _t, String _n){
		set_team(_t);
		set_name(_n);
		_textArray = new Vector<Vector<String>>();
		_run = null;
		_bulletHit = null;
		_hitByBullet = null;
		_hitRobot =null;
		_hitWall = null;
		_scannedRobot = null;
	}
	
	public Vector<String> getText(int segment){
		
		return _textArray.get(segment);
	}

	
	
	
	public Node get_run() {
		return _run;
	}

	public void set_run(Node _run) {
		this._run = _run;
	}

	public Node get_bulletHit() {
		return _bulletHit;
	}

	public void set_bulletHit(Node hit) {
		_bulletHit = hit;
	}

	public Node get_hitByBullet() {
		return _hitByBullet;
	}

	public void set_hitByBullet(Node byBullet) {
		_hitByBullet = byBullet;
	}

	public Node get_hitRobot() {
		return _hitRobot;
	}

	public void set_hitRobot(Node robot) {
		_hitRobot = robot;
	}

	public Node get_hitWall() {
		return _hitWall;
	}

	public void set_hitWall(Node wall) {
		_hitWall = wall;
	}

	public Node get_scannedRobot() {
		return _scannedRobot;
	}

	public void set_scannedRobot(Node robot) {
		_scannedRobot = robot;
	}

	public int get_length() {
		return _length;
	}

	public void set_length(int _length) {
		this._length = _length;
	}

	public void set_team(String _team) {
		this._team = _team;
	}

	public String get_team() {
		return _team;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_name() {
		return _name;
	}
	
}
