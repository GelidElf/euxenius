package FileSystemManagement;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;


public class ResultsReader {

	OptionsReader _op = null;
	File _resultsFile = null;
	Hashtable<String , Double> _results = null; 
	
	private FileInputStream _fileIS = null;
    private DataInputStream _dataIS = null;
    private BufferedReader _bufR = null;
	
	public ResultsReader (OptionsReader op){
		
		_op = op;
		_resultsFile = new File(_op.get_resultsFileName());
		if (!_resultsFile.exists())
			try {
				_resultsFile.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		_results = processResultFile();
		
	}

	private Hashtable<String, Double> processResultFile() {
		
		Hashtable<String, Double> _resultAux = new Hashtable<String, Double>();
		
		
	    String aux = null;

	    try {
	    	_fileIS = new FileInputStream(_resultsFile);

	      // Here BufferedInputStream is added for fast reading.
	      _dataIS = new DataInputStream(_fileIS);
	      _bufR = new BufferedReader(new InputStreamReader(_dataIS));

	      int position = 0;
	      while ((aux = _bufR.readLine()) != null) {
	    	  position++;
	    	  if ((position > 2)&& !aux.equals("")){
	    		  _resultAux.put(processID(aux), processScore(aux));
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
		
		return _resultAux;
	}

	private String processID(String aux) {
		int start = aux.indexOf(" ");
		int end = aux.indexOf(" ",start+1);
		// If there are 2 robots with the same name and team, results file will identify each other with (x)
		//at the end of the name, where x is a number, starting with 1 and incrementing on each of the robots
		//this is why we search for the space, as the results file will have an space between the name and the (x)
		//and if not, we search for the space between the name and the first column.
		if (end == -1){
			end = aux.indexOf("\t",start+1);
		}
		return aux.substring(start+1,end);
	}

	private Double processScore(String aux) {
		int start = aux.indexOf("\t");
		int end = aux.indexOf("\t",start+1);
		return Double.valueOf(aux.substring(start+1,end));
	}
	
	public Double getScore (String name){
		return _results.get(name);
	}
}
