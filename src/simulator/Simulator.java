package simulator;

import aircraft.AircraftFactory;
import coordinates.Coordinates;
import exceptions.InvalidArgumentsException;
import file.FileHandler;
import tower.WeatherTower;
import validator.Validator;

public class Simulator {
	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				throw new InvalidArgumentsException();
			}
			Validator validator = new Validator();
			validator.parseFile(args[0]);
			WeatherTower weatherTower = new WeatherTower();

			for (Validator.AircraftInfo airInfo : validator.getAircraftInfo()) {
				Coordinates c = new Coordinates(airInfo.getLongitude(), airInfo.getLatitude(), airInfo.getHeight());
				AircraftFactory.getInstance().newAircraft(airInfo.getType(), airInfo.getName(), c).registerTower(weatherTower);
			}

			for (int i = 0; i < validator.getIterations(); i++) {
				weatherTower.changeWeather();
			}
			FileHandler.getInstance().writeOutputToFile();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}