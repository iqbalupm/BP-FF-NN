package backpropagation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveBobot {
	
	public void savev(){
	
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < F_Training.v.length; i++)
		{
		   for(int j = 0; j < F_Training.unit_hidden; j++)
		   {
		      builder.append(F_Training.v[i][j]+"");
		      if(j < F_Training.unit_hidden)
		         builder.append(";");
		   }
		   builder.append("\n");
		}
		try{
		BufferedWriter writer = new BufferedWriter(new FileWriter("bobot_V.csv"));
		writer.write(builder.toString());
		writer.close();
        }
        
        catch (IOException e){}
	
}

public void savew(){  
	
	StringBuilder builder = new StringBuilder();
	for(int i = 0; i < F_Training.w.length; i++)
	{
	   for(int j = 0; j < F_Training.unit_hidden; j++)
	   {
		  
	      builder.append(F_Training.w[i][j]+";");
	      if(j < F_Training.w.length-1)
	         builder.append(";");
	   }
	   builder.append("\n");
	}
	try{
	BufferedWriter writer = new BufferedWriter(new FileWriter("bobot_W.csv"));
	writer.write(builder.toString());
	writer.close();
    }
    
    catch (IOException e){}

}

public void savev0(){  
	
	
	StringBuilder builder = new StringBuilder();
	
	   for(int j = 0; j < F_Training.unit_hidden; j++)
	   {
	      builder.append(F_Training.v0[j]+"");
	      if(j < F_Training.v0.length)
	         builder.append(";");
	   }
	   builder.append("\n");
	
	try{
	BufferedWriter writer = new BufferedWriter(new FileWriter("bobot_V0.csv"));
	writer.write(builder.toString());
	writer.close();
    }
    
    catch (IOException e){}

}

public void savew0(){  
	
	
	StringBuilder builder = new StringBuilder();
	
	   for(int j = 0; j < F_Training.unit_output; j++)
	   {
	      builder.append(F_Training.w0[j]+"");
	      if(j < F_Training.w0.length)
	         builder.append(";");
	   }
	   builder.append("\n");
	
	try{
	BufferedWriter writer = new BufferedWriter(new FileWriter("bobot_W0.csv"));
	writer.write(builder.toString());
	writer.close();
    }
    
    catch (IOException e){}

}

}
