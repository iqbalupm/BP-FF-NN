package backpropagation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadDataInput {
	
	static String[][] dataArray;
    public static double TesData[][];
    public static float fTesData[][];
	static List<Double> target = new ArrayList<>();
	static String[] frags;	
	static double[] ty;
	
	public void csv() {    	 
	   	
		try{
 	    URL source = new File(F_Training.txtPath.getText()).toPath().toUri().toURL(); //local file
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
	        target.add(Double.parseDouble(frags[18]));
	        
	    }	    
	    in.close(); 
	    ty = new double[target.size()];
	    for (int i = 0; i < target.size(); i++)
        {
            ty[i] = target.get(i);
        }
	    //System.out.println(Arrays.toString(ty));
	    dataArray = data.toArray(new String[data.size()][]); 
	    
	    int baris=0;		
        int kolom=0;   
        TesData = new double[dataArray.length][dataArray[0].length-1];
       for(baris=0; baris<dataArray.length; baris++){           
            for(kolom=0; kolom<dataArray[0].length-1; kolom++){
            	TesData[baris][kolom]=Double.parseDouble( dataArray[baris][kolom]);
                
            }
           

        }   
       //System.out.println(TesData[0][7]);
		}catch (IOException e){}
       
}


}
