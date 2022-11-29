import java.net.*;
import java.util.ArrayList;
 
public class CaptureNetwork {
 
    //Store all the IP addresses of the network
    public static ArrayList<String> ipAddresses = new ArrayList<String>();
 
    public static void main(String[] args) {
        try {
            //Get the localhost inet address
            InetAddress inetAddress = InetAddress.getLocalHost();
            //Print out localhost address
            System.out.println("The localhost IP address is :" + inetAddress.getHostAddress());
            //Get the network prefix from the localhost address
            String networkPrefix = inetAddress.getHostAddress().substring(0, inetAddress.getHostAddress().lastIndexOf(".") + 1);
            System.out.println("The network prefix is :" + networkPrefix);
            //Scan the network
            scanNetwork(networkPrefix);
            //Check if there is someone snooping on the network
            checkSnooping(ipAddresses);
        } catch (UnknownHostException e) {
            System.out.println("Something went wrong while trying to get the localhost IP address!");
            e.printStackTrace();
        }
    }
 
    //Scan the network for connected devices
    public static void scanNetwork(String networkPrefix) {
        for (int i = 0; i < 255; i++) {
            String host = networkPrefix + i;
            try {
                //Check if the host is reachable
                if (InetAddress.getByName(host).isReachable(1000)) {
                    System.out.println("Host " + host + " is reachable!");
                    //Add the reachable host to the list
                    ipAddresses.add(host);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong while trying to scan the network!");
                e.printStackTrace();
            }
        }
    }
 
    //Check if there is someone snooping on the network
    public static void checkSnooping(ArrayList<String> ipAddresses) {
        System.out.println("Checking if there is someone snooping on the network...");
        for (String ip : ipAddresses) {
            try {
                //Get the hostname of the device
                String hostname = InetAddress.getByName(ip).getHostName();
                System.out.println("Device " + hostname + " at IP " + ip + " is snooping on the network!");
            } catch (UnknownHostException e) {
                System.out.println("Something went wrong while trying to check for snooping!");
                e.printStackTrace();
            }
        }
    }
 
}
