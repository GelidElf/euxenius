import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class OptionsReader {

	private String _optionsFileName = null;
	
	private String _resultsFileName = null;
	private String _robotA = null;
	private String _robotB = null;
	private String _team = null;
	private String _templateFileName = null;
	private String _bestStoragePath = null;
	
	private HashMap<String, String> _options = null;
	
	public OptionsReader (){
		_optionsFileName = new String ("options.txt");
		_options = new HashMap<String, String>();
		readOptionsFile();
		processOptions();
	}
	
	public OptionsReader (String n){
		_optionsFileName = new String (n);
		_options = new HashMap<String, String>();
		readOptionsFile();
		processOptions();
	}
	
	private void processOptions() {
		_resultsFileName = new String(_options.get("resultados"));
		_robotA = new String(_options.get("robota"));
		_robotB = new String(_options.get("robotb"));
		_team = new String(_options.get("team"));
		_templateFileName = new String(_options.get("template"));
		_bestStoragePath = new String (_options.get("storage"));
	}

	private void readOptionsFile() {
		
		FileInputStream fileIS = null;
	    DataInputStream  dataIS = null;
	    BufferedReader  bufR = null;
	    
		
		_templateFileName = new String(_optionsFileName);
	    File file = new File(_templateFileName);

	    try {
	    	fileIS = new FileInputStream(file);

			// Here BufferedInputStream is added for fast reading.
			dataIS = new DataInputStream(fileIS);
			bufR = new BufferedReader(new InputStreamReader(dataIS));

			// _dataIS.available() returns 0 if the file does not have more lines.
			while (readElement(bufR.readLine()) != null) {
			}
			
			// dispose all the resources after using them.
			bufR.close();
			dataIS.close();
			fileIS.close();
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private String readElement (String c){
		if (c != null){
			c.trim();
			int pos =-1;
			if (!c.startsWith("//") && c.endsWith(";") && c.contains(":")){
				pos = c.indexOf(':');
				_options.put(new String(c.substring(0, pos)).trim().toLowerCase(), new String(c.substring(pos+1, c.length()-1)).trim().toLowerCase());
			}
		}
		return c;
	}

	public String get_optionsFileName() {
		return _optionsFileName;
	}

	public String get_resultsFileName() {
		return _resultsFileName;
	}

	public String get_robotA() {
		return _robotA;
	}

	public String get_robotB() {
		return _robotB;
	}

	public String get_templateFileName() {
		return _templateFileName;
	}

	public String get_bestStoragePath() {
		return _bestStoragePath;
	}
	
	public String get_team(){
		return _team;
	}
	
}
