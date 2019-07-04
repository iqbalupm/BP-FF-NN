package backpropagation;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class F_Training {
	String dateStart;
	String dateStop;
	double E;
	long diff ;    	 
	  long diffSeconds;
	  long diffMinutes;
	  long diffHours ;   	
	  
	public JFrame frameTraining;
	private JTextField text_learnRate,text_max,text_targeterr,text_hidenlayer;
	private JLabel lblLarningRate,lblMaxEpoh,lblTargetError,lblJumlahHiddenLayer;
	private JTextArea textArea_Result;
	public static JTextField txtPath;
	private double LRate,targetErr;
	private int MaxEpoh;
	public static int HidenLayer;
	private JButton btnTrain,btnBack,btnBrowse;
	
	double x[][];
    // target
    double t[];
    
    public static int unit_input;
    public static int unit_hidden;
    public static int unit_output;
    
 // learning rate
    double alfa;
    // maximum loop
    int maxloop;
    // target error
    double ERR;
    // last error
    double ERX;
    
    // bobot input - hidden
    public static double v[][];
    // bobot bias - hidden 
    public static double v0[];
    // bobot hidden - ouput
    public static double w[][];
    // bobot bias - output
    public static double w0[];
    
    int loop = 0;
	
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_Training window = new F_Training();
					window.frameTraining.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public F_Training() {
		initialize();
	}
	private void initialize() {
	frameTraining = new JFrame();
	frameTraining.setTitle("Training");
	frameTraining.setResizable(false);
	frameTraining.setBounds(100, 100, 439, 375);
	frameTraining.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frameTraining.getContentPane().setLayout(null);
	
	
	
	txtPath = new JTextField();
    txtPath.setBounds(10, 10, 300, 21);
    frameTraining.getContentPane().add(txtPath);
    txtPath.setColumns(10);
         
    btnBrowse = new JButton("Load");
    btnBrowse.setBounds(330, 10, 70, 23);
    frameTraining.getContentPane().add(btnBrowse);
    
    btnBrowse.addActionListener(new ActionListener() {
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
	
	JPanel panelParameter = new JPanel();
	panelParameter.setBorder(new TitledBorder(null, "Parameter", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	panelParameter.setBounds(10, 40, 263, 134);
	frameTraining.getContentPane().add(panelParameter);
	panelParameter.setLayout(null);
	
	lblLarningRate = new JLabel("Larning Rate");
	lblLarningRate.setBounds(10, 22, 92, 14);
	panelParameter.add(lblLarningRate);
	
	lblMaxEpoh = new JLabel("Max Epoh");
	lblMaxEpoh.setBounds(10, 44, 92, 14);
	panelParameter.add(lblMaxEpoh);
	
	lblTargetError = new JLabel("Target Error");
	lblTargetError.setBounds(10, 66, 92, 14);
	panelParameter.add(lblTargetError);
	
	
	text_learnRate = new JTextField();
	text_learnRate.setBounds(130, 19, 113, 20);
	panelParameter.add(text_learnRate);
	text_learnRate.setColumns(10);
	
	text_max = new JTextField();
	text_max.setColumns(10);
	text_max.setBounds(130, 41, 113, 20);
	panelParameter.add(text_max);
	
	text_targeterr = new JTextField();
	text_targeterr.setColumns(10);
	text_targeterr.setBounds(130, 63, 113, 20);
	panelParameter.add(text_targeterr);
	
	text_hidenlayer = new JTextField();
	text_hidenlayer.setColumns(10);
	text_hidenlayer.setBounds(130, 85, 30, 20);
	panelParameter.add(text_hidenlayer);
	
	lblJumlahHiddenLayer = new JLabel("Jumlah Hiden Layer");
	lblJumlahHiddenLayer.setBounds(10, 88, 110, 14);
	panelParameter.add(lblJumlahHiddenLayer);
	
		
	btnTrain = new JButton("TRAINING");
	btnTrain.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {		 
			
			try{
				textArea_Result.setText("");
				LRate = Double.parseDouble(text_learnRate.getText());
				MaxEpoh = Integer.parseInt(text_max.getText());
				HidenLayer = Integer.parseInt(text_hidenlayer.getText());
				targetErr = Double.parseDouble(text_targeterr.getText());
				
				waktumulai();
				ambildata();	
				LoadBobot Lbobot = new LoadBobot();
		        Lbobot.Loadv();
				Lbobot.Loadw();
				Lbobot.Loadv0();
				Lbobot.Loadw0();
				
				init_static();
				learn_static();		
		       
		       		       
			}catch(Exception err){
				
				JOptionPane.showMessageDialog(frameTraining, "Terjadi Kesalahan","ERROR",JOptionPane.ERROR_MESSAGE);
				
			}
		}
	});
	
	btnTrain.setBounds(283, 50, 123, 47);
	frameTraining.getContentPane().add(btnTrain);
	
	textArea_Result = new JTextArea();
	textArea_Result.setBounds(10, 185, 405, 136);
	frameTraining.getContentPane().add(textArea_Result);
	
	
	
	btnBack = new JButton("BACK");
	btnBack.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			F_Utama fm = new F_Utama();
			fm.frameMain.setVisible(true);
			frameTraining.dispose();
		}
	});
	btnBack.setBounds(283, 115, 123, 47);
	frameTraining.getContentPane().add(btnBack);
	setDefault();
	
	JScrollPane scrollPane = new JScrollPane(textArea_Result,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	scrollPane.setBounds(10, 190,  405, 136);		
	frameTraining.getContentPane().add(scrollPane);
	}
	
	public void ambildata(){
		
		LoadDataInput load = new LoadDataInput();
        load.csv();
		
	}	

	void init_static(){
        double init_x[][] = LoadDataInput.TesData;
        double init_t[] = LoadDataInput.ty;
        
        int init_uinput = init_x[0].length;
        int init_uhidden = HidenLayer;
        int init_uoutput = 1;
        int init_maxloop = MaxEpoh;
        
        double init_alfa = LRate;        
        double init_ERR = targetErr;           
        double init_v[][] = LoadBobot.BobotV;
        double init_v0[] = LoadBobot.Bobotv0;
        double init_w[][] = LoadBobot.BobotW;
        double init_w0[] = LoadBobot.Bobotw0;      
        this.x = init_x;
        this.t = init_t;
        F_Training.unit_input = init_uinput;
        F_Training.unit_hidden = init_uhidden;
        F_Training.unit_output = init_uoutput;
        this.alfa = init_alfa;
        this.maxloop = init_maxloop;
        this.ERR = init_ERR;
        F_Training.v = init_v;
        F_Training.v0 = init_v0;
        F_Training.w = init_w;
        F_Training.w0 = init_w0;
    }
    
    void learn_static(){
    	
        double data[][] = this.x;       
        int jumlah_data = data.length;
        int jumlah_input = F_Training.unit_input;
        int jumlah_hidden = F_Training.unit_hidden;
        int jumlah_output = F_Training.unit_output;
        
        
        this.maxloop = MaxEpoh;
        
        do{          
            for(int h=0; h<jumlah_data; h++){
                // hitung z_in dan z
                double z[] = new double[data.length];
                for(int j=0; j<jumlah_hidden; j++){
                    //itung sigma xi vij
                    double z_in[] = new double[z.length];
                    double jum_xv=0;
                    for(int i=0; i<jumlah_input; i++){
                        double tmp=x[h][i]*v[i][j];
                        jum_xv=jum_xv+tmp;
                        
                    }
     //Langkah 4
                    z_in[j] = v0[j]+jum_xv;
                  //System.out.println(z_in[j]);
     //Langkah 5
                    z[j] = 1/(1+(double)Math.exp(-z_in[j]));                    
                    //System.out.println(z[j]);
                    
                }
                
                //~ itung y_in dan y     (output)
                double y[] = new double[jumlah_output];
                for(int k=0; k<jumlah_output; k++){
                    double y_in[] = new double[y.length];
                    double jum_zw=0;
                    for(int j=0; j<jumlah_hidden; j++){
                        double tmp=z[j]*w[k][j];
                        jum_zw=jum_zw+tmp;
                    }
                    y_in[k]=w0[k]+jum_zw;
                    //System.out.println(y_in[k]);
                    y[k]=1/(1+(double)Math.exp(-y_in[k]));
                    //System.out.println(y[k]);
                }
                
                //ngitung error output dan delta bias dan delta bobot
                double Err_y[] = new double[jumlah_output]; 
                double Aw[][] = new double[F_Training.w.length][F_Training.w[0].length];
                double Aw0[] = new double[F_Training.w0.length];
                for(int k=0; k<jumlah_output; k++){
                    //error otput
       //Langkah 6
                    Err_y[k]=(t[h]-y[k])*y[k]*(1-y[k]);
                    //System.out.println(Err_y[k]);
                    
                    for(int j=0; j<jumlah_hidden; j++){
                        //delta bobot hO
                        Aw[k][j] = alfa*Err_y[k]*z[j];
                        //System.out.println(Aw[k][j]);
                        //delta bias hO
                        Aw0[k] = alfa*Err_y[k];
                        //System.out.println(Aw0[k]);
                    }
                }
                
                //ngitung error hiden dan delta bias dan delta bobot
                double Err_in[] = new double[jumlah_hidden]; 
                double Err_z[] = new double[jumlah_hidden];
                double Av[][] = new double[F_Training.v.length][F_Training.v[0].length];
                double Av0[] = new double[F_Training.v0.length];
                for(int j=0; j<jumlah_hidden; j++){
                    double tmp=0;
                    for(int k=0; k<jumlah_output; k++){
                        tmp = tmp + (Err_y[k]*F_Training.w[k][j]);
                    }
        //Langkah 7
                    // eror sebelum output / setelah hidden
                    Err_in[j]=tmp;
                    //System.out.println(Err_in[j]);
                    // eror hidden (t[h]-y[k])*y[k]*(1-y[k]);
                    Err_z[j]=Err_in[j]*(z[j])*(1-z[j]);
                    //System.out.println(Err_z[j]);
 
                    for(int i=0; i<jumlah_input; i++){
                        //delta bobot iH
                        Av[i][j]=this.alfa*Err_z[j]*this.x[h][i];
                        //System.out.println(Av[i][j]);
                    }
                    
                    //delta bias  hidden
                    Av0[j]=this.alfa*Err_z[j];
                    //System.out.println(Av0[j]);
                }
      //Langkah 8
                //update bobot dan bias
                //update bobot bias outpuut
                for(int j=0; j<jumlah_hidden; j++){
                    for(int k=0; k<jumlah_output; k++){
                        F_Training.w[k][j]=F_Training.w[k][j]+Aw[k][j];
                        //System.out.println(w[0][2]);
                    }
                }
                for(int k=0; k<jumlah_output; k++){
                    F_Training.w0[k]=F_Training.w0[k]+Aw0[k];
                    //System.out.println(w0[k]);
                }
 
                //update bobot bias hidden
                for(int i=0; i<jumlah_input; i++){
                    for(int j=0; j<jumlah_hidden; j++){
                        F_Training.v[i][j]=F_Training.v[i][j]+Av[i][j];
                        //System.out.println(v[i][j]);
                    }
                }
                for(int j=0; j<jumlah_hidden; j++){
                    F_Training.v0[j]=F_Training.v0[j]+Av0[j];
                }
            }
            
            loop++;
           // textArea_Result.append("Epoh Ke : "+loop+"\n"+"err : "+ERX+"\n");
        }while(is_stop()>this.ERR && loop<this.maxloop);
        SaveBobot bobot = new SaveBobot();
        bobot.savev();
        bobot.savev0();
        bobot.savew();
        bobot.savew0();
        waktuberhenti();
        waktutraining();
       
        textArea_Result.append("Lama Training : " + diffHours+":"+diffMinutes+":"+diffSeconds);
        loop=0;
    }
    
    //penentuan berhenti atau lanjut
    double is_stop(){
        int jumlah_input = F_Training.unit_input;
        int jumlah_hidden = F_Training.unit_hidden;
        int jumlah_output = F_Training.unit_output;
        int jumlah_data = this.x.length;
        double akumY=0;
        
        //~ itung z_in dan z
        for(int h=0; h<jumlah_data; h++){
            double z[] = new double[jumlah_hidden];
            for(int j=0; j<jumlah_hidden; j++){
                //itung sigma xi vij
                double z_in[] = new double[z.length];
                double jum_xv=0;
                for(int i=0; i<jumlah_input; i++){
                    double tmp=this.x[h][i]*F_Training.v[i][j];
                    jum_xv=jum_xv+tmp;
                }
                z_in[j]=F_Training.v0[j]+jum_xv;
                z[j]=1/(1+(double)Math.exp(-z_in[j]));
                //System.out.println(z[j]);
            }
 
            //~ itung y_in dan y (output)
            double y[] = new double[jumlah_output];
            for(int k=0; k<jumlah_output; k++){
                double y_in[] = new double[y.length];
                double jum_zw=0;
                for(int j=0; j<jumlah_hidden; j++){
                    double tmp=z[j]*F_Training.w[k][j];
                    jum_zw=jum_zw+tmp;
                }
                y_in[k]=F_Training.w0[k]+jum_zw;
                y[k]=1/(1+(double)Math.exp(-y_in[k]));
                
                //akumY += Math.pow((t[h]-y[k]),2);
                akumY += Math.pow((y[k]-t[h]),2);
                 
            }
        }
        
         E = akumY/this.x[0].length;
       
        ERX = E;
        textArea_Result.append("Epoh Ke : "+loop+"\n"+"err : "+ERX+"\n");
        return E;
    }
        
    double double_format(double num, int len){
        String format = "#.";
        for(int a=0; a<len; a++){
            format += "#";
        }
        DecimalFormat change = new DecimalFormat(format);
        return Double.valueOf(change.format(num));
    }   
    
    
    private void setDefault(){
    	txtPath.setText("");
		text_learnRate.setText("0.2");
		text_max.setText("1");
		text_targeterr.setText("1");
		text_hidenlayer.setText("4");
	}
    public void waktumulai(){    	
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");              
            Date date = new Date();  
            dateStart = dateFormat.format(date);          
          
    }  
    public void waktuberhenti(){    	
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");              
        Date date = new Date();  
        dateStop = dateFormat.format(date);          
      
    }  
    public void waktutraining(){    	
    	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
    	 
    	Date d1 = null;
    	Date d2 = null;
    	 
    	try {
    	  d1 = format.parse(dateStart);
    	  d2 = format.parse(dateStop);
    	
    	  diff = d2.getTime() - d1.getTime();    	 
    	  diffSeconds = diff / 1000 % 60;
    	  diffMinutes = diff / (60 * 1000) % 60;
    	  diffHours = diff / (60 * 60 * 1000) % 24;   	  
    	 
    	 
    	} catch (Exception e) {
    	   e.printStackTrace();
    	}       
      
    }  
    
}
