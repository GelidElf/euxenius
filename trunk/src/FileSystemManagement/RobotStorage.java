package FileSystemManagement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import model.Solution;


public class RobotStorage {

	OptionsReader _optionsReader = null;
	
	public RobotStorage(OptionsReader op){
		_optionsReader = op;
		
	}
	
	public void save(Solution robot){
		String directory = new String(_optionsReader.get_bestStoragePath()+ "/" + robot.get_team());
		File d = new File(directory);
		d.mkdirs();
		try{
			File f = new File(d.getPath()+"/"+robot.get_name()+".rob");
			if (!f.exists())
				f.createNewFile();
			// Write to disk with FileOutputStream
			FileOutputStream f_out = new FileOutputStream(f);
			
			// Write object with ObjectOutputStream
			ObjectOutputStream obj_out = new ObjectOutputStream (f_out);
			
			// Write object out to disk
			obj_out.writeObject ( robot );
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public HashMap<String,HashMap<String,File>> getSavedRobots(){
		HashMap<String,HashMap<String,File>> savedRobots = new HashMap<String,HashMap<String,File>>();
		File d = new File(_optionsReader.get_bestStoragePath());
		File[] directory = d.listFiles();
		String robotName = null;
		HashMap<String,File> robotFiles = null;
		File[] teams = d.listFiles();
		int nameEnd = 0;
		for (int i = 0; i < directory.length; i++) {
			if (directory[i].isDirectory()){
				robotFiles = new HashMap<String,File>();
				teams = directory[i].listFiles();
				for (int j = 0; j < teams.length; j++) {
					nameEnd = teams[j].getName().indexOf(".");
					robotName = teams[j].getName().substring(0, nameEnd);
					robotFiles.put(robotName, teams[j]);
				}
				savedRobots.put(directory[i].getName(), robotFiles);
			}
		}
		return savedRobots;
	}
	
	public Solution restoreRobot(File f){
		try{
			// Read from disk using FileInputStream
			FileInputStream f_in = new FileInputStream(f);
	
			// Read object using ObjectInputStream
			ObjectInputStream obj_in = new ObjectInputStream (f_in);
	
			// Read an object
			Object obj = obj_in.readObject();
	
			if (obj instanceof Solution)
			{
				// Cast object to a Solution
				Solution s = (Solution) obj;
				return s;
			}
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
