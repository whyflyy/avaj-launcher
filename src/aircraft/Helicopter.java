package aircraft;

import coordinates.Coordinates;

public class Helicopter extends Aircraft{
	public Helicopter(long id, String name, Coordinates coordinates){
		super(id, name, coordinates);
	}

	@Override
	public void updateConditions(){
		String currentWeather = weatherTower.getWeather(coordinates);

		if (currentWeather == "sun") {
			fileHandler.addToOutput(String.format("%s: sunny weather, smooth flight ahead.", getIdentity()));
			coordinates.modifyLongitude(10);
			coordinates.modifyHeight(2);
		}
		else if(currentWeather == "rain") {
			fileHandler.addToOutput(String.format("%s: we're encountering some rain but it's manageable.", getIdentity()));
			coordinates.modifyLongitude(5);
		}
		else if (currentWeather == "fog") {
			fileHandler.addToOutput(String.format("%s: flying through fog, maintaining safety.", getIdentity()));
			coordinates.modifyLongitude(1);
		}
		else {
			fileHandler.addToOutput(String.format("%s: light snow along our route.", getIdentity()));
			coordinates.modifyHeight(-12);
		}
		super.updateConditions();
	}
}
