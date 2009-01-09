package model.Nodes;

import java.io.Serializable;
import java.util.ArrayList;

public class Node implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3327417896088673391L;

	public static String WILDCARD = new String ("%");
	
	private Node _father = null;
	private String _value = new String();
	private Node[] _children= null;
	private int[][] _childType = null;
	private String _childTypes = null;
	private int _numberOfChildren = -1;
	private int _depth = -1;

	public Node (String v, int nChildren, String cType){
		_value = v;
		_numberOfChildren = nChildren;
		_childTypes = cType.substring(0);
		_childType = parseChildTypeString(_childTypes);
	}
	
	public Node (Node n){
		_father = n.get_father();
		_value = n._value;
		_numberOfChildren = n._numberOfChildren;
		_childTypes = n.get_childTypes().substring(0);
		_childType = parseChildTypeString(_childTypes);
		if (n._children != null)
			_children = copyChildren(n._children);
		_depth = n._depth;
	}
	
	public Node[] get_children() {
		return _children;
	} 

	public void set_children(Node[] _children) {
		this._children = _children;
	}

	public int get_numberOfChildren() {
		return _numberOfChildren;
	}

	public void set_numberOfChildren(int ofChildren) {
		this._numberOfChildren = ofChildren;
	}
	
	public void set_father(Node n){
		_father = n;
		_depth = n._depth + 1;
	}
	
/*	public String getTabs(int tab){
		String s = "";
		while (tab != 0){
			s.concat("\t");
			tab--;
		}
		return s;
	}*/
	
	public String get_name(){
		return _value;
	}
	
	public String get_value (){
		String s = new String();
		String aux = new String(_value);
		int lastPosition = 0;
		int tab = 0;
		
		if (_numberOfChildren == 0){
			s = aux;		
		}else {
			for (int i = 0; i < _numberOfChildren; i++) {
				lastPosition = 0;
				lastPosition = aux.indexOf(WILDCARD, lastPosition);
				if (lastPosition == -1)
					lastPosition = aux.length();
				s = s.concat(aux.substring(0, lastPosition)) + _children[i].get_value();
				
				aux = aux.substring(lastPosition+1, aux.length());
			}
			s = s.concat(aux.substring(0, aux.length()));
		}
/*		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '{')
				tab++;
			if(s.charAt(i) == '}')
				tab--;
			if(s.charAt(i) == '\n')	
				s = s.substring(0, i) + getTabs(tab) + s.substring(i+1, s.length());
		}*/
		return s;
	}
	
	public void set_value (String s){
		this._value = new String(s);
	}
	
	public void set_childrenType(String s){
		_childTypes = s.substring(0);
		_childType = parseChildTypeString(_childTypes);
	}
	
	public Node[] copyChildren (Node[] _n){
		Node[] result = new Node[_n.length];
		for (int i = 0; i < _n.length; i++) {
			result[i] = new Node(_n[i]);
			result[i].set_father(this);
		}
		return result;
	}
	
	private int[][] parseChildTypeString(String s){
		int[][] result = new int[_numberOfChildren][];
		ArrayList<Integer> values = new ArrayList<Integer>(); 
		String buffer = s.substring(0);
		int ini = -1;
		int fin = -1;
		int index = 0;
		int index2 = 0;
		String aux = null;
		for (int i = 0; i < this._numberOfChildren; i++) {
			ini = buffer.indexOf("[");
			fin = buffer.indexOf("]");
			aux = buffer.substring(ini+1,fin);
			buffer = buffer.substring(fin+1);
			index = -1;
			index2 = -1;
			do{
				index = index2+1;
				index2 = aux.indexOf(",",index);
				if (index2 == -1){
					index2 = aux.length();
				}
				if (index < index2)
					values.add(Integer.parseInt(aux.substring(index, index2)));
			}while(index2 != aux.length());
			result[i]=new int[values.size()];
			for (int j = 0; j < values.size(); j++) {
				result[i][j] = values.get(j).intValue();
			}
			values = new ArrayList<Integer>();
		}
		return result;
	}
	
	public int[] get_childType(int i){
		return _childType[i];
	}
	
	public String get_childTypes(){
		return _childTypes;
	}
	
	public Node get_father(){
		return _father;
	}
	
	public void set_depth(int d){
		_depth = d;
	}
	
	public int get_depth(){
		return _depth;
	}
}
