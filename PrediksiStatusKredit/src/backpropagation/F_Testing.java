package backpropagation;

import java.awt.EventQueue;
//import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class F_Testing {

	public JFrame frameTesting;
	private JLabel lblInputSatu,lblInputDua,lblInputTiga,lblInputEmpat,lblInputLima,lblInputEnam,lblInputTujuh,lblInputDelapan;
	private static JTextField text_input1;
	private static JTextField text_input2;
	private static JTextField text_input4;
	private static JTextField text_input5;
	private static JTextField text_input6;
	private static JTextField text_input7;
	
	
	private JButton btnProses,btnBack;
	private static JTextArea textArea_Result;
	private static JComboBox<String> TipePinjaman,TipeCKPN;
	private static double x1;
	private static double x2;
	private static double x3;
	private static double x4;
	private static double x5;
	private static double x6;
	private static double x7;
	private static double x8;
	private static double x9;
	private static double x10;
	private static double x11;
	private static double x12;
	private static double x13;
	private static double x14;
	private static double x15;
	private static double x16;
	private static double x17;
	private static double x18;
	

	static String[][] dataArray;
    public static double TesData[][];
    public static float fTesData[][];
	static List<Double> target = new ArrayList<>();
	static String[] frags;	
	static double[] ty;
	public static int jumkol;
    public static int counterdata;
	
	double [] column1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_Testing window = new F_Testing();
					window.frameTesting.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public F_Testing() {
		initialize();
	}
	
	private void initialize() {
		frameTesting = new JFrame();
		frameTesting.setTitle("Testing");
		frameTesting.setResizable(false);
		frameTesting.setBounds(100, 100, 310, 550);
		frameTesting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTesting.getContentPane().setLayout(null);
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(new TitledBorder(null, "Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInput.setBounds(10, 11, 277, 295);
		frameTesting.getContentPane().add(panelInput);
		panelInput.setLayout(null);
		
		lblInputSatu = new JLabel("Gaji");
		lblInputSatu.setBounds(15, 27, 63, 14);
		panelInput.add(lblInputSatu);
		
		lblInputDua = new JLabel("Tanggungan Keluarga");
		lblInputDua.setBounds(15, 57, 125, 14);
		panelInput.add(lblInputDua);
		
		lblInputTiga = new JLabel("Tipe Pinjaman");
		lblInputTiga.setBounds(15, 87, 125, 14);
		panelInput.add(lblInputTiga);
		
		lblInputEmpat = new JLabel("Suku Bunga");
		lblInputEmpat.setBounds(15, 117, 125, 14);
		panelInput.add(lblInputEmpat);
		
		lblInputLima = new JLabel("EIR");
		lblInputLima.setBounds(15, 147, 125, 14);
		panelInput.add(lblInputLima);
		
		lblInputEnam= new JLabel("Hari Tunggakan");
		lblInputEnam.setBounds(15, 177, 125, 14);
		panelInput.add(lblInputEnam);
		
		lblInputTujuh = new JLabel("Lama Pinjaman");
		lblInputTujuh.setBounds(15, 207, 125, 14);
		panelInput.add(lblInputTujuh);
		
		lblInputDelapan = new JLabel("Tipe CKPN");
		lblInputDelapan.setBounds(15, 237, 125, 14);
		panelInput.add(lblInputDelapan);
		
		text_input1 = new JTextField();
		text_input1.setBounds(150, 22, 114, 25);
		panelInput.add(text_input1);
		text_input1.setColumns(10);
		
		text_input2 = new JTextField();
		text_input2.setColumns(10);
		text_input2.setBounds(150, 52, 114, 25);
		panelInput.add(text_input2);		
		
		text_input4 = new JTextField();
		text_input4.setColumns(10);
		text_input4.setBounds(150, 112, 114, 25);
		panelInput.add(text_input4);
		
		text_input5 = new JTextField();
		text_input5.setColumns(10);
		text_input5.setBounds(150, 142, 114, 25);
		panelInput.add(text_input5);
		
		text_input6 = new JTextField();
		text_input6.setColumns(10);
		text_input6.setBounds(150, 172, 114, 25);
		panelInput.add(text_input6);
		
		text_input7 = new JTextField();
		text_input7.setColumns(10);
		text_input7.setBounds(150, 202, 114, 25);
		panelInput.add(text_input7);	
		
			
		
		
		TipePinjaman = new JComboBox<String>();
		TipePinjaman.addItem("KMGRA");
		TipePinjaman.addItem("KSUPM");
		TipePinjaman.addItem("KUR01");
		TipePinjaman.addItem("KUR02");
		TipePinjaman.addItem("KUR15");
		TipePinjaman.addItem("MKONF");
		TipePinjaman.addItem("MLGMK");
		TipePinjaman.addItem("NPPPR");
		TipePinjaman.addItem("PKMKA");
		TipePinjaman.addItem("PMPKA");
		TipePinjaman.addItem("PMPKT");
		TipePinjaman.setBounds(150, 82, 114, 25);
		panelInput.add(TipePinjaman);
		
		TipeCKPN = new JComboBox<String>();
		TipeCKPN.addItem("C");
		TipeCKPN.addItem("I");		
		TipeCKPN.setBounds(150, 232, 114, 25);
		panelInput.add(TipeCKPN);
		
		
		
		btnProses = new JButton("PROSES");
		btnProses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					
					textArea_Result.setText("");
					if(counterdata < 1 ){
						Ambildata();
						MinMax();
						addArray();
					}else{
						MinMax();
						addArray();
					}
					
					
					
					
											
				}catch(Exception err){
					System.out.println(err.getMessage());
					JOptionPane.showMessageDialog(frameTesting, "Terjadi Kesalahan","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnProses.setBounds(50, 310, 95, 32);
		frameTesting.getContentPane().add(btnProses);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				F_Utama fm = new F_Utama();
				fm.frameMain.setVisible(true);
				frameTesting.dispose();
				
				
			}
		});
		btnBack.setBounds(155, 310, 95, 32);
		frameTesting.getContentPane().add(btnBack);
		
		textArea_Result = new JTextArea();
		textArea_Result.setBounds(10, 350, 280, 116);
		frameTesting.getContentPane().add(textArea_Result);
		
		setDefault();
		LoadHasilLearning load = new LoadHasilLearning();
        load.Loadv();
		load.Loadw();
		load.Loadv0();
		load.Loadw0();
	}
	
	static void test(double data[]){
        int jumlah_hidden = LoadHasilLearning.BobotV[0].length;
        int jumlah_output = LoadHasilLearning.Bobotw0.length;
       
        String Status;
        //pada hidden
       
        double z[] = new double[jumlah_hidden];
        for(int j=0; j<jumlah_hidden; j++){
            double z_in[] = new double[z.length];
            double tmp = 0;
            for(int i=0; i<data.length; i++){
                tmp = tmp + (data[i] * LoadHasilLearning.BobotV[i][j]);
            }
            z_in[j] = LoadHasilLearning.Bobotv0[j] + tmp;
            z[j] = 1/(1+(double)Math.exp(-z_in[j]));
        }
 
        //pada ouotpr
        double y[] = new double[jumlah_output];
        for(int k=0; k<jumlah_output; k++){
            double y_in[] = new double[y.length];
            double tmp = 0;
            for(int j=0; j<jumlah_hidden; j++){
                tmp = tmp + z[j] * LoadHasilLearning.BobotW[k][j];
            }
            y_in[k] = LoadHasilLearning.Bobotw0[k] + tmp;
 
            y[k] = 1/(1+(double)Math.exp(-y_in[k]));
 
            if(y[k]>0.5){
            	y[k]=1;
            	Status="Lancar";
            }             
             else{
             y[k]=0;
             Status="Macet";
             }
            //System.out.println("Output "+(double)y[k]);
            textArea_Result.setText(textArea_Result.getText()+"Hasil Prediksi Kredit"+(double)y[k]+" ("+Status+")");
        }
        
    }
	
	private void setDefault(){
		text_input1.setText("");
		text_input2.setText("");
		
		text_input4.setText("");
		text_input5.setText("");
		text_input6.setText("");
		text_input7.setText("");
		
	}
	public static String bacaFile(String namaFile) {
	    BufferedReader br = null;
	    String stringHasil = "";

	    try {
	    	
	        String sCurrentLine;
	        br = new BufferedReader(new FileReader(namaFile));
	        while ((sCurrentLine = br.readLine()) != null) {
	            stringHasil = stringHasil + sCurrentLine + "\n";
	        }

	    } catch (IOException e) {
	        System.out.println("Gagal membaca file " + namaFile);
	    } finally {
	        try {
	            if (br != null)
	                br.close();
	        } catch (IOException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }
	    return stringHasil;
	}
	public void Ambildata() {    	 
		fTesData = new float[1000][1000];
	    
	    String s = bacaFile("transformasi.csv");
	     
	    String[] has =s.split("\n");    

	    for(int i=0;i<has.length;i++){
	        String nilai[]=has[i].split(";");
	        jumkol=nilai.length;
	        for(int j=0;j<nilai.length;j++){
	            try{
	            	fTesData[i][j]=Float.valueOf(nilai[j]);
	            //
	            counterdata++;
	             
	            }catch(NumberFormatException e){
	                
	            }
	        }
	       
	    }
	}

private static float max(float[][] data,int j) {
    float max = 0;
    
    int jumdat=counterdata/jumkol;
    for(int i=0;i<jumdat;i++){
         
        if(data[i][j]>max){
            max=data[i][j];
             
        }
    }
   //System.out.println(max);
    return max;
}

private static float min(float[][] data,int j){
    float min=1000000;
            
           int jumdat=counterdata/jumkol;
           for(int i=0;i<jumdat;i++){
               if(min>data[i][j]){
               min=data[i][j];
               }
                
       }
        //System.out.println(min);   
       return min;
       
   }
	

	static void addArray(){
		
		ArrayList<Double> list = new ArrayList<Double>();					
		list.add(x1);
		list.add(x2);
		list.add(x3);
		list.add(x4);
		list.add(x5);
		list.add(x6);
		list.add(x7);
		list.add(x8);
		list.add(x9);
		list.add(x10);
		list.add(x11);
		list.add(x12);
		list.add(x13);
		list.add(x14);
		list.add(x15);
		list.add(x16);
		list.add(x17);
		list.add(x18);
		
		double[] inputx = new double[list.size()];
		for(int i = 0; i < inputx.length; i++){
			inputx[i] = list.get(i);
		}
		F_Testing.test(inputx);
	}

	static void MinMax(){			
		
		x1 = ((Double.parseDouble(text_input1.getText())-min(fTesData, 0))/(max(fTesData, 0)-min(fTesData, 0))*(1-0)) + 0;		

		x2 = ((Double.parseDouble(text_input2.getText())-min(fTesData, 1))/(max(fTesData, 1)-min(fTesData, 1))*(1-0)) + 0;	
		
		String txt3 = TipePinjaman.getSelectedItem().toString();
		if (txt3.equals("KMGRA")){
			x3=1;x4=0;x5=0;x6=0;x7=0;x8=0;x9=0;x10=0;x11=0;x12=0;x13=0;
		}else if (txt3.equals("KSUPM")){
			x3=0;x4=0;x5=0;x6=0;x7=0;x8=1;x9=0;x10=0;x11=0;x12=0;x13=0;
		}else if (txt3.equals("KUR01")){
			x3=0;x4=1;x5=0;x6=0;x7=0;x8=0;x9=0;x10=0;x11=0;x12=0;x13=0;
		}else if (txt3.equals("KUR02")){
			x3=0;x4=0;x5=0;x6=0;x7=0;x8=0;x9=1;x10=0;x11=0;x12=0;x13=0;			
		}else if (txt3.equals("KUR15")){
			x3=0;x4=0;x5=0;x6=0;x7=1;x8=0;x9=0;x10=0;x11=0;x12=0;x13=0;			
		}else if (txt3.equals("MKONF")){
			x3=0;x4=0;x5=1;x6=0;x7=0;x8=0;x9=0;x10=0;x11=0;x12=0;x13=0;			
		}else if (txt3.equals("MLGMK")){
			x3=0;x4=0;x5=0;x6=0;x7=0;x8=0;x9=0;x10=1;x11=0;x12=0;x13=0;			
		}else if (txt3.equals("NPPPR")){
			x3=0;x4=0;x5=0;x6=0;x7=0;x8=0;x9=0;x10=0;x11=1;x12=0;x13=0;			
		}else if (txt3.equals("PKMKA")){
			x3=0;x4=0;x5=0;x6=0;x7=0;x8=0;x9=0;x10=0;x11=0;x12=1;x13=0;			
		}else if (txt3.equals("PMPKA")){
			x3=0;x4=0;x5=0;x6=0;x7=0;x8=0;x9=0;x10=0;x11=0;x12=0;x13=1;			
		}else if (txt3.equals("PMPKT")){
			x3=0;x4=0;x5=0;x6=1;x7=0;x8=0;x9=0;x10=0;x11=0;x12=0;x13=0;	
		}
		x14 = ((Double.parseDouble(text_input4.getText())-min(fTesData, 13))/(max(fTesData, 13)-min(fTesData, 13))*(1-0)) + 0;
		x15 = ((Double.parseDouble(text_input5.getText())-min(fTesData, 14))/(max(fTesData, 14)-min(fTesData, 14))*(1-0)) + 0;
		x16 = ((Double.parseDouble(text_input6.getText())-min(fTesData, 15))/(max(fTesData, 15)-min(fTesData, 15))*(1-0)) + 0;
		x17 = ((Double.parseDouble(text_input7.getText())-min(fTesData, 16))/(max(fTesData, 16)-min(fTesData, 16))*(1-0)) + 0;
		
		String txt8 = TipeCKPN.getSelectedItem().toString();
		if (txt8.equals("C")){
			x18 = 1;
		}else if (txt8.equals("I")){
			x18 = 0;
		}		
		
	}
	
}
