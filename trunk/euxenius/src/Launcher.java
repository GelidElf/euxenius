
import java.io.IOException;


/**
 * Esto es un comentario de prueba para ver el google code :D
 * @author GelidElf
 *
 */
public class Launcher {

	
	public static void main(String[] args) {

		
	//primera iteracion?, crear objetos
	OptionsReader _optionsReader = new OptionsReader();
	TemplateReader _templateReader = new TemplateReader();
	ResultsReader _resultReader = new ResultsReader();
	Runtime r = Runtime.getRuntime();
	String _macSystemKey = new String ("mac");
	String _windowsSystemKey = new String ("windows");

	Generator ga = new Generator(_optionsReader.get_team(),_optionsReader.get_robotA());
	Generator gb = new Generator(_optionsReader.get_team(),_optionsReader.get_robotB());
	Factory f = new Factory();
	int generations = 0;
	
	int generationID = 0;
	Process p = null;
	
	ga.createRobot();
	gb.createRobot();
	
	while (generationID <= generations){
		try {
			String osName = new String (System.getProperty("os.name"));
			if (osName.toLowerCase().contains(_windowsSystemKey))
				p = r.exec("robocode.bat");
			if (osName.toLowerCase().contains(_macSystemKey))
				p = r.exec("robocode.sh");
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		generationID++;
	}
	f.writeRobot(_templateReader,ga.get_robot(), new String ( _optionsReader.get_robotA() + ".java"));
	f.writeRobot(_templateReader,ga.get_robot(), new String ( _optionsReader.get_robotB() + ".java"));
	}
	
}
