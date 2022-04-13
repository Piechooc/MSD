import java.util.ArrayList;

public class Point {

	public ArrayList<Point> neighbors;
	public static Integer []types ={0,1,2,3};
	public int type;
	public int staticField;
	public boolean isPedestrian;
	public boolean blocked = false;

	public Point() {
		type=0;
		staticField = 100000;
		neighbors= new ArrayList<Point>();
	}
	
	public void clear() {
		staticField = 100000;
		
	}

	public boolean calcStaticField() {
		int temp = 1000000;
		for (Point neigh : neighbors)
			if (neigh.staticField < temp)
				temp = neigh.staticField;

		if (this.staticField > temp + 1 && this.type != 1) {
			this.staticField = temp + 1;
			return true;
		}

		return false;
	}
	
	public void move() {
		if (isPedestrian && !blocked) {
			int tempValue = 1000000;
			Point tempPoint = null;
			{
				for (Point neigh : neighbors) {
					if (neigh.type == 0 || neigh.type == 2) {
						if (neigh.staticField < tempValue) {
							tempValue = neigh.staticField;
							tempPoint = neigh;
						}
					}
				}
			}

			if (tempPoint != null && !tempPoint.blocked) {
				this.type = 0;
				this.isPedestrian = false;
				tempPoint.blocked = true;
				if (tempPoint.type == 0) {
					tempPoint.type = 3;
					tempPoint.isPedestrian = true;
				}
			}
		}
	}

	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
}