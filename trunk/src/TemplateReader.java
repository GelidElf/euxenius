

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class TemplateReader {

	public static String Wildcard = "#486&$";
	public static String NameWildcard = "[%&AV#]";
	public static String TeamWildcard = "[%$i56@]";
	
	private String _templateFileName = null;
	private FileInputStream _fileIS = null;
    private DataInputStream _dataIS = null;
    private BufferedReader _bufR = null;
    private Vector<String> _contents = null;
    private int _wildcardPosition = -1;
    private int _namePosition = -1;
    private int _namePosition2 = -1;
    private int _teamPosition = -1;
	
	public TemplateReader(){
		
		_contents = new Vector<String>();
		
		_templateFileName = new String("template.java");
	    File file = new File(_templateFileName);
	    String aux = null;

	    try {
	    	_fileIS = new FileInputStream(file);

	      // Here BufferedInputStream is added for fast reading.
	      _dataIS = new DataInputStream(_fileIS);
	      _bufR = new BufferedReader(new InputStreamReader(_dataIS));

	      // _dataIS.available() returns 0 if the file does not have more lines.
	      while ((aux = _bufR.readLine()) != null) {
	    	  
	    	  if (aux != null){
	    	  _contents.add(aux);
	    	  if (_contents.get(_contents.size()-1).contains(Wildcard))
	    		  _wildcardPosition = _contents.size()-1;
	    	  if (_contents.get(_contents.size()-1).contains(NameWildcard))
	    		  _namePosition = _contents.size()-1;
	    	  if (_contents.get(_contents.size()-1).contains(TeamWildcard))
	    		  _teamPosition = _contents.size()-1;
	    	  // this statement reads the line from the file and print it to
	    	  // the console.
	    	  }
	      }

	      // dispose all the resources after using them.
	      _bufR.close();
	      _dataIS.close();
	      _fileIS.close();

	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	public TemplateReader(String _trn){
		
		_templateFileName = new String(_trn);
	    File file = new File(_templateFileName);

	    try {
	    	_fileIS = new FileInputStream(file);

			// Here BufferedInputStream is added for fast reading.
			_dataIS = new DataInputStream(_fileIS);
			_bufR = new BufferedReader(new InputStreamReader(_dataIS));

			// _dataIS.available() returns 0 if the file does not have more lines.
			while (_dataIS.available() != 0) {
			
				_contents.add(_bufR.readLine());
				if (_contents.get(_contents.size()-1).contains(Wildcard))
					_wildcardPosition = _contents.size()-1;
		    	  if (_contents.get(_contents.size()-1).contains(NameWildcard))
		    		  _namePosition = _contents.size()-1;
				// this statement reads the line from the file and print it to
				// the console.
				System.out.println(_bufR.readLine());
			}
			
			// dispose all the resources after using them.
			_bufR.close();
			_dataIS.close();
			_fileIS.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Vector<String> get_contents(){
		return _contents;
	}
	
	public int get_wildcardPosition(){
		return _wildcardPosition;
	}
	
	public int get_namePosition(){
		return _namePosition;
	}
	
	public int get_teamPosition(){
		return _teamPosition;
	}
	
}
