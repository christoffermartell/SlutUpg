package Img;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ButtonListener3<Rotate> implements ActionListener {

	public JLabel labelWithImg;
	BufferedImage img;

	public ButtonListener3(JLabel labelWithImg) {

		this.labelWithImg = labelWithImg;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
		
		try {
			rotated();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		System.out.println("Roterad!");

	}
	
	// Här laddar vi in våran bild och sedan roterar vi den, sen sparar ner den nya roteradebilden och 
	// längst ner så lägger vi in bilden i en ImageIcon och sedan kallar vi på metoden uppe i ActionPerformed som är vad våran knapp gör.
	
	public void rotated() throws IOException {
		
		
			BufferedImage image = ImageIO.read(new File("Pic.jpg"));
		
		
		
		
		final double rads = Math.toRadians(90);
		final double sin = Math.abs(Math.sin(rads));
		final double cos = Math.abs(Math.cos(rads));
		final int w = (int) Math.floor(image.getWidth() * cos + image.getHeight() * sin);
		final int h = (int) Math.floor(image.getHeight() * cos + image.getWidth() * sin);
		final BufferedImage rotatedImage = new BufferedImage(w, h, image.getType());
		final AffineTransform at = new AffineTransform();
		at.translate(w / 2, h / 2);
		at.rotate(rads,0, 0);
		at.translate(-image.getWidth() / 2, -image.getHeight() / 2);
		final AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		rotateOp.filter(image,rotatedImage);
		
		ImageIO.write(rotatedImage, "jpg", new File("rotatedImage.jpg"));
		
		ImageIcon picture = new ImageIcon("rotatedImage.jpg");
		Image newpicture = picture.getImage();
		labelWithImg.setIcon(new ImageIcon(newpicture));
		
		

	}
	
	

	
}
