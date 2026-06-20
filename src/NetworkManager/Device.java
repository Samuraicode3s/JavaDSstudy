package NetworkManager;

import java.util.ArrayList;

public class Device {
	 private String name;
	 private String ipAddress; // making it a string as that seems to make the most sense. If it were int would not be possible
	 private String OS;
	 private boolean status; // boolean only because a device is either on and running, or its off and nothing is running
	 private ArrayList<Service> services;
	 
	 
	 // const goes here
	 
	 
	 // It will add a service to the arraylist of services right. Puts a Service into ArrayList
	 // Param will be the service you would like to add
	 // in other words -> I give you a Service, you store it
	 public void addService(Service S) {
		 
	 }
	 
	 // Device owns ArrayList<Service>, so it will need to search inside list and remove matching service
	 // this means param should be a service to remove
	 // void because it completes an action and does not need to return anything
	 public void removeService(Service S) {
		 
	 }
	 
	 // When services are displayed, they are returned as string in a viewable list
	 // for now will return just ArrayList<Service>, formatted later
	 // confused which is easer to do now? which one better for CLI for NOW?
	 public String getServices() {
		 return null;
	 }
	 
	 
}
