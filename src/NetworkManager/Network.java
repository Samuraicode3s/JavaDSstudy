package NetworkManager;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Network {

    private LinkedHashMap<String, Device> devices;

    public Network() {
        devices = new LinkedHashMap<>();
    }

    public void addDevice(String ip, Device d) {

        if (devices.containsKey(ip)) {
            System.out.println("=== DEVICE EXISTS ===");
            System.out.println("IP: " + ip);
            System.out.println("Action: not added (duplicate IP)");
            return;
        }

        devices.put(ip, d);

        System.out.println("=== DEVICE ADDED ===");
    }

    public Device removeDevice(String ip) {

        if (!devices.containsKey(ip)) {
            System.out.println("=== DEVICE NOT FOUND ===");
            return null;
        }

        Device removed = devices.remove(ip);

        System.out.println("=== DEVICE REMOVED ===");

        return removed;
    }

    public Device findDevice(String ip) {

        if (!devices.containsKey(ip)) {
            System.out.println("=== DEVICE NOT FOUND ===");
            System.out.println("IP: " + ip);
            return null;
        }

        Device found = devices.get(ip);

        System.out.println("=== DEVICE FOUND ===");
        System.out.println("IP: " + ip);
        System.out.println("Name: " + found.getName());

        return found;
    }

    public ArrayList<Device> listDevices() {

        return new ArrayList<>(devices.values());
    }
}