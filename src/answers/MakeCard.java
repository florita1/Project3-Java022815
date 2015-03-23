package answers;

import java.awt.FlowLayout;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MakeCard {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		JFrame test = new JFrame("Card Test" );
		test.setLayout(new FlowLayout());
		// Convert from Unicode to UTF-8
	    String string1 = "\uD83C\uDCA1";
	    byte[] utf8 = string1.getBytes("UTF-8");

	    // Convert from UTF-8 to Unicode
	    String string2 = null;
	    string2 = new String(utf8, "UTF-8");
	    
	    JLabel card = new JLabel(string2);
	    card.setSize(10,20);
	    
	    test.add(card);

	    test.setBounds(400, 100, 200, 200);
		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		test.setVisible(true);
	}

}
