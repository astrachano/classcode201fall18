import java.util.*;

public class RandomPointDriver {
	public static void main(String[] args) {
		
		int size = 10;
		int max = 2;
		Point[] array = PointGenerator.getRandomPointsInt(size, max);
		ArrayList<Point> list = new ArrayList<>();
		for(Point p : array) {
			if (! list.contains(p)) {
				list.add(p);
			}
		}
		System.out.printf("array = %d, list = %d\n", array.length, list.size());
		for(Point p : list) {
			System.out.println(p);
		}
	}
}
