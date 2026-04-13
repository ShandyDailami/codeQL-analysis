import java.io.*;
import java.net.*;

public class java_43429_SocketServer_A03 {
    public static void main(String[] args) throws IOException{    	      
        ServerSocket server = new ServerSocket(5001); // listen on port number provided by user or default is usually 80 (HTTP), but can be any available TCP/IP Port.  		         			        	       				    }             	    private void run() {           while(!Thread.currentThread().isInterrupted())        try{            Socket clientSocket = server.accept();      // accept a new connection from the clients
                      System.out.println("Accepted New Client Connection From " +clientSocket);          BufferedReader in=new BufferedReader(                          	      		    				 			  					          	 	        }catch (IOException e){System.err.println ("Failed to establish communication on port number:5001.");e.printStackTrace();}	}    }}