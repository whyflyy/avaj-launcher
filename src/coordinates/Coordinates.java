package coordinates;

public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height) {
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
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

	public void modifyLongitude(int value) {
		longitude += value;
	}

	public void modifyLatitude(int value) {
		latitude += value;
	}

	public void modifyHeight(int value) {
		if (height + value > 100)
			height = 100;
		else if (height + value < 0)
			height = 0;
		else
			height += value;
	}
}
