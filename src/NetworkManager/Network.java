package NetworkManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Network {

	private LinkedHashMap<String, Device> devices;

	// const
	public Network() {
		devices = new LinkedHashMap<>();
	}
	
	
	
	
	
	

	public boolean addDevice(String ip, Device d) {

		if (devices.containsKey(ip)) {
			return false;
		}

		devices.put(ip, d);
		return true;
	}

	public Device removeDevice(String ip) {

		if (!devices.containsKey(ip)) {
			return null;
		}

		Device removed = devices.remove(ip);

		return removed;
	}

	public Device findDevice(String ip) {

		if (!devices.containsKey(ip)) {
			return null;
		}

		Device found = devices.get(ip);
		return found;
	}

	public ArrayList<Device> listDevices() {

		return new ArrayList<>(devices.values());
	}

	public void saveNetwork(String filename) {
		/*
		 * Open file. Loop through devices. Write one DEVICE line. Loop through
		 * services. Write SERVICE lines. Close file.
		 */
	}

	public void loadNetwork(String filename) {
		/*
		 * Open file. 
		 * Read line. 
		 * If line starts with DEVICE: 
		 * create Device. remember it
		 * as current device. 
		 * If line starts with SERVICE: 
		 * create Service. 
		 * add it to
		 * current device. Continue until end of file.
		 */
	}

	public void networkSummary() {
		// find size devices.size()
		// loop through all devices
		// get each of their services for (Device d : devices.values())
		// in each device find # of services and their status. count running and stopped
		// expose services list (getter), OR
		// provide helper methods
		// track totalServices, running, and stopped
		int totalDevices = devices.size();
		int totalServices = 0;
		int running = 0;
		int stopped = 0;

		for (Device d : devices.values()) {
			for (Service s : d.getServices()) {
				totalServices++;
				if (s.getIsRunning()) {
					running++;
				} else {
					stopped++;
				}

			}

		}
		System.out.println("=== NETWORK SUMMARY ===");
		System.out.println("Devices: " + totalDevices);
		System.out.println("Total Services: " + totalServices);
		System.out.println("Running: " + running);
		System.out.println("Stopped: " + stopped);

	}

}