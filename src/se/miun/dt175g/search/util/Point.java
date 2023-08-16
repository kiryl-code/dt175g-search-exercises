package se.miun.dt175g.search.util;




/**
 * @author Peter Bergh
 */

public class Point implements Comparable<Point> {
	

	private int x;
	private int y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int x() {
		return x;
	}

	public int y() {
		return y;
	}

	public void x(int x) {
		this.x = x;
	}

	public void y(int y) {
		this.y = y;
	}
	

	@Override
    public int hashCode() {
        return 527 * x * y + x + y;
    }


	@Override
	public boolean equals(Object o) {
		Point p = (Point) o;
		return (x == p.x() && y == p.y());
	}
	
	public String toString() {
		return "["+ x + "," + y + "]";
	}

	@Override
	public int compareTo(Point p) {
		int cmp = y > p.y() ? +1 : y < p.y() ? -1 : 0;
		if(cmp != 0) {
			return cmp;
		}
		else {
			return x > p.x() ? +1 : x < p.x() ? -1 : 0;
		}
	}

}
