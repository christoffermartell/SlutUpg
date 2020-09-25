package Img;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadImageApp extends Component {

	BufferedImage image;

	// testar bilden så den finns

	public LoadImageApp() {

		try {
			image = ImageIO.read(new File("Pic.jpg"));

		} catch (IOException ex) {
		}
	}

	// använder paint för att måla upp grafiken

	public void paint(Graphics g) {

		g.drawImage(image, 0, 0, null);
	}

	// bildens storlek
	public Dimension getPrefferredSize() {

		if (image == null) {
			return new Dimension(100, 100);
		} else {
			return new Dimension(image.getWidth(null), image.getHeight(null));
		}

	}

	public BufferedImage image() {
		// TODO Auto-generated method stub
		return image;
	}

}
