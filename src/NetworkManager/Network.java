package NetworkManager;

import java.util.ArrayList;
import java.util.HashMap;

public class Network {

	// Network is the manager class.
	// It stores all Device objects in a HashMap for fast lookup by IP address.
	private HashMap<String, Device> devices; // this means a device will be identifiable by its name? or??
	// Why String ip?
	// → IP address is unique on a local network, so it is the best key.
	// → Using String allows formats like "192.168.1.10".

	// const goes here

	// Why Device d?
	// → We pass in a fully created Device object.
	// → Network does NOT construct devices; it only stores and manages them.

	// Why void?
	// → This is an "action method".
	// → We are modifying internal state (adding to HashMap), not returning data.
	public void addDevice(String ip, Device d) {

		devices.forEach((key, value) -> {
			if (devices.containsKey(ip)) {
				System.out.println("=== DEVICE EXISTS ===");
				System.out.println("IP: " + ip);
				System.out.println("Action: Device not added (duplicate IP)");
				return;
			}
			devices.put(ip, d);

			System.out.println("=== DEVICE ADDED ===");
			System.out.println("IP: " + ip);
			System.out.println("Device: " + d);
		});

	}

	// a Device object will be removed from the devices HashMap, but it will respond
	// with
	// you removed the <Device> device
	// so device must be identified by IP first, the removed that way!
	public Device removeDevice(String ip) {

		if (!devices.containsKey(ip)) {
			System.out.println("=== DEVICE NOT FOUND ===");
			System.out.println("IP: " + ip);
			return null;
		}

		Device removed = devices.remove(ip);

		System.out.println("=== DEVICE REMOVED ===");
		System.out.println("IP: " + ip);
		System.out.println("Device: " + removed);

		return removed;
	}

	// Searches HashMap by IP or name, with the device being sent back, so ret type
	// is device
	public Device findDevice(String ip) {

		if (!devices.containsKey(ip)) {
			System.out.println("=== DEVICE NOT FOUND ===");
			System.out.println("IP: " + ip);
			return null;
		}

		Device found = devices.get(ip);

		System.out.println("=== DEVICE FOUND ===");
		System.out.println("IP: " + ip);
		System.out.println("Device: " + found);

		return found;
	}

	// since many devices will be listed, it is simpler to return ArrayList<Device>
	public ArrayList<Device> listDevices() {
		return null;
	}

	/*
	 * Network ├── HashMap<String, Device> devices │ (IP → Device) │ ├── addDevice()
	 * → reject duplicates ├── removeDevice() → return removed Device ├──
	 * findDevice() → return + print Device └── listDevices() → return
	 * ArrayList<Device>
	 */

// DO NOT REMOVE	
}
