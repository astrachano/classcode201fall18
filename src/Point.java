import java.util.ArrayList;
import java.util.Collections;

public class Point implements Comparable<Point> {
	private double myX;
	private double myY;
	
	/**
	 * Construct point from x,y coordinates
	 * @param x is the x-coordinate of this point
	 * @param y is the y-coordinate of this point
	 */
	public Point(double x, double y) {
		myX = x;
		myY = y;
	}
	
	@Override
	public String toString() {
		return String.format("(%2.3f,%2.3f)", myX, myY);
	}
	
	/**
	 * return Euclidean distance from this point to another point
	 * @param other Point to which distance calculated
	 * @return distance from this point to other
	 */
	public double distanceFrom(Point other) {
		double dx = myX - other.myX;
		double dy = myY - other.myY;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	/**
	 * Return this points x-coordinate
	 * @return x-coordinate
	 */
	public double getX() {
		return myX;
	}
	
	@Override
	public boolean equals(Object o) {

		Point other = (Point) o;
		if (other.myX == myX && other.myY == myY) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return (int) (37*myX + myY);
		//return toString().hashCode();
	}
	
	public static void main(String[] args) {
		ArrayList<Point> list = new ArrayList<>();
		list.add(new Point(0,7));
		list.add(new Point(0,5));
		Collections.sort(list);
		for(Point p : list) {
			System.out.println(p);
		}
	}

	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		if (this.myX < o.myX) return -1;
		if (this.myY < o.myY) return -1;
		if (this.myX > o.myX) return 1;
		if (this.myY > o.myY) return 1;
		return 0;
	}
}
