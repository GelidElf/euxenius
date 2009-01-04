
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

import model.Solution;

import FileSystemManagement.OptionsReader;
import FileSystemManagement.ResultsReader;
import FileSystemManagement.TemplateReader;


/**
 * Esto es un comentario de prueba para ver el google code :D
 * @author GelidElf
 *
 */
public class Launcher {

	
	public static void main(String[] args) {

		
		//Create Objects
		OptionsReader _optionsReader = new OptionsReader();
		TemplateReader _templateReader = new TemplateReader();
		ResultsReader _resultReader = null;
		Runtime r = Runtime.getRuntime();
		String _macSystemKey = new String ("mac");
		String _windowsSystemKey = new String ("windows");
	
		Factory f = new Factory();
		int generations = _optionsReader.get_generations();
		
		int generationID = 0;
		Process p = null;

		Generator _generator = new Generator(_optionsReader);
		
		Solution robota = new Solution(_optionsReader.get_team(),_optionsReader.get_robotA());
		_generator.createRobot(robota);
		Solution robotb = new Solution(_optionsReader.get_team(),_optionsReader.get_robotB());
		_generator.createRobot(robotb);
		
		
		while (generationID <= generations){

			Solution robota2 = _generator.generateOffspring(robota);
			Solution robotb2 = _generator.generateOffspring(robotb);
	
			String location = new String("robots/" + _optionsReader.get_team() + "/");
			File file = new File(location);
			if (!file.exists())
				file.mkdirs();
			f.writeRobot(_templateReader,robota);
			f.writeRobot(_templateReader,robotb);
			f.writeRobot(_templateReader,robota2);
			f.writeRobot(_templateReader,robotb2);
			
			try {
				String osName = new String (System.getProperty("os.name"));
				if (osName.toLowerCase().contains(_windowsSystemKey))
					p = r.exec(".\\robocode.bat");
				if (osName.toLowerCase().contains(_macSystemKey))
					p = r.exec("robocode.sh");
				
			      String line;
			      BufferedReader input =
			          new BufferedReader
			            (new InputStreamReader(p.getInputStream()));
			        while ((line = input.readLine()) != null) {
			          System.out.println(line);
			        }
			      
				
			
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			_resultReader =  new ResultsReader(_optionsReader);
			String robotID = new String(_optionsReader.get_team() + "." + _optionsReader.get_robotA());
			if (_resultReader.getScore(robotID) < _resultReader.getScore(robotID + _optionsReader.get_offspring())){
				String nameaux = robota.get_name();
				robota = robota2;
				robota.set_name(nameaux);
			}
			robotID = _optionsReader.get_team() + "." + _optionsReader.get_robotA();
			if (_resultReader.getScore(robotID) < _resultReader.getScore(robotID + _optionsReader.get_offspring())){
				String nameaux = robotb.get_name();
				robotb = robotb2;
				robotb.set_name(nameaux);
			}
			generationID++;
		}
	}
	
}
