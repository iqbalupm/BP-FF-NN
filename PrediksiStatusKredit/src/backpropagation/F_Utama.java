package backpropagation;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

@SuppressWarnings("unused")
public class F_Utama {

	public JFrame frameMain;

	public static void main(String[] args) throws IOException {
		
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					F_Utama window = new F_Utama();
					window.frameMain.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public F_Utama() {
		initialize();
	}

	private void initialize() {
		
		frameMain = new JFrame();
		frameMain.setTitle("Backpropagation");		
		frameMain.setResizable(false);
		frameMain.setBounds(100, 100, 500, 300);
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menubar = new JMenuBar();
		JMenu training = new JMenu("Training");
		JMenu testing = new JMenu("Testing");
		JMenu normalisasi = new JMenu("Normalisasi");
		JMenu GBobot = new JMenu("Generate Bobot");
		
		JMenuItem train = new JMenuItem("Training");
		JMenuItem test = new JMenuItem("Testing");
		JMenuItem testmasal = new JMenuItem("Testing Data Masal");
		JMenuItem norminmax = new JMenuItem("Min-Max");
		JMenuItem GenerateBobot = new JMenuItem("Generate Bobot (Random)");
		
		training.add(train);	
		testing.add(test);
		testing.add(testmasal);
		normalisasi.add(norminmax);
		GBobot.add(GenerateBobot);
		
		menubar.add(training);
		menubar.add(testing);
		menubar.add(normalisasi);
		menubar.add(GBobot);
		frameMain.setJMenuBar(menubar);

		train.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				F_Training ft = new F_Training();
				ft.frameTraining.setVisible(true);
				frameMain.dispose();
			}
		});
		
		test.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				F_Testing ft = new F_Testing();
				ft.frameTesting.setVisible(true);
				frameMain.dispose();
			}
		});
		
		testmasal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				F_TestingMasal ftm = new F_TestingMasal();
				ftm.frameTestingMasal.setVisible(true);
				frameMain.dispose();
			}
		});
		
		norminmax.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				F_Normalisasi ftm = new F_Normalisasi();
				ftm.frameNormalisasi.setVisible(true);
				frameMain.dispose();
			}
		});
		
		GenerateBobot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BobotRandom ftm = new BobotRandom();
				ftm.frameBRandom.setVisible(true);
				frameMain.dispose();
			}
		});
		
		JPanel panelParameter = new JPanel();
		panelParameter.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParameter.setBounds(10, 40, 263, 90);
		frameMain.getContentPane().add(panelParameter);
		panelParameter.setLayout(null);
		
		JLabel lbl_input = new JLabel();
		lbl_input.setIcon(new ImageIcon("test.JPEG"));
		panelParameter.add(lbl_input);
	}
}
