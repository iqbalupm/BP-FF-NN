package backpropagation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class F_Normalisasi {
	
	public JFrame frameNormalisasi;
	private JButton btnProses,btnBack,btnLoad,btnSave;
	public static JTextField txtPath,txtdestination;	
	public static int jumkol;
    public static int counterdata;
    public static float fTesData[][];   	
   	private static JTable table ;
   	
	public static void main(String[] args) {		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_Normalisasi window = new F_Normalisasi();
					window.frameNormalisasi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public F_Normalisasi() {
		initialize();
	}
	
	private void initialize() {
		frameNormalisasi = new JFrame();
		frameNormalisasi.setTitle("Normalisasi");
		frameNormalisasi.setResizable(false);
		frameNormalisasi.setBounds(100, 100, 1000, 500);
		frameNormalisasi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameNormalisasi.getContentPane().setLayout(null);
		
		txtPath = new JTextField();
	    txtPath.setBounds(50, 40, 390, 21);
	    frameNormalisasi.getContentPane().add(txtPath);
	    txtPath.setColumns(10);
	    
	    txtdestination = new JTextField();
	    txtdestination.setBounds(50, 70, 390, 21);
	    frameNormalisasi.getContentPane().add(txtdestination);
	    txtdestination.setColumns(10);
	         
	    btnLoad = new JButton("Load");
	    btnLoad.setBounds(470, 40, 80, 23);
	    frameNormalisasi.getContentPane().add(btnLoad);
	    
	    btnSave = new JButton("Save");
	    btnSave.setBounds(470, 70, 80, 23);
	    frameNormalisasi.getContentPane().add(btnSave);
	    
	    table = new JTable();
	   table.setBounds(160, 130, 680, 116);
		frameNormalisasi.getContentPane().add(table);
	    
	    btnLoad.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          JFileChooser fileChooser = new JFileChooser();	         
	          fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);	   
	          fileChooser.setAcceptAllFileFilterUsed(false);	   
	          int rVal = fileChooser.showOpenDialog(null);
	          if (rVal == JFileChooser.APPROVE_OPTION) {
	            txtPath.setText(fileChooser.getSelectedFile().toString());
	          }
	        }
	      });
	    
	    btnSave.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          JFileChooser fileChooser = new JFileChooser();
	          fileChooser.setCurrentDirectory(new java.io.File("."));	          
	          fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);	   
	          fileChooser.setAcceptAllFileFilterUsed(false);	   
	          int rVal = fileChooser.showOpenDialog(null);
	          if (rVal == JFileChooser.APPROVE_OPTION) {
	        	  txtdestination.setText(fileChooser.getSelectedFile().toString());
	          }
	        }
	      });
		
		btnProses = new JButton("PROSES");
		btnProses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
				TransformasiData loaddata = new TransformasiData();
				loaddata.convert();
				datanormalisasi();
				minMax(fTesData);
				JOptionPane.showMessageDialog(frameNormalisasi, "Normalisasi Selesai","SUKSES",JOptionPane.INFORMATION_MESSAGE);
				hasiltabel();
				}catch(Exception err){
					System.out.println(err.getMessage());
					JOptionPane.showMessageDialog(frameNormalisasi, "Terjadi Kesalahan","ERROR",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnProses.setBounds(160, 400, 113, 40);
		frameNormalisasi.getContentPane().add(btnProses);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				F_Utama ft = new F_Utama();
				ft.frameMain.setVisible(true);
				frameNormalisasi.dispose();
			}
		});
		btnBack.setBounds(320, 400, 113, 40);
		frameNormalisasi.getContentPane().add(btnBack);	
		
		JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(50, 100, 900, 280);		
		frameNormalisasi.getContentPane().add(scrollPane);	
	}
	
