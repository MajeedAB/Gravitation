import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class Universe extends JPanel implements ActionListener {

	double Dt;
	double[][] coordinates;
	double[][] velocity;
	double[][] acceleration;
	double[] mass;
	int type[];
	double timeScale;
	double dSc; //distanceScale
	
	
	double G = 6.674e-11;
	
	static Parameters param = new Parameters();
	static Animation anim = new Animation(param);
	Timer tim;
	
	
	public Universe()
	{
		tim = new Timer(param.getTimerDelay(), this);
		Dt = (double) param.getTimerDelay()/1000;
		coordinates = param.getCoordinates();
		velocity = param.getInitialVelocity();
//		velocity = new double[coordinates.length][2];
//		acceleration = param.getAcceleration();
		acceleration = new double[coordinates.length][2];
		mass = param.getMass();
		type = param.getType();
		timeScale = param.getTimeScale();
		dSc = param.getDistanceScale();
		
	}
	
	public void start()
	{
		tim.start();
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		moveBodies();
		anim.update(coordinates);
	}
	
	private void moveBodies()
	{
		calcAcceleration();
		updateVelPos();
	}
	
	private void calcAcceleration()
	{
		resetAcceleration();
		for(int body=0; body<coordinates.length; body++)
		{
			for(int i=0; i<coordinates.length; i++)
			{
				if(body!=i)
				{
					double xDist = coordinates[i][0] - coordinates[body][0];
					double yDist = coordinates[i][1] - coordinates[body][1];
					
					double preAccel = G*mass[i]/Math.pow( Math.sqrt( Math.pow(xDist,2) + Math.pow(yDist,2) ),3 ) ;
					acceleration[body][0] += preAccel * xDist;
					acceleration[body][1] += preAccel * yDist;
					
				}
			}
		}
	}
	
	private void updateVelPos()
	{
		for(int body=0; body<coordinates.length; body++)
		{
			velocity[body][0]+= acceleration[body][0] * Dt * timeScale;
			velocity[body][1]+= acceleration[body][1] * Dt * timeScale;
			coordinates[body][0]+= velocity[body][0] * Dt * timeScale;
			coordinates[body][1]+= velocity[body][1] * Dt * timeScale;
		}
	}
	
	private void resetAcceleration()
	{
		for(int i=0; i<acceleration.length; i++)
		{
			for(int j=0; j<acceleration[i].length; j++)
			{
				acceleration[i][j] = 0;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Universe uni = new Universe();
		uni.start();
		
		JFrame jf = new JFrame();
		jf.setTitle("Universe gravitation simulation");
		jf.setSize(param.getFrameWidth(), param.getFrameHeight());
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(anim);
		jf.setVisible(true);
		
	}
}
