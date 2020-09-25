package Img;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class buttonsListener implements ActionListener {

	private JLabel labelWithImg;

	public buttonsListener(JLabel labelWithImg) {

		this.labelWithImg = labelWithImg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		change();

		System.out.println("Mini!");

	}

	
	// i denna metod lägger vi in bilden samt ändrar skala med "getScaledInstance" och skickar sedan vidare metoden till våran Actionperformed.
	
	public void change() {

		ImageIcon picture = new ImageIcon("Pic.jpg");
		Image newpicture = picture.getImage();
		Image modifiednewpicture = newpicture.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
		picture = new ImageIcon(modifiednewpicture);

		labelWithImg.setIcon(new ImageIcon(modifiednewpicture));

	}

}
