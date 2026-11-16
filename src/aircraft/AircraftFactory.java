package aircraft;

import coordinates.Coordinates;

public class AircraftFactory {
	private static AircraftFactory instance;
	private long currentId = 1;

	public static AircraftFactory getInstance() {
		if (instance == null) {
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String type, String name, Coordinates coordinates) {
		Flyable flyable;
		if (type.equals("Balloon")) {
			flyable = new Balloon(currentId, name, coordinates);
		}
		else if (type.equals("Helicopter")) {
			flyable = new Helicopter(currentId, name, coordinates);
		}
		else {
			flyable = new JetPlane(currentId, name, coordinates);
		}
		currentId++;
		return flyable;
	}
}
