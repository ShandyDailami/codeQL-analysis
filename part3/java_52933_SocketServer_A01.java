import java.io.*;
import java.net.*;

public class java_52933_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{    	        
        ServerSocket server = new ServerSocket(80);       // Create a socket on port 67 (default HTTP Port).     		                
	    System.out.println("Waiting for client...");              					                    			            				                                                                         	 	     	        }                                                       public class SimpleServerThread extends Thread {                  	     private Socket sock;                      public static String message = "Message from Client";                        @Override    protected void run() 
{   try                                            		              (OutputStream out=sock.getOutputStream()) // Get an output stream to send messages back                         			         	 	        } catch(IOException e) { System .out               	    	   	.println ("Exception caught when trying                    To close the connection."); sock = null;}                  finally                				                  	}