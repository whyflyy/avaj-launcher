package exceptions;

public class InvalidFileInformation extends Exception{
	public InvalidFileInformation() {
		super("One of the informations contained in the scenario files is invalid!");
	}

	public InvalidFileInformation(String message) {
		super(message);
	}

	public InvalidFileInformation(Throwable cause) {
		super(cause);
	}

	public InvalidFileInformation(String message, Throwable cause) {
		super(message, cause);
	}
}
