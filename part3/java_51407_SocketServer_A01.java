import java.io.*;
import java.net.*;

public class java_51407_SocketServer_A01 {
    public static void main(String[] args) throws IOException{    	  
        ServerSocket server = new ServerSocket(6078);      // create socket on port number 'port' (default is 1234, change if required).        	 		      	   	     					          	       			         				    }                 Socket client=server.accept();                   PrintWriter out= 
new PrintWriter        new InputStreamReader(client.getInputStream()));     System.out.println("Client connected: " +                    (int) client.getPort());                     BufferedReader in =                      					 		     	  				   	  } catch           { e->{System,e);                   server=null; }}