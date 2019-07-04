package backpropagation;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DisplayImage {
	
	 public DisplayImage() {  
		JFrame frame = new JFrame("test.JPEG");  
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	
		JPanel panel = (JPanel)frame.getContentPane();  
		       JLabel label = new JLabel();  
		              System.out.println(new File("test.JPEG"));  
		              System.out.println(new File("test.JPEG").exists());
		       label.setIcon(new ImageIcon("test.JPEG"));// your image here  
		        panel.add(label);  
	 
		       frame.setLocationRelativeTo(null);  
	        frame.pack();  
		        frame.setVisible(true);  
		     }  
	  
		    public static void main (String args[]) {  
		        SwingUtilities.invokeLater(new Runnable() {  
	             public void run() {  
		                new DisplayImage();  
	             }  
		       });  
	    }  

}
