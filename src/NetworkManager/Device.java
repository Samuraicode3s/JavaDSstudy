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
	public void addService(Service s) {

		for (Service existing : services) {

			if (existing.getPort() == s.getPort()) {

				System.out.println("=== SERVICE CONFLICT ===");
				System.out.println("Port: " + s.getPort());
				System.out.println("Existing Service: " + existing.getName());
				System.out.println("New Service: " + s.getName());
				System.out.println("Reason: Port already in use on this device");

				return;
			}
		}

		services.add(s);

		System.out.println("=== SERVICE ADDED ===");
		System.out.println("Service: " + s.getName());
		System.out.println("Port: " + s.getPort());
	}

	// Device owns ArrayList<Service>, so it will need to search inside list and
	// remove matching service
	// this means param should be a port
	// void because it completes an action and does not need to return anything
	public void removeService(int port) {

		for (int i = 0; i < services.size(); i++) {

			Service existing = services.get(i);

			if (existing.getPort() == port) {

				services.remove(i);

				System.out.println("=== REMOVED SERVICE ===");
				System.out.println("Service: " + existing.getName());
				System.out.println("Port: " + existing.getPort());

				return;
			}
		}

		// if we reach here → nothing found
		System.out.println("=== SERVICE NOT FOUND ===");
		System.out.println("Port: " + port);
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
	public String getServices() {
		return null;
	}

	/*
	 * Network → manages Devices
	 * Device → owns Services
	 * Service → prints itself
	 */

	@Override
	public String toString() {

		String result = "=== Device Info ===" + "\n" + "Name: " + name + "\n" +
				"IP address: " + ipAddress + "\n" + "OS: " + OS + "\n" + "Online: " + isOnline + "\n";

		for (Service s : services) {
			result += "    " + s.toString() + "\n";
		}

		return result;

	}

}
