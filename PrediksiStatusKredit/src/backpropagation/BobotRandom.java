package backpropagation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class BobotRandom {

	
	double vr[][];
	double wr[][];
	double v0r[];
	double w0r[];
	public JFrame frameBRandom;
	private JTextField text_input,text_hiddenlayer;
	private JLabel lbl_input,lbl_hidden;
	private JButton btnGenerate,btnBack;
	private int x_input,HidenLayer;
	
	public void Random(){
		
		x_input = Integer.parseInt(text_input.getText());
		HidenLayer = Integer.parseInt(text_hiddenlayer.getText());
		
		Random r = new Random();
        //membangkitkan bobot input ke layer(v1) secara Random
       int a;
 		int b = 0;
 		vr= new double[x_input][HidenLayer];
        for (a = 0; a < x_input; a++) {
            for (b = 0; b < HidenLayer ; b++) { 
                vr[a][b] = -1.0 + (1.0 - (-1.0)) * r.nextDouble();
                
                //System.out.println(vr[a][b]);
            }
            
            
        }
       
      //membangkitkan bobot bias ke layer(v0) secara Random
        int c ;
        v0r = new double[HidenLayer];
        for (c = 0; c < HidenLayer; c++) {
        	
        	v0r[c] = -1.0 + (1.0 - (-1.0)) * r.nextDouble();
        	//System.out.println(v0r[c]);
        }
      //membangkitkan bobot layer ke output(w1) secara Random
        int k;
        int l = 0;
        wr = new double[1][HidenLayer];
        for (k = 0; k < 1; k++) {
            for (l = 0; l < HidenLayer; l++) {
                wr[k][l] = -1.0 + (1.0 - (-1.0)) * r.nextDouble();
              //System.out.println(wr[k][l]);
            }
        }
      //membangkitkan bobot bias ke output(w0) secara Random
        int d ;
         w0r= new double[1];
        for (d = 0; d < 1; d++) {
        	
        	w0r[d] = -1.0 + (1.0 - (-1.0)) * r.nextDouble();
        	//System.out.println(w0r[d]);
        }
	}
	
public void savevAwal(){
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < x_input; i++)
		{
		   for(int j = 0; j <HidenLayer; j++)
		   {
		      builder.append(vr[i][j]+"");
		      if(j < vr[0].length)
		         builder.append(";");
		   }
		   builder.append("\n");
		}
		try{
		BufferedWriter writer = new BufferedWriter(new FileWriter("bobot_V_Randomsss.csv"));
		writer.write(builder.toString());
		writer.close();
        }
        
        catch (IOException e){}
	
}
	public void savewAwal(){  
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < 1; i++)
		{
		   for(int j = 0; j < HidenLayer; j++)
		   {
			  
		      builder.append(wr[i][j]+";");
		      if(j < wr.length - 1)
		         builder.append(";");
		   }
		   builder.append("\n");
		}
		try{
		BufferedWriter writer = new BufferedWriter(new FileWriter("bobot_W_Randomsss.csv"));
		writer.write(builder.toString());
		writer.close();
	    }
	    
	    catch (IOException e){}

	}

	public void savev0Awal(){  
		
		
		StringBuilder builder = new StringBuilder();
		
		   for(int j = 0; j < HidenLayer; j++)
		   {
		      builder.append(v0r[j]+"");
		      if(j < HidenLayer)
		         builder.append(";");
		   }
		   builder.append("\n");
		
		try{
		BufferedWriter writer = new BufferedWriter(new FileWriter("bobot_V0_Randomsss.csv"));
		writer.write(builder.toString());
		writer.close();
	    }
	    
	    catch (IOException e){}

	}

	public void savew0Awal(){  
		
		
		StringBuilder builder = new StringBuilder();
		
		   for(int j = 0; j < 1; j++)
		   {
		      builder.append(w0r[j]+"");
		      if(j < w0r.length)
		         builder.append(";");
		   }
		   builder.append("\n");
		
		try{
		BufferedWriter writer = new BufferedWriter(new FileWriter("bobot_W0_Randomsss.csv"));
		writer.write(builder.toString());
		writer.close();
	    }
	    
	    catch (IOException e){}

	}
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BobotRandom window = new BobotRandom();
					window.frameBRandom.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public BobotRandom() {
		initialize();
	}	
	
	private void initialize() {
		frameBRandom = new JFrame();
		frameBRandom.setTitle("Generate Bobot");
		frameBRandom.setResizable(false);
		frameBRandom.setBounds(100, 100, 290, 300);
		frameBRandom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameBRandom.getContentPane().setLayout(null);	
	
	JPanel panelParameter = new JPanel();
	panelParameter.setBorder(new TitledBorder(null, "Parameter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelParameter.setBounds(10, 40, 263, 90);
	frameBRandom.getContentPane().add(panelParameter);
	panelParameter.setLayout(null);
	
	lbl_input = new JLabel("Jumlah Input (x)");
	lbl_input.setBounds(10, 22, 92, 14);
	panelParameter.add(lbl_input);
	
	lbl_hidden = new JLabel("Hidden Layer");
	lbl_hidden.setBounds(10, 44, 92, 14);
	panelParameter.add(lbl_hidden);	
	
	
	text_input = new JTextField();
	text_input.setBounds(130, 19, 50, 20);
	panelParameter.add(text_input);
	text_input.setColumns(10);
	
	text_hiddenlayer = new JTextField();
	text_hiddenlayer.setColumns(10);
	text_hiddenlayer.setBounds(130, 41, 50, 20);
	panelParameter.add(text_hiddenlayer);	
	
		
	btnGenerate = new JButton("GENERATE");
	btnGenerate.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {		 
			
			try{
				
				Random();
				savevAwal();
				savewAwal();
				savev0Awal();
				savew0Awal();
				JOptionPane.showMessageDialog(frameBRandom, "Generate Bobot Selesai","SUKSES",JOptionPane.INFORMATION_MESSAGE);
			}catch(Exception err){
				System.out.println(err.getMessage());
				JOptionPane.showMessageDialog(frameBRandom, "Terjadi Kesalahan","ERROR",JOptionPane.ERROR_MESSAGE);
				
			}
		}
	});
	
	btnGenerate.setBounds(10, 140, 123, 47);
	frameBRandom.getContentPane().add(btnGenerate);
		
	btnBack = new JButton("BACK");
	btnBack.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			F_Utama fm = new F_Utama();
			fm.frameMain.setVisible(true);
			frameBRandom.dispose();
		}
	});
	btnBack.setBounds(150, 140, 123, 47);
	frameBRandom.getContentPane().add(btnBack);
	
	}
}
