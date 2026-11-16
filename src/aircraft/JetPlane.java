package aircraft;

import coordinates.Coordinates;

public class JetPlane extends Aircraft {
	public JetPlane(long id, String name, Coordinates coordinates){
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions() {
		String currentWeather = weatherTower.getWeather(coordinates);

		if (currentWeather == "sun") {
			fileHandler.addToOutput(String.format("%s: cruising with a beautiful sunny view.", getIdentity()));
			coordinates.modifyLatitude(10);
			coordinates.modifyHeight(2);
		}
		else if(currentWeather == "rain") {
			fileHandler.addToOutput(String.format("%s: it's raining, but nothing we can't handle.", getIdentity()));
			coordinates.modifyLatitude(5);
		}
		else if (currentWeather == "fog") {
			fileHandler.addToOutput(String.format("%s: flying through foggy areas, maintain care.", getIdentity()));
			coordinates.modifyLatitude(1);
		}
		else {
			fileHandler.addToOutput(String.format("%s: it's snowing, but it's so pretty.", getIdentity()));
			coordinates.modifyHeight(-7);
		}
		super.updateConditions();
	}
}
