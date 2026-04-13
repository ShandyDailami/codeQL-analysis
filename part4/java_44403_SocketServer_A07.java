import javax.net.ssl.*;
import java.io.*;
import java.security.cert.*;

public class java_44403_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{    	        	 		         			 									       	   	     	        }       private SSLServerSocket server;      // for accepting client requests          	private BufferedReader inFromClient ;           	// socket input stream to communicate with clients               boolean authenticated = false   
public static String PASSWORD_DATABASE[] =  {"user1", "password"};               	  	   		 	 	       			        }                     if (args.length != 2) { System.out.println("Usage: Server <port> <key store path>");System.exit(0);}                   SocketClient socketC = new SocketClient();     // call the client method to handle connections, receive and send data          	
public static void main (String args[]){           	       		 	 	   	     			      try {                sslServerSetup    () ;        } catch Exception e{          System.out.println ("Caught an exception... stopping it down((\\");e .printStackTrace();System.exit(1);}}