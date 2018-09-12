
public class PointMain {
	public static void main(String[] args) {
		int size = 1000;
		Point[] array = PointGenerator.getRandomPointsDouble(size);
		Point origin = new Point(0.0,0.0);
		
		double minD = Double.MAX_VALUE;
		Point minP = null;
		
		for(Point p : array) {
			double d = p.distanceFrom(origin);
			if (d < minD) {
				minD = d;
				minP = p;
			}
		}
		System.out.println("min distance = "+minD);
		System.out.println("min point = "+minP);
	}
}
