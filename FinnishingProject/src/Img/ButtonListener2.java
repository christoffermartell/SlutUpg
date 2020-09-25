package Img;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonListener2 implements ActionListener {
	BufferedImage image;

	private JLabel labelWithImg;

	public ButtonListener2(JLabel labelWithImg) {

		this.labelWithImg = labelWithImg;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		try {
			Colour();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.println("Colour!");
	}

	// i denna metod så lägger vi först till bilden och sedan "hämtar vi datan för
	// all pixlar".
	// sedan skaparbyter vi pixlarna från orginal till våra egna värden och sparar
	// om bilden.

	public void Colour() throws IOException {

		File file = new File("Pic.jpg");
		BufferedImage img = ImageIO.read(file);
		for (int y = 0; y < img.getHeight(); y++) {
			for (int x = 0; x < img.getWidth(); x++) {

				int pixel = img.getRGB(x, y);

				Color color = new Color(pixel, true);

				int red = color.getRed();
				int green = color.getGreen();
				int blue = color.getBlue();

				green = 100;
				blue = 10;

				color = new Color(red, green, blue);

				img.setRGB(x, y, color.getRGB());
			}
		}
		// sparar nya bilden
		file = new File("colouredPic.jpg");
		ImageIO.write(img, "jpg", file);

		ImageIcon picture = new ImageIcon("colouredPic.jpg");
		Image newpicture = picture.getImage();
		labelWithImg.setIcon(new ImageIcon(newpicture));


	}
}
