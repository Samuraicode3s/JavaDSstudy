package NetworkManager;

public class NetworkCLI {
    public static void main(String args[]){

        Network net1 = new Network();


        Service s11 = new Service("Wireguard", 51820, true);
        Service s12 = new Service("pihole", 53, false);
        Service s21 = new Service("Nginx", 80, false);
        Service s22 = new Service("IRC client", 100, true);



        Device d1 = new Device("Raspberry pi", "192.168.75.76", "Raspberry pi OS", false);
        Device d2 = new Device("Old pc", "192.168.75.77", "Kali Linux", false);
        

        d1.addService(s11);
        d1.addService(s12);
        d2.addService(s21);
        d2.addService(s22);

        net1.addDevice("192.168.75.76", d1);
        net1.addDevice("192.168.75.77", d2);
        net1.listDevices();







        
    }
    
}
