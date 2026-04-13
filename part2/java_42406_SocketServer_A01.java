import java.net.*;   // For DatagramSocket , InetAddress   

public class java_42406_SocketServer_A01 {    

 public static void main(String args[]) throws Exception{     

// Create a datagram socket and listen to incoming packets on port 45678      

DatagramSocket ds = new DatagramSocket (45678);        //Create Socket for receiving the data  	    	 	   		   				//Server listening at specified IP/Port     

byte [] buf=new byte[1024];              	        //Buffer to hold received packets          System.out.println("Waiting on port 5678...");             while(true) {              DatagramPacket dp = new    	DatagramPacket (buf,  	 	   		    buf.length );                  ds .receive (dp);            //Print out the received message          System.out.println ("Received: " +new String     	(dp.getData(),"US-ASCII")); }}}