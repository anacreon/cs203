package edu.calstatela.cs.cs203.threads;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class FlashText extends JFrame implements Runnable {
	private JLabel jlblText = new JLabel("Welcome", JLabel.CENTER);

	public FlashText() {
		this.add(jlblText);
		new Thread(this).start();
	}

	public void run() {
		try {
			while (true) {
				if (jlblText.getText() == null)
					jlblText.setText("Welcome");
				else
					jlblText.setText(null);

				Thread.sleep(200);
			}
		}
		catch (InterruptedException ex) {
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FlashText jFrame = new FlashText();
				jFrame.setSize(200, 150);
				jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jFrame.setVisible(true);
			}
		});
	}
}

