package FileSystemManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ConfigurationManager {

	private OptionsReader _optionsReader = null;
	
	private File _battleFile = null;
	private String _battleConfigString = "robocode.battle.selectedRobots=";
	private int _battleConfigIndex = 0;
	private ArrayList<String> _battleFileContents = null;
	
	private File _batchWindowsFile = null;
	private String _batchWindowsConfigString = "-CONFIGEND-";
	private int _batchWindowsConfigIndex = 0;
	private ArrayList<String> _batchWindowsFileContents = null;
	
	public ConfigurationManager(OptionsReader op) {
		_optionsReader = op;
		_battleFile = new File(_optionsReader.get_battleFile());
		_battleFileContents = new ArrayList<String>();
		_batchWindowsFile = new File(_optionsReader.get_batchWindowsFile());
		_batchWindowsFileContents = new ArrayList<String>();
	}
	
	public void configureBattleFile(){
		readFile(_battleFile,_battleFileContents);
		updateBattleFile();
	}
	
	public void configureBatchWindowsFile(){
		readFile(_batchWindowsFile,_batchWindowsFileContents);
		updateBatchWindowsFile();
	}

	public void readFile(File file, ArrayList<String> contents) {
		
		FileInputStream fileIS = null;
	    DataInputStream  dataIS = null;
	    BufferedReader  bufR = null;

	    try {
	    	fileIS = new FileInputStream(file);

			// Here BufferedInputStream is added for fast reading.
			dataIS = new DataInputStream(fileIS);
			bufR = new BufferedReader(new InputStreamReader(dataIS));

			// _dataIS.available() returns 0 if the file does not have more lines.
			while (processElement(bufR.readLine(),contents) != null) {
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

	private void updateBattleFile(){
		FileOutputStream _fileOS = null;
	    DataOutputStream _dataOS = null;
	    BufferedWriter _bufW = null;
		try{			

			_fileOS = new FileOutputStream(_battleFile);
			_dataOS = new DataOutputStream(_fileOS);
			_bufW = new BufferedWriter(new OutputStreamWriter(_dataOS));
			
			for (int i = 0; i < _battleFileContents.size(); i++) {
				if (i == _battleConfigIndex){
					_bufW.write(newConfigString()+ "\n");
				}
				else{
					if (_battleFileContents.get(i) != null)
						_bufW.write(_battleFileContents.get(i)+ "\n");
				}
				
				
			}
			_bufW.close();
			_dataOS.close();
			_fileOS.close();
			
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private String processElement (String c, ArrayList<String> contents){
		if (c != null){
			c.trim();
			contents.add(c);
			if (c.contains(_battleConfigString)){
				_battleConfigIndex = _battleFileContents.size()-1;
			}			
			if (c.contains(_batchWindowsConfigString)){
				_batchWindowsConfigIndex = _battleFileContents.size();
			}
		}
		return c;
	}

	private String newConfigString (){
		String newConfigString = _battleConfigString;
		newConfigString = newConfigString.concat(_optionsReader.get_team() + "." + _optionsReader.get_robotA()+ ",");
		newConfigString = newConfigString.concat(_optionsReader.get_team() + "." + _optionsReader.get_robotB()+ ",");
		newConfigString = newConfigString.concat(_optionsReader.get_team() + "." + _optionsReader.get_robotA()+ _optionsReader.get_offspring() +",");
		newConfigString = newConfigString.concat(_optionsReader.get_team() + "." + _optionsReader.get_robotB()+ _optionsReader.get_offspring() +",");
		newConfigString = newConfigString.concat(_optionsReader.get_extraRobots());
		return newConfigString;
	}
	
	private void updateBatchWindowsFile(){
		FileOutputStream _fileOS = null;
	    DataOutputStream _dataOS = null;
	    BufferedWriter _bufW = null;
		try{			

			_fileOS = new FileOutputStream(_batchWindowsFile);
			_dataOS = new DataOutputStream(_fileOS);
			_bufW = new BufferedWriter(new OutputStreamWriter(_dataOS));
			
			_bufW.write("set robotA=" + _optionsReader.get_robotA() + "\n");
			_bufW.write("set robotB=" + _optionsReader.get_robotB() + "\n");
			_bufW.write("set robotA2=" + _optionsReader.get_robotA() + _optionsReader.get_offspring() + "\n");
			_bufW.write("set robotB2=" + _optionsReader.get_robotB() + _optionsReader.get_offspring() + "\n");
			_bufW.write("set team=" + _optionsReader.get_team() + "\n");
			_bufW.write("set battle=" + _optionsReader.get_battleFile() + "\n");
			_bufW.write("set resultFile=" + _optionsReader.get_resultsFileName() + "\n");
			_bufW.write("set robocodeHome=" + _optionsReader.get_robocodeHome() + "\n");
			
			for (int i = _batchWindowsConfigIndex; i < _batchWindowsFileContents.size(); i++) {
				_bufW.write(_batchWindowsFileContents.get(i)+ "\n");
			}
			
			_bufW.close();
			_dataOS.close();
			_fileOS.close();
			
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
