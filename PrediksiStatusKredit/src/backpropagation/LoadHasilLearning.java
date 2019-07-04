package backpropagation;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadHasilLearning {

	public static double BobotV[][];
	public static double BobotW[][];
	public static double[] Bobotv0;
	public static double[] Bobotw0;
	
	public void Loadv(){
		String[][] dataArray;			
		String[] frags;
		
				
		try{
		 URL source = new File("bobot_V.csv").toPath().toUri().toURL(); //local file
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
		    BobotV = new double[dataArray.length][dataArray[0].length];
		    int baris=0;		
	        int kolom=0;      
	       for(baris=0; baris<dataArray.length; baris++){           
	            for(kolom=0; kolom<dataArray[0].length; kolom++){	            	
	            	BobotV[baris][kolom]=Double.parseDouble( dataArray[baris][kolom]);	                
	            }           
	        }     
	       //System.out.println(BobotV.length);
		}catch (IOException e){}		
	      
	}
	
	public void Loadw(){
		String[][] dataArray;			
		String[] frags;		
		
		try{
		 URL source = new File("bobot_W.csv").toPath().toUri().toURL(); //local file
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
		    BobotW = new double[dataArray.length][dataArray[0].length];
		    int baris=0;		
	        int kolom=0;      
	       for(baris=0; baris<dataArray.length; baris++){           
	            for(kolom=0; kolom<dataArray[0].length; kolom++){	            	
	            	BobotW[baris][kolom]=Double.parseDouble( dataArray[baris][kolom]);	                
	            }           
	        }     
	       
		}catch (IOException e){}		
	      
	}
	
	public void Loadv0(){
				
		String[] frags;
		
		try{
		 URL source = new File("bobot_V0.csv").toPath().toUri().toURL(); //local file
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
		    int baris=0;
		    
		    for (String[] strings : data){
		    	Bobotv0= new double[strings.length];
		    	for(baris=0; baris<strings.length; baris++){ 
		    		Bobotv0[baris] = Double.parseDouble(strings[baris]);
		    	}
		    	
		    }
		    
		}catch (IOException e){}		
	      
	}
	
	public void Loadw0(){
		
		String[] frags;
		
		try{
		 URL source = new File("bobot_W0.csv").toPath().toUri().toURL(); //local file
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
		    int baris=0;
		    
		    for (String[] strings : data){
		    	Bobotw0= new double[strings.length];
		    	for(baris=0; baris<strings.length; baris++){ 
		    		Bobotw0[baris] = Double.parseDouble(strings[baris]);
		    	}
		    	//System.out.println(Arrays.toString(Bobotw0));
		    }
		    
		}catch (IOException e){}		
	      
	}
}
