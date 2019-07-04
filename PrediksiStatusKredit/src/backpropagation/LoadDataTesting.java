package backpropagation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadDataTesting {
	
	static String[][] dataArray;
    public static double TesData[][];	
	static String[] frags;	
	
	
	
public void dataTest() {    	 
	   	
		try{
 	    URL source = new File(F_TestingMasal.txtPath.getText()).toPath().toUri().toURL(); //local file
 	    Scanner in = new Scanner(source.openStream());
 	    if (!in.hasNextLine()) {
 	        System.err.println("Missing headline!");
 	        System.exit(1);
 	    }
 	   List<String[]> data = new ArrayList<>();     
	   
	    while (in.hasNextLine()) {
	        String line = in.nextLine();
	        frags = line.split(";"); 	        
	        data.add(frags);
	       
	    }	    
	    in.close(); 	    
	   
	    dataArray = data.toArray(new String[data.size()][]); 
	    
	    int baris=0;		
        int kolom=0;   
        TesData = new double[dataArray.length][dataArray[0].length];
       for(baris=0; baris<dataArray.length; baris++){           
            for(kolom=0; kolom<dataArray[0].length; kolom++){
            	TesData[baris][kolom]=Double.parseDouble(dataArray[baris][kolom]);                
            }           
        }   
       //System.out.println(dataArray[0][0]);
		}catch (IOException e){}
		
		
       
}

}
