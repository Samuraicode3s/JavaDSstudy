package NetworkManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Network {

	private LinkedHashMap<String, Device> devices;

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
}