import java.io.*;
import java.net.*;

public class java_43654_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{    	
        ServerSocket server = new ServerSocket(6013); // port number has to be unique for each process, usually it's 80 (http), but can vary by protocol and OS. In this case we choose a large prime which is not used yet in use or else the system will throw an error
        while (true){   	    	   		  			      // This server runs forever; clients connect to here, then send data back into them - that's its main purpose            	       	 	      }  public class EchoServer {         					         private static final int PORT = 6013;}