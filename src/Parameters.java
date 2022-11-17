
public class Parameters {

	int timerDelay;
	double coordinates[][];
	double initVelocity[][];
//	double acceleration[][];
	double mass[];
	int type[];
	double timeScale;
	double distanceScale;
	int frameWidth;
	int frameHeight;
	
	public Parameters()
	{
		distanceScale = 1e8;
		frameWidth = 1200;
		frameHeight = 800;
		timerDelay = 2;
		double[][] coord = {
				{600,300}
				,{500,400}
				,{250,420}
//				,{230,400}
		};
		coordinates = coord;
		double[][] initV = {
				{1e5,-1e4}
				,{-1e4, -3e4}
				,{-2e4, 2e4}
//				,{0, 0}
		 };
		initVelocity = initV;
		for(int i=0;i<coordinates.length;i++)
		{
			coordinates[i][0]*=distanceScale;
			coordinates[i][1]*=distanceScale;
//			initVelocity[i][0]*=0.7;
//			initVelocity[i][1]*=0.7;
		}
		double[] m = {
				1e30
				,1e30
				,1e30
//				,1e24
		};
		mass = m;
		int[] t = {
				0
				,0
				,0
//				,1
		};
		type = t;
		timeScale = 0.8e6;
	}
	
	public int getTimerDelay()
	{
		return timerDelay;
	}
	
	public double[][] getCoordinates()
	{
		return coordinates;
	}
	
	public double[][] getInitialVelocity()
	{
		return initVelocity;
	}
//	
//	public double[][] getAcceleration()
//	{
//		return acceleration;
//	}
	
	public double[] getMass()
	{
		return mass;
	}
	
	public int[] getType()
	{
		return type;
	}
	
	public int getFrameWidth()
	{
		return frameWidth;
	}
	
	public int getFrameHeight()
	{
		return frameHeight;
	}
	
	public double getTimeScale()
	{
		return timeScale;
	}
	
	public double getDistanceScale()
	{
		return distanceScale;
	}
	
}
