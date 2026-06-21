package NetworkManager;

public class Service {

	private String name;
	private int port;
	private boolean isRunning;
	// add description/notes field later

	// const goes here
	public Service(String name, int port, boolean isRunning) {
		this.name = name;
		this.port = port;
		this.isRunning = isRunning;
	}

	// getters / setters

	public int getPort() {
		return port;
	}

	public String getName() {
		return name;
	}

	public boolean getIsRunning() {
		return isRunning;
	}

	public void setIsRunning(boolean b) {
		isRunning = b;
	}

	@Override
	public String toString() {
		return "Service name: " + name + "\n" + "Port: " + port + "\n" + "IsRunning: " + isRunning;
	}

}