public void datanormalisasi() {    	 
	fTesData = new float[2000][2000];    
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

public static void tulisFile(String teks, String namaFile) {
    try {
        PrintWriter out = new PrintWriter(new BufferedWriter(
                new FileWriter(namaFile, true)));
        out.println(teks.toString());
        out.close();
    } catch (IOException e) {
        System.out.println("Gagal menulis ke file " + namaFile);
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
public static void minMax(float[][] data){
    float[][] newdata=new float[2000][2000];
    String s,view;
    int j,i,jumdat=counterdata/jumkol;
    
    int newmax= 1;
    int newmin= 0;
    for(j=0;j<jumkol;j++){
    float max=max(data,j);
    float min=min(data,j);
    for(i=0;i<jumdat;i++){
         
        newdata[i][j] = ((data[i][j]-min)*(newmax-newmin))/((max-min)+newmin);
        //newdata[i][j] = (int)(newdata[i][j]*100);
    }
  
  }
    DecimalFormat df = new DecimalFormat("#.##");
    for(j=0;j<jumdat;j++){
        s=""+newdata[j][0]+";"+newdata[j][1]+";"+newdata[j][2]+";"+newdata[j][3]+";"+newdata[j][4]+";"+newdata[j][5]+";"+newdata[j][6]+";"+newdata[j][7]+";"+newdata[j][8]+";"+newdata[j][9]+";"+newdata[j][10]+";"+newdata[j][11]+";"+newdata[j][12]+";"+newdata[j][13]+";"+newdata[j][14]+";"+newdata[j][15]+";"+newdata[j][16]+";"+newdata[j][17]+";"+data[j][jumkol-1];
        view=""+df.format(newdata[j][0])+"\t"+df.format(newdata[j][1])+"\t"+df.format(newdata[j][2])+"\t"+df.format(newdata[j][3])+"\t"+df.format(newdata[j][4])+"\t"+df.format(newdata[j][5])+"\t"+df.format(newdata[j][6])+"\t"+df.format(newdata[j][7])+"\t"+df.format(newdata[j][8])+"\t"+df.format(newdata[j][9])+"\t"+df.format(newdata[j][10])+"\t"+df.format(newdata[j][11])+"\t"+df.format(newdata[j][12])+"\t"+df.format(newdata[j][13])+"\t"+df.format(newdata[j][14])+"\t"+df.format(newdata[j][15])+"\t"+df.format(newdata[j][16])+"\t"+df.format(newdata[j][17])+"\t"+data[j][jumkol-1]+"\n";
        tulisFile(s,txtdestination.getText());
        //textArea_Result.setText(textArea_Result.getText()+view);
           //System.out.println(s);
    }
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
public void hasiltabel(){
	
	try {

		
        //BufferedReader br = new BufferedReader(new FileReader(new File("D:\\2019\\rrrrr.csv")));
		BufferedReader br = new BufferedReader(new FileReader(txtdestination.getText().toString()));
        List<String[]> elements = new ArrayList<String[]>();
        String line = null;
        while((line = br.readLine())!=null) {
            String[] splitted = line.split(";");
            elements.add(splitted);
        }
        br.close();

       
        String[] columNames = new String[] {
                "Gaji", "TanggKel", "KMGRA", "KUR01" ,
                "MKONF", "PMPKT", "KUR15", "KSUPM",
                "KUR02", "MLGMK", "NPPPR", "PKMKA",
                "PMPKA", "SukuBunga", "EIR", "HariTunggakan",
                "LamaPinj", "TypeCKPN", "Status"
                
            };

        Object[][] content = new Object[elements.size()][19];

        for(int i=0; i<elements.size(); i++) {
            content[i][0] = elements.get(i)[0];
            content[i][1] = elements.get(i)[1];
            content[i][2] = elements.get(i)[2];
            content[i][3] = elements.get(i)[3];
            content[i][4] = elements.get(i)[4];
            content[i][5] = elements.get(i)[5];
            content[i][6] = elements.get(i)[6];
            content[i][7] = elements.get(i)[7];
            content[i][8] = elements.get(i)[8];
            content[i][9] = elements.get(i)[9];
            content[i][10] = elements.get(i)[10];
            content[i][11] = elements.get(i)[11];
            content[i][12] = elements.get(i)[12];
            content[i][13] = elements.get(i)[13];
            content[i][14] = elements.get(i)[14];
            content[i][15] = elements.get(i)[15];
            content[i][16] = elements.get(i)[16];
            content[i][17] = elements.get(i)[17];
            content[i][18] = elements.get(i)[18];
            
            
        }

        table.setModel(new DefaultTableModel(content,columNames));

        System.out.println(table.getModel().getValueAt(1, 1));

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}
	
}
