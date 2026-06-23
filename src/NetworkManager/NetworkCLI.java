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
            System.out.println("7. Exit");


            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Input name: ");
                String name = sc.nextLine();

                System.out.println("Input IP: ");
                String ip = sc.nextLine();

                System.out.println("OS: ");
                String os = sc.nextLine();

                System.out.println("Working status (true or false): ");
                boolean stat = sc.nextBoolean();
                sc.nextLine(); // FIX INPUT BUG

                Device d = new Device(name, ip, os, stat);

                net1.addDevice(ip, d);

                System.out.println("Device " + name + " has been added");

            }

            if (choice == 2){
                System.out.println("Input name of service: ");
                String name = sc.nextLine();
                System.out.println("Input port: ");
                int port = sc.nextInt();
                System.out.println("Add online status (true or false): ");
                Boolean stat = sc.nextBoolean();
                sc.nextLine();
                Service s1 = new Service(name, port, stat);

                //service needs to be added to a device,


            }




            // ADD SERVICE DONT FORGET

            if (choice == 3) {
                System.out.println("Input ip of device to remove: ");
                String ip = sc.nextLine();
                net1.removeDevice(ip);
                for (Device d : net1.listDevices()) {
                    System.out.print(d);
                    System.out.println("---------------------");
                }

            }

            if (choice == 5) {
                System.out.println();
                // check later for empty list!!
                System.out.println("=== DEVICE LIST ===");
                for (Device d : net1.listDevices()) {
                    System.out.println(d);
                    System.out.println("---------------------");
                }
            }

            if (choice == 6) {
                // find device flow
            }

            if (choice == 7) {
                break;
            }

        }

    }

}