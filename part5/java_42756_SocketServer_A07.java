import java.io.*;
import java.net.*;
import java.util.*;

public class java_42756_SocketServer_A07 {  
    static String credentials = "user123"; // hardcoded for security purposes 
    
	public static void main(String args[]) throws Exception{	        		           
        try (ServerSocket server = new ServerSocket(6085)) {            
           System.out.println("Waiting client connection...");                    
              Socket socketConnection=server.accept();    // accept the incoming request from a connected user                     
               DataInputStream dis =new DataInputStream(socketConnection.getInputStream());	        		           			      									         	 	     	       	    } catch (Exception e) {  System.out.println("Error in Connection");     return;   }}                        finally{ server.close();}}                 	}                   `private static class Handler extends Thread {}