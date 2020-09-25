package Img;

import java.awt.BorderLayout;
import java.awt.Container;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Aplication implements Runnable {
	JLabel labelWithImage;
	BufferedImage image;
	private JFrame frame = new JFrame(" Load Image Sample");

	public void UserInterface() {

	}

	// detta skapar själva "rutan" eller interfacet
	@Override
	public void run() {

		// väld titel
		frame = new JFrame("My World");

		// Välj hur stor rutan till Desktop Applikationen ska vara
		frame.setPreferredSize(new Dimension(1500, 550));
		// skapa en exit så vi kan kryssa ner applikationen korrekt
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// kallar på metoden (som har allt innehåll)
		createComponents(frame.getContentPane());
		// Lägger till bilden
		// frame.add(new LoadImageApp());
		// packeterar för att få våran frame till att visas (samlar all information och
		// ser till så allt är redo)

		frame.pack();
		// så att våran frame ska vara synlig
		frame.setVisible(true);

	}

	// Här lägger vi till all elemnt som kommer finnas i vår UI (rutan)
	public void createComponents(Container container) {

		GridLayout layout = new GridLayout(1, 3);
		container.setLayout(layout);
//		LoadImageApp picture = new LoadImageApp();
//		picture.image();
//		container.add(picture); // add image into the container

		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("Pic.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel labelWithImg = new JLabel(new ImageIcon(image));
		container.add(labelWithImg);

		// Här skapar vi knappar och kopplar dem till våra Actionlisteners

		JButton But1 = new JButton("Minimize!");
		buttonsListener useButton1 = new buttonsListener(labelWithImg);
		GridLayout layoutB = new GridLayout(1, 1);
		But1.setLayout(layoutB);

		But1.addActionListener(useButton1);
		But1.setSize(50, 50);

		JButton But2 = new JButton("Color!");
		ButtonListener2 useButton2 = new ButtonListener2(labelWithImg);
		But2.addActionListener(useButton2);
		container.add(But2);
		container.add(But1, BorderLayout.WEST);

		
		JButton But3 = new JButton("rotate");
		ButtonListener3 useButton3 = new ButtonListener3(labelWithImg);
		But3.addActionListener(useButton3);
		container.add(But3);
		

		


	}

	public JFrame getFrame() {
		return frame;
	}

}