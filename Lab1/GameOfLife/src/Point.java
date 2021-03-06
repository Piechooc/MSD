import java.util.ArrayList;

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

	public void calculateNewState(Rules rule) {
		//TODO: insert logic which updates according to currentState and 
		//number of active neighbors
		int activeNeighbors = countActiveNeighbors();
		if (currentState == 1 && rule.neighborsToRemainAlive().contains(activeNeighbors)) {
			nextState = 1;
		} else if (currentState == 0 && rule.neighborsToReborn().contains(activeNeighbors)) {
			nextState = 1;
		} else {
			nextState = 0;
		}
	}

	public void changeState() {
		currentState = nextState;
	}
	
	public void addNeighbor(Point nei) {
		neighbors.add(nei);
	}
	
	//TODO: write method counting all active neighbors of THIS point
	private int countActiveNeighbors() {
		return (int) neighbors.stream()
				.filter(neighbor -> neighbor.currentState == 1)
				.count();
	}
}
