package FileSystemManagement;
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
	private String _offspring = null;
	private String _generations = null;
	private String _extraRobots = null;
	private String _battleFile = null;
	private String _batchWindowsFile = null;
	private String _robocodeHome = null;
	private String _generateNewRobots = null;
	
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
		_offspring = new String (_options.get("offspring"));
		_generations = new String (_options.get("generations"));
		_battleFile = new String (_options.get("battlefile"));
		_batchWindowsFile = new String (_options.get("batchwindowsfile"));
		_extraRobots = new String (_options.get("extrarobots"));
		_robocodeHome = new String (_options.get("robocodehome"));
		_generateNewRobots = new String (_options.get("generatenewrobots"));
		
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
			while (processElement(bufR.readLine()) != null) {
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

	private String processElement (String c){
		if (c != null){
			c.trim();
			int pos =-1;
			if (!c.startsWith("//") && c.endsWith(";") && c.contains(":")){
				pos = c.indexOf(':');
				_options.put(new String(c.substring(0, pos)).trim().toLowerCase(), new String(c.substring(pos+1, c.length()-1)).trim());
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
	
	public String get_offspring(){
		return _offspring;
	}
	
	public int get_generations(){
		return Integer.parseInt(_generations);
	}
	
	public String get_extraRobots(){
		return _extraRobots;
	}

	public String get_battleFile(){
		return _battleFile;
	}
	
	public String get_batchWindowsFile(){
		return _batchWindowsFile;
	}
	
	public String get_robocodeHome(){
		return _robocodeHome;
	}

	public boolean getGenerateNewRobots() {
		return Boolean.parseBoolean(_generateNewRobots);
	}
}
