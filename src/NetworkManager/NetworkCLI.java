package NetworkManager;

import java.util.Scanner;

public class NetworkCLI {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Network net1 = new Network();

		while (true) {

			System.out.println("\n=== NETWORK MENU ===");
			System.out.println("1. Add Device");
			System.out.println("2. Add Service");
			System.out.println("3. Remove Device");
			System.out.println("4. Remove Service");
			System.out.println("5. List Devices");
			System.out.println("6. Find Device");
			System.out.println("7. Toggle Service Status");
			System.out.println("8. Network Summary");
			System.out.println("9. Exit");

			int choice = sc.nextInt();
			sc.nextLine();

			// ==================================================
			// 1. ADD DEVICE
			// ==================================================
			if (choice == 1) {

				System.out.println("Input name: ");
				String name = sc.nextLine();

				System.out.println("Input IP: ");
				String ip = sc.nextLine();

				System.out.println("OS: ");
				String os = sc.nextLine();

				System.out.println("Working status (true or false): ");
				boolean stat = sc.nextBoolean();
				sc.nextLine();

				Device d = new Device(name, ip, os, stat);

				boolean success = net1.addDevice(ip, d);

				if (success) {
					System.out.println("Device " + name + " has been added");
				} else {
					System.out.println("ERROR: Device with IP " + ip + " already exists");
				}
			}

			// ==================================================
			// 2. ADD SERVICE
			// ==================================================
			if (choice == 2) {

				System.out.println("Input device IP which will run the service: ");
				String ip2 = sc.nextLine();

				Device d2 = net1.findDevice(ip2);

				if (d2 == null) {
					System.out.println("Device not found");
				} else {

					System.out.println("Service name: ");
					String name = sc.nextLine();

					System.out.println("Port: ");
					int port = sc.nextInt();

					System.out.println("Running (true/false): ");
					boolean run = sc.nextBoolean();
					sc.nextLine();

					Service s = new Service(name, port, run);

					boolean success = d2.addService(s);

					if (success) {
						System.out.println("Service added successfully");
					} else {
						System.out.println("ERROR: Port already in use on this device");
					}
				}
			}

			// ==================================================
			// 3. REMOVE DEVICE
			// ==================================================
			if (choice == 3) {

				System.out.println("Input IP of device to remove: ");
				String ip3 = sc.nextLine();

				Device removed = net1.removeDevice(ip3);

				if (removed == null) {
					System.out.println("Device does not exist");
				} else {
					System.out.println("Device has been removed");
				}
			}

			// ==================================================
			// 4. REMOVE SERVICE
			// ==================================================
			if (choice == 4) {

				System.out.println("Enter device IP: ");
				String ip4 = sc.nextLine();

				Device d4 = net1.findDevice(ip4);

				if (d4 == null) {
					System.out.println("Device not found");
				} else {

					System.out.println("Enter service port: ");
					int port = sc.nextInt();
					sc.nextLine();

					boolean success = d4.removeService(port);

					if (success) {
						System.out.println("Service removed successfully");
					} else {
						System.out.println("ERROR: Service not found on this device");
					}
				}
			}

			// ==================================================
			// 5. LIST DEVICES
			// ==================================================
			if (choice == 5) {

				System.out.println("\n=== DEVICE LIST ===");

				for (Device d : net1.listDevices()) {
					System.out.println(d);
					System.out.println("---------------------");
				}
			}

			// ==================================================
			// 6. FIND DEVICE
			// ==================================================
			if (choice == 6) {

				System.out.println("Enter IP of device you are looking for: ");
				String ip6 = sc.nextLine();

				Device d6 = net1.findDevice(ip6);

				if (d6 == null) {
					System.out.println("Device was not found");
				} else {
					System.out.println("=== DEVICE FOUND ===");
					System.out.println(d6);
				}
			}

			// ==================================================
			// 7. TOGGLE SERVICE STATUS
			// ==================================================
			if (choice == 7) {
				System.out.println("Enter device IP: ");
				String ip7 = sc.nextLine();
				// does exist
				Device d7 = net1.findDevice(ip7);
				if (d7 == null) {
					System.out.println("Device not found");
				} else {
					System.out.println("Enter service port: ");
					int port7 = sc.nextInt();
					sc.nextLine();

					boolean success = d7.toggleService(port7);

					if (success) {
						System.out.println("Service status changed");
					} else {
						System.out.println("ERROR: Service not found on this device");
					}

				}
			}

			// ==================================================
			// 8. NETWORK SUMMARY
			// ==================================================
			if (choice == 8) {
				net1.networkSummary();
			}

			/*
			 * boolean success = net1.saveNetwork("network.txt");
			 * save succeeds → return true
			 * save fails → return false
			 * if (success) { System.out.println("Network saved."); } else {
			 * System.out.println("Error saving file."); }
			 */

			// ==================================================
			// 9. EXIT
			// ==================================================
			if (choice == 9) {
				break;
			}
		}

		sc.close();
	}

// DO NOT DELETE
}