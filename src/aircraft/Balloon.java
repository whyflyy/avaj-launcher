package aircraft;

import coordinates.Coordinates;

public class Balloon extends Aircraft{
		public Balloon(long id, String name, Coordinates coordinates){
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		String currentWeather = weatherTower.getWeather(coordinates);

		if (currentWeather == "sun") {
			fileHandler.addToOutput(String.format("%s: the sun is shining and the balloon is rising.", getIdentity()));
			coordinates.modifyLongitude(2);
			coordinates.modifyHeight(4);
		}
		else if(currentWeather == "rain") {
			fileHandler.addToOutput(String.format("%s: the rain is going to ruin the balloon.", getIdentity()));
			coordinates.modifyHeight(-5);
		}
		else if (currentWeather == "fog") {
			fileHandler.addToOutput(String.format("%s: it's quite foggy, but we are fine.", getIdentity()));
			coordinates.modifyHeight(-3);
		}
		else {
			fileHandler.addToOutput(String.format("%s: it's snowing, descending.", getIdentity()));
			coordinates.modifyHeight(-15);
		}
		super.updateConditions();
	}
}
