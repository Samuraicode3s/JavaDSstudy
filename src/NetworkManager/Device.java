package NetworkManager;

import java.util.ArrayList;

/*
 *  CLI (user input / prompts)
        ↓
	Network (controller / logic flow)
        ↓
	Device (data + rules)
 */

public class Device {
	private String name;
	private String ipAddress; // making it a string as that seems to make the most sense. If it were int would
								// not be possible
	private String OS;
	private boolean lastOperationConflict;
	private boolean isOnline; // boolean only because a device is either on and running, or its off and
								// nothing is running
	private ArrayList<Service> services;

	// const goes here
	public Device(String name, String ipAddress, String OS, boolean isOnline) {
		this.name = name;
		this.ipAddress = ipAddress;
		this.OS = OS;
		this.isOnline = isOnline;
		services = new ArrayList<>();
	}

	/*
	 * When adding a Service to this Device: - Service uniqueness is determined by
	 * PORT number - A device cannot have two services using the same port
	 * 
	 * Behavior: - If no service exists on the same port → add Service to list - If
	 * a service already exists on that port → print detailed warning: - port number
	 * - existing service name - conflict reason
	 * 
	 * This method does NOT handle user interaction.
	 */
	public boolean addService(Service s) {

		for (Service existing : services) {

			if (existing.getPort() == s.getPort()) {
				return false;
			}
		}

		services.add(s);
		return true;
	}

	// Device owns ArrayList<Service>, so it will need to search inside list and
	// remove matching service
	// this means param should be a port
	// void because it completes an action and does not need to return anything
	public boolean removeService(int port) {

		for (int i = 0; i < services.size(); i++) {

			if (services.get(i).getPort() == port) {
				services.remove(i);
				return true;
			}
		}

		return false;
	}

	/*
	 * Look through services list Find service with matching port If found: remove
	 * it from list print confirmation (optional CLI feedback) set
	 * lastOperationConflict = false If NOT found: print warning:
	 * "no service on that port" set lastOperationConflict = true
	 */

	// When services are displayed, they are returned as string in a viewable list
	// for now will return just ArrayList<Service>, formatted later
	// confused which is easer to do now? which one better for CLI for NOW?
	public ArrayList<Service> getServices() {
		return services;
	}

	/*
	 * Network → manages Devices Device → owns Services Service → prints itself
	 */

	public boolean toggleService(int port) {

		// loop through services
		for (Service s : services) {
			if (s.getPort() == port) {
				if (s.getIsRunning()) {
					s.setIsRunning(false);
					return true;
				} else {
					s.setIsRunning(true);
					return true;
				}

			}
		}
		return false;

		// find matching port

		// change running state

		// return true

		// return false if not found
	}

	public String getName() {
		return name;
	}

	public String getIP() {
		return ipAddress;
	}
	
	
	
	
	
	
	@Override
	public String toString() {

		String result = "========================" + "\n" + "DEVICE: " + name + "\n" + "IP: " + ipAddress + "\n"
				+ "OS: " + OS + "\n" + "ONLINE: " + isOnline + "\n";

		for (Service s : services) {
			result += "\n" + name + " === " + "\n" + s.toString() + "\n\n";
		}

		return result;
	}

}
