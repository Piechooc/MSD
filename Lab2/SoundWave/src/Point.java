public class Point {

	public Point nNeighbor;
	public Point wNeighbor;
	public Point eNeighbor;
	public Point sNeighbor;
	public float nVel;
	public float eVel;
	public float wVel;
	public float sVel;
	public float pressure;
	public static Integer[] types = {0, 1, 2};
	public int type;
	public int sinInput = 0;

	public Point() {
		this.type = 0;
		clear();
	}

	public void clicked() {
		pressure = 1;
	}
	
	public void clear() {
		// TODO: clear velocity and pressure
		nVel = 0;
		eVel = 0;
		sVel = 0;
		wVel = 0;

		pressure = 0;
	}

	public void updateVelocity() {
		// TODO: velocity update
		if (this.type == 0) {
			nVel = nVel - (nNeighbor.pressure - pressure);
			eVel = eVel - (eNeighbor.pressure - pressure);
			sVel = sVel - (sNeighbor.pressure - pressure);
			wVel = wVel - (wNeighbor.pressure - pressure);
		}
	}

	public void updatePressure() {
		// TODO: pressure update
		if (this.type == 0) {
			this.pressure = pressure - 0.5f * (nVel + eVel + sVel + wVel);
		}

		if (this.type == 2) {
			double radians = Math.toRadians(sinInput);
			pressure = (float) (Math.sin(radians));
			this.sinInput = (sinInput + 10) % 360;
		}
	}

	public float getPressure() {
		return pressure;
	}
}