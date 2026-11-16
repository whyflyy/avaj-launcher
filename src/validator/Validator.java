package validator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import exceptions.InvalidFileInformation;


public class Validator {
	private int iterations;
	private List<AircraftInfo> aircraftInfo;

	public class AircraftInfo {
		private String type;
		private String name;
		private int longitude;
		private int latitude;
		private int height;

		private AircraftInfo(String line) throws InvalidFileInformation {
			String[] info = line.split(" ");
			if (info.length != 5) {
				throw new InvalidFileInformation("One of the aircraft lines is invalid!"); //TODO mudar?
			}
			type = info[0];
			name = info[1];
			longitude = Integer.parseInt(info[2]);
			latitude = Integer.parseInt(info[3]);
			height = Integer.parseInt(info[4]);

			if (height > 100) {
				height = 100;
			}

			if (!type.matches("Balloon|Helicopter|JetPlane")) {
				throw new InvalidFileInformation("There is an aircraft with an invalid type!");
			}

			if (longitude < 0) {
				throw new InvalidFileInformation("There is an aircraft with invalid longitude!");
			}
			else if (latitude < 0) {
				throw new InvalidFileInformation("There is an aircraft with invalid latitude!");
			}
			else if (height < 0) {
				throw new InvalidFileInformation("There is an aircraft with invalid height!");
			}
		}
		
		public String getType() {
			return type;
		}

		public String getName() {
			return name;
		}

		public int getLongitude() {
			return longitude;
		}

		public int getLatitude() {
			return latitude;
		}

		public int getHeight() {
			return height;
		}
	}

	public Validator() {
		iterations = -1;
		aircraftInfo = new ArrayList<AircraftInfo>();
	}

	public void parseFile(String file) throws FileNotFoundException, InvalidFileInformation {
		File f = new File(file);
		try (Scanner scan = new Scanner(f)) {
			boolean firstLine = true;
			while (scan.hasNextLine()) {
				if (firstLine) {
					iterations = Integer.parseInt(scan.nextLine());
					if (iterations < 1) {
						throw new InvalidFileInformation("Iteration number has to be a positive integer!");
					}
					firstLine = false;
				}
				else {
					aircraftInfo.add(new AircraftInfo(scan.nextLine()));
				}
			}
			if (iterations == -1 || aircraftInfo.isEmpty()) {
				throw new InvalidFileInformation();
			}
		}
	}

	public int getIterations() {
		return iterations;
	}

	public AircraftInfo[] getAircraftInfo() {
		return aircraftInfo.toArray(new AircraftInfo[0]);
	}
}
