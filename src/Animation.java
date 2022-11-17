import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.*;
public class Animation extends JPanel {

	Parameters param;
	double[][] coordinates;
	int[] type;
	int fWidth;
	int fHeight;
	JLabel[] body;
	ImageIcon[] image;
	double distanceScale;
	
	public Animation(Parameters p)
	{
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		param = p;
//		fWidth = param.getFrameWidth();
//		fHeight = param.getFrameHeight();
		initBodies();
	}
	private void initBodies()
	{
		type = param.getType();
		body = new JLabel[type.length];
		distanceScale = param.getDistanceScale();
		initImages();
		for(int i=0; i<body.length; i++)
		{
			body[i] = new JLabel();
			body[i].setSize(50, 50);
			body[i].setIcon( image[type[i]] );
			this.add(body[i]);
		}
	}
	
	private void initImages()
	{
		image = new ImageIcon[3];
		image[0] = new ImageIcon("C:\\Users\\userss\\Documents\\Majeed\\eclipse-new-projects-test\\Gravitation\\Sun.png");
		image[1] = new ImageIcon("C:\\Users\\userss\\Documents\\Majeed\\eclipse-new-projects-test\\Gravitation\\Planet.png");
		image[2] = new ImageIcon("C:\\Users\\userss\\Documents\\Majeed\\eclipse-new-projects-test\\Gravitation\\Moon.png");
	}
	
	public void update(double[][] coord)
	{
		coordinates = coord;
		for(int i=0; i<body.length; i++)
		{
			body[i].setLocation((int)(coordinates[i][0]/distanceScale-25), (int)(coordinates[i][1]/distanceScale-25));
		}
	}

}
