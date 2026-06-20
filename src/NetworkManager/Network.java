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
		
	}
	
	// a Device object will be removed from the devices HashMap, but it will respond with
	// you removed the <Device> device
	// so device must be identified by IP first, the removed that way!
	public Device removeDevice(String ip) {
		return null;
	}
	
	// Searches HashMap by IP or name, with the device being sent back, so ret type is device
	public Device findDevice(String ip) {
		 return null;
	}
	
	// since many devices will be listed, it is simpler to return ArrayList<Device>
	public ArrayList<Device> listDevices() {
		return null;
	}
	
	
	
	
	
	
// DO NOT REMOVE	
}
