package backpropagation;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class F_TestingMasal {
	
	public JFrame frameTestingMasal;
	//String[] kolom = {"x1","x2","x3","x4","x5","x6","x7","x8"};
	private JButton btnProses,btnBack,btnBrowse;
	public static JTextField txtPath;	
	public static double y[];
	public static int k;	
	private static JTextArea textArea_Result;
public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_TestingMasal window = new F_TestingMasal();
					window.frameTestingMasal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public F_TestingMasal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameTestingMasal = new JFrame();
		frameTestingMasal.setTitle("Backpropagation");
		frameTestingMasal.setResizable(false);
		frameTestingMasal.setBounds(100, 100, 600, 500);
		frameTestingMasal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTestingMasal.getContentPane().setLayout(null);
		
		txtPath = new JTextField();
	    txtPath.setBounds(50, 40, 390, 21);
	    frameTestingMasal.getContentPane().add(txtPath);
	    txtPath.setColumns(10);
	         
	    btnBrowse = new JButton("Load");
	    btnBrowse.setBounds(470, 40, 80, 23);
	    frameTestingMasal.getContentPane().add(btnBrowse);
	    
	    textArea_Result = new JTextArea();
		textArea_Result.setBounds(160, 130, 280, 116);
		frameTestingMasal.getContentPane().add(textArea_Result);
	    
		
	    btnBrowse.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          JFileChooser fileChooser = new JFileChooser();	   
	          // For Directory
	          fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	   
	          // For File
	          //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	   
	          fileChooser.setAcceptAllFileFilterUsed(false);
	   
	          int rVal = fileChooser.showOpenDialog(null);
	          if (rVal == JFileChooser.APPROVE_OPTION) {
	            txtPath.setText(fileChooser.getSelectedFile().toString());
	          }
	        }
	      });
		
		btnProses = new JButton("PROSES");
		btnProses.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LoadDataTesting load = new LoadDataTesting();
		        load.dataTest();
		        LoadHasilLearning loadbobot = new LoadHasilLearning();
		        loadbobot.Loadv();
				loadbobot.Loadw();
				loadbobot.Loadv0();
				loadbobot.Loadw0();
				F_TestingMasal.test(LoadDataTesting.TesData);
				
			}
		});
		btnProses.setBounds(160, 400, 113, 40);
		frameTestingMasal.getContentPane().add(btnProses);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				F_Utama ft = new F_Utama();
				ft.frameMain.setVisible(true);
				frameTestingMasal.dispose();
			}
		});
		btnBack.setBounds(320, 400, 113, 40);
		frameTestingMasal.getContentPane().add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane(textArea_Result,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(50, 70, 500, 300);
		frameTestingMasal.getContentPane().add(scrollPane);		
		
	}
	
	static void test(double data[][]){
        int jumlah_hidden = LoadHasilLearning.BobotV[0].length;
        int jumlah_output = LoadHasilLearning.Bobotw0.length;
        int jumlah_data = data.length;
        
        String Status;
        //pada hidden
        
        for(int h=0; h<jumlah_data; h++){
        double z[] = new double[jumlah_hidden];
        for(int j=0; j<jumlah_hidden; j++){
            double z_in[] = new double[z.length];
            double tmp = 0;
            for(int i=0; i<data[0].length; i++){
                tmp = tmp + (data[h][i] * LoadHasilLearning.BobotV[i][j]);
            }
            z_in[j] = LoadHasilLearning.Bobotv0[j] + tmp;
            z[j] = 1/(1+(double)Math.exp(-z_in[j]));
        }
       
        y = new double[jumlah_output];
        for(k=0; k<jumlah_output; k++){
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
            
           int no;
           int s = textArea_Result.getLineCount();
           String nomordata = null;
           for(no=0;no<s;no++){
        	   nomordata = String.valueOf(no+1);
           }
               
            textArea_Result.setText
            (textArea_Result.getText()+"Hasil Testing Data Ke "+nomordata+" : "+(double)y[k]+" ("+Status+")"+"\n");
            //textArea_Result.setText
            //(textArea_Result.getText()+" "+y[k]+"\n");
           
      }         
    }          
  }
}
