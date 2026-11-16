package weather;

import coordinates.Coordinates;

public class WeatherProvider {
	private static WeatherProvider instance;
	private String[] weather;

	private WeatherProvider() {
		weather = new String[]{"sun", "rain", "fog", "snow"};
	}

	public static WeatherProvider getInstance() {
		if (instance == null) {
			instance = new WeatherProvider();
		}
		return instance;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int i = (coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight()) % 4; //TODO: mudar formula para nao ficar muito repetido os casos
		return weather[i];
	}
}
