package answers;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BuildFrame {
	private JButton yButton = null;
	private JButton nButton = null;
	private JLabel myLabel = null;
	private JFrame f;
	private JPanel c;
	private JPanel g;
	private JPanel p;
	private JTextField name;
	private ButtonGroup playerButtons;

	public static void main(String[] a) {
		BuildFrame bf = new BuildFrame();
		bf.createFrame();
	}

	public void createFrame() {
		f = new JFrame("Poker Game");
		f.setLayout(new GridLayout(4, 1));
		c = new JPanel();

		yButton = new JButton("Yes");
		nButton = new JButton("No");
		yButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getName();
			}
		});
		nButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
			}
		});

		myLabel = new JLabel("Would you like to play?", SwingConstants.CENTER);
		c.add(myLabel);
		c.add(yButton);
		c.add(nButton);
		// .pack() is always necessary
		f.add(c);
		f.pack();
		f.setBounds(400, 200, 500, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public void getName() {
		f.remove(c);

		g = new JPanel();
		JLabel getname = new JLabel("What is your players name? ");
		name = new JTextField(10);
		final JButton submit = new JButton("Submit");

		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPlayers();
				submit.setEnabled(false);
			}
		});

		g.add(getname);
		g.add(name);
		g.add(submit);

		f.add(g);
		f.setVisible(true);
	}

	public void getPlayers() {
		p = new JPanel();
		JLabel getplayers = new JLabel(
				"How many players should we deal cards for? ");
		playerButtons = new ButtonGroup();
		JRadioButton players2 = new JRadioButton("2", true);
		players2.setActionCommand(players2.getText());
		JRadioButton players3 = new JRadioButton("3");
		players3.setActionCommand(players3.getText());
		JRadioButton players4 = new JRadioButton("4");
		players4.setActionCommand(players4.getText());
		JRadioButton players5 = new JRadioButton("5");
		players5.setActionCommand(players5.getText());
		playerButtons.add(players2);
		playerButtons.add(players3);
		playerButtons.add(players4);
		playerButtons.add(players5);
		p.add(getplayers);
		p.add(players2);
		p.add(players3);
		p.add(players4);
		p.add(players5);

		JPanel playPanel = new JPanel();
		JButton play = new JButton("Deal");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitInfo();
			}
		});
		playPanel.add(play);

		f.add(p);
		f.add(playPanel);
		f.setVisible(true);

	}

	public void submitInfo() {
		String n = playerButtons.getSelection().getActionCommand();
		new PlayGame(Integer.parseInt(n), name.getText());
	}

}
