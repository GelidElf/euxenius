
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import model.Solution;

import FileSystemManagement.ConfigurationManager;
import FileSystemManagement.OptionsReader;
import FileSystemManagement.ResultsReader;
import FileSystemManagement.RobotStorage;
import FileSystemManagement.TemplateReader;


/**
 * Esto es un comentario de prueba para ver el google code :D
 * @author GelidElf
 *
 */
public class Launcher{

	
	public static void main(String[] args) {

		
		//Create Objects
		OptionsReader _optionsReader = new OptionsReader();
		TemplateReader _templateReader = new TemplateReader();
		ResultsReader _resultReader = null;
		RobotStorage _robotStorage = new RobotStorage(_optionsReader);
		
		Runtime r = Runtime.getRuntime();
		String _macSystemKey = new String ("mac");
		String _windowsSystemKey = new String ("windows");
	
		Factory f = new Factory();
		int generations = _optionsReader.get_generations();
		
		int generationID = 0;
		Double probability = 0.3;
		Process p = null;

		ConfigurationManager _configurationManager = new ConfigurationManager(_optionsReader);
		_configurationManager.configureBattleFile();
		_configurationManager.configureBatchWindowsFile();
		
		
		Generator _generator = new Generator(_optionsReader);
		
		Solution robota = new Solution(_optionsReader.get_team(),_optionsReader.get_robotA());
		Solution robotb = new Solution(_optionsReader.get_team(),_optionsReader.get_robotB());

		HashMap<String,HashMap<String,File>> _sol =_robotStorage.getSavedRobots();
		if (!_optionsReader.getGenerateNewRobots() && !_sol.isEmpty()){
			robota = _robotStorage.restoreRobot(_sol.get(_optionsReader.get_team()).get(_optionsReader.get_robotA()));
			robotb = _robotStorage.restoreRobot(_sol.get(_optionsReader.get_team()).get(_optionsReader.get_robotB()));
		}else{
			_generator.createRobot(robota);
			_generator.createRobot(robotb);
		}
		
		
		while (generationID <= generations){

			Solution robota2 = _generator.generateOffspring(robota,probability);
			Solution robotb2 = _generator.generateOffspring(robotb,probability);
	
			f.writeRobot(_templateReader,robota);
			f.writeRobot(_templateReader,robotb);
			f.writeRobot(_templateReader,robota2);
			f.writeRobot(_templateReader,robotb2);
			
			try {
				String osName = new String (System.getProperty("os.name"));
				if (osName.toLowerCase().contains(_windowsSystemKey))
					p = r.exec("robocode.bat");
					//p = r.exec("cmd /c start /MIN robocode.bat");
				if (osName.toLowerCase().contains(_macSystemKey))
					p = r.exec("robocode.sh");
				
				String line;
				BufferedReader input = new BufferedReader (new InputStreamReader(p.getInputStream()));
				while ((line = input.readLine()) != null) {
			    	System.out.println(line);
			    }
				p.waitFor();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			_resultReader =  new ResultsReader(_optionsReader);
			String robotID = new String(_optionsReader.get_team() + "." + _optionsReader.get_robotA());
			if (_resultReader.getScore(robotID) < _resultReader.getScore(robotID + _optionsReader.get_offspring())){
				robota = robota2;
				robota.set_name(_optionsReader.get_robotA());
			}
			robotID = _optionsReader.get_team() + "." + _optionsReader.get_robotA();
			if (_resultReader.getScore(robotID) < _resultReader.getScore(robotID + _optionsReader.get_offspring())){
				robotb = robotb2;
				robotb.set_name(_optionsReader.get_robotB());
			}
			generationID++;
			if (generationID%10 == 0)
				probability = probability + 6/generations;
			
			System.out.println(generationID);
		}
		
		_robotStorage.save(robota);
		_robotStorage.save(robotb);
		
	}
	
}
