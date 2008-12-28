
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
							writeBulletHit(_bufW, robot);
							writeHitByBullet(_bufW,robot);
							writeHitRobot(_bufW, robot);
							writeHitWall(_bufW, robot);
							writeScannedRobot(_bufW, robot);
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
		bufW.write("\tpublic void run(){\n");
		bufW.write("\t\tsetColors(Color.red,Color.black,Color.white);\n");
		bufW.write("\t\twhile(true){\n");
		bufW.write(robot.get_run().get_value());
		bufW.write("\t\t}\n");
		bufW.write("\t}\n");
	}

	private void writeBulletHit(BufferedWriter bufW, Solution robot) throws IOException{
		bufW.write("\tpublic void onBulletHit(BulletHitEvent e){\n");
		bufW.write(robot.get_bulletHit().get_value());
		bufW.write("\t}\n");
	}
	private void writeHitByBullet(BufferedWriter bufW, Solution robot) throws IOException{
		bufW.write("\tpublic void onHitByBullet(HitByBulletEvent e){\n");
		bufW.write(robot.get_hitByBullet().get_value());
		bufW.write("\t}\n");
	}
	private void writeHitRobot(BufferedWriter bufW, Solution robot) throws IOException{
		bufW.write("\tpublic void onHitRobot(HitRobotEvent e){\n");
		bufW.write(robot.get_hitRobot().get_value());
		bufW.write("\t}\n");
	}
	private void writeHitWall(BufferedWriter bufW, Solution robot) throws IOException{
		bufW.write("\tpublic void onHitWall(HitWallEvent e){\n");
		bufW.write(robot.get_hitWall().get_value());
		bufW.write("\t}\n");
	}
	private void writeScannedRobot(BufferedWriter bufW, Solution robot) throws IOException{
		bufW.write("\tpublic void onScannedRobot(ScannedRobotEvent e){\n");
		bufW.write(robot.get_scannedRobot().get_value());
		bufW.write("\t}\n");
	}
	
	/*
	public Vector<String> createMethodText (int method, Vector<String> code){
		
		
	}
	*/
}
