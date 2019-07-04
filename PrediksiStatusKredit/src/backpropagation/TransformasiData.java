package backpropagation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransformasiData {
	
	static String[][] dataArray;
    public static double TesData[][]; 	
	static String[] frags;	
	
public void convert() {    	 
	   	
		try{
 	    URL source = new File(F_Normalisasi.txtPath.getText()).toPath().toUri().toURL(); //local file
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
	    //System.out.println(Arrays.toString(ty));
	    dataArray = data.toArray(new String[data.size()][]); 
	    
	    int baris=0;		
        int kolom=0;   
        TesData = new double[dataArray.length][dataArray[0].length-1];
       for(baris=0; baris<dataArray.length; baris++){           
            for(kolom=0; kolom<dataArray[0].length-1; kolom++){
            	
            	
                if (dataArray[baris][kolom].toString().equals("C")){
             	   dataArray[baris][kolom]="1";
                }else if (dataArray[baris][kolom].toString().equals("I")){
             	   dataArray[baris][kolom]="0";
                }
            	//TesData[baris][kolom]=Double.parseDouble( dataArray[baris][kolom]);
                
            }
           

        }  
       savetrans();
       //System.out.println(TesData[0][7]);
		}catch (IOException e){}
       
}

public void savetrans(){
	
	StringBuilder builder = new StringBuilder();
	for(int i = 0; i < dataArray.length; i++)
	{
	   for(int j = 0; j < dataArray[0].length; j++)
	   {
	      builder.append(dataArray[i][j]+"");
	      if(j < dataArray.length - 1)
	         builder.append(";");
	   }
	   builder.append("\n");
	}
	try{
	BufferedWriter writer = new BufferedWriter(new FileWriter("transformasi.csv"));
	writer.write(builder.toString());
	writer.close();
    }
    
    catch (IOException e){}

}

}
