import java.util.ArrayList;
import java.util.Random;

public class Point {
	private ArrayList<Point> neighbors;
	private int currentState;
	private int nextState;
	private int numStates = 6;
	
	public Point() {
		currentState = 0;
		nextState = 0;
		neighbors = new ArrayList<Point>();
	}

	public void clicked() {
		currentState=(++currentState)%(numStates + 1);
	}
	
	public int getState() {
		return currentState;
	}

	public void setState(int s) {
		currentState = s;
	}

	public void calculateNewState() {
		//TODO: insert logic which updates according to currentState and 
		//number of active neighbors
		if (currentState > 0) {
			nextState = currentState - 1;
		}
		else if (!neighbors.isEmpty() && neighbors.get(0).getState() > 0) {
			nextState = 6;
		}
	}

	public void drop() {
		Random random = new Random();
		if (random.nextInt(100) < 2) {
			nextState = 6;
		} else if (currentState > 0) {
			nextState = currentState - 1;
		}
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
	
	//TODO: write method counting all active neighbors of THIS point
}
