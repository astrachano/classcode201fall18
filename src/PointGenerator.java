import java.util.*;

public class PointGenerator {
	private static int SEED = 12345;
	public static final int MAX = 1000;
	private static Random myRandom = new Random(SEED);
	
	/**
	 * Return an array of random points with x,y double coordinates [0,MAX)
	 * @param n is the number of points
	 * @return array of n random points
	 */
	public static Point[] getRandomPointsDouble(int n) {
		ArrayList<Point> list = new ArrayList<>();
		for(int k=0; k < n; k += 1) {
			double x = myRandom.nextDouble()*MAX;
			double y = myRandom.nextDouble()*MAX;
			list.add(new Point(x,y));
		}
		return list.toArray(new Point[0]);
	}
	
	/**
	 * Return an array of random points with x,y int coordinates [0,range)
	 * @param n is the number of points
	 * @param range is the maximal int value (open interval) for x,y
	 * @return array of n random points
	 */
	public static Point[] getRandomPointsInt(int n, int range) {
		ArrayList<Point> list = new ArrayList<>();
		for(int k=0; k < n; k += 1) {
			double x = myRandom.nextInt(range);
			double y = myRandom.nextInt(range);
			list.add(new Point(x,y));
		}
		return list.toArray(new Point[0]);
	}
	
	/**
	 * Change seed of random number generator
	 * @param seed is new seed of random number generator
	 */
	public void setSeed(long seed) {
		myRandom.setSeed(seed);
	}
}
