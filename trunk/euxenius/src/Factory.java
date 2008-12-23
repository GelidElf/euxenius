
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Vector;

import model.Solution;

public class Factory {

	private TemplateReader _templateR = null; 
	
	
	public Factory(){
		_templateR = new TemplateReader();
		
		
	}
	
	public void writeRobot(TemplateReader _template, Solution robot, String _file){
		FileOutputStream _fileOS = null;
	    DataOutputStream _dataOS = null;
	    BufferedWriter _bufW = null;
		try{
			_fileOS = new FileOutputStream(_file);
			_dataOS = new DataOutputStream(_fileOS);
			_bufW = new BufferedWriter(new OutputStreamWriter(_dataOS));
			
			Vector<String> _vT = _template.get_contents();
			
			for (int i = 0; i < _vT.size(); i++) {
				if (i == _template.get_teamPosition()){
					if (_vT.get(i) != null)
						_bufW.write(_vT.get(i).replace(TemplateReader.TeamWildcard, robot.get_team())+"\n");
				}else{
					if (i == _template.get_namePosition()){
						if (_vT.get(i) != null)
							_bufW.write(_vT.get(i).replace(TemplateReader.NameWildcard, robot.get_name())+"\n");
					}else{
						if (i == _template.get_wildcardPosition()){
							writeRun(_bufW,robot);
						}
						else{
							if (_vT.get(i) != null)
								_bufW.write(_vT.get(i)+ "\n");
						}
					}
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
	
	private void writeRun(BufferedWriter bufW, Solution robot) throws IOException{
		/*for (int j = 0; j < robot.getLength(); j++) {
			if (code.getText(j) != null){
				for (int j2 = 0; j2 < code.getText(j).size(); j2++) {
					bufW.write(code.getText(j).get(j2));
				}
			}
			*/
		bufW.write("\tpublic void run(){\n");
		bufW.write("\t\tsetColors(Color.red,Color.black,Color.white);\n");
		bufW.write("\t\twhile(true){\n");
		bufW.write(robot.get_run().get_value());
		bufW.write("\t\t}\n");
		bufW.write("\t}\n");
	}

	/*
	public Vector<String> createMethodText (int method, Vector<String> code){
		
		
	}
	*/
}
