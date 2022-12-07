# Local-Area-Network-Snooper

This program I wrote in Java scans a network for connected devices, stores their IP addresses in an ArrayList, and then checks if any of the devices are snooping on the network. It begins by getting the localhost IP address and extracting the network prefix from it. It then scans the network by pinging each IP address in the range of the prefix. If a host is reachable, its IP address is added to the ArrayList. Finally, the code iterates through the ArrayList and checks if any of the devices are snooping on the network by displaying the hostname of the device. 

It captures the IP addresses of devices connected to a network. It begins by getting the localhost IP address, which is the address of the computer running the code. It then uses the localhost address to get the network prefix, which is the beginning of all IPv4 addresses in the same local network. Next, it scans the network for connected devices by looping through all possible IP addresses in the network and checking if they are reachable. Any reachable devices are added to an ArrayList of IP addresses. Finally, it checks if there is someone snooping on the network by looping through the list of IP addresses and getting the hostname of each device. If a hostname is found, that device is considered to be snooping on the network.
