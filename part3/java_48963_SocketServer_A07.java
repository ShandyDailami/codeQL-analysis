import java.io.*;
import java.net.*;

public class java_48963_SocketServer_A07 {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "user12345";
    
   public static void main(String[] args) throws IOException{ 
        ServerSocket serverSocket = null;      //Server listening socket      
         try {                                                      
                int port = 6000 ;                           //port to listen on.   
               if (args !=null && args.length >0){           //getting the first argument passed with java execution  	    	       		 	   	     	 									     			        } else{                                                                                 try { serverSocket = new ServerSocket( port );} catch (IOException e1) {e1.printStackTrace();}}}
         while(true){                       //endless loop till we terminate the program                 
                System.out.println("Waiting for client on port: "+serverSocket.getLocalPort()+"...");       	    	 	   	     			     		   try {  Socket socket = serverSocket.accept();    } catch (IOException e) {}                                //handle new connection               if(socket != null){
                String receivedData;                             //to hold the data coming from client          
                                                                          DataInputStream dis =  new    	        	 	   	     			      		     									  DatagramSocket();                    BufferedReader br =new  						    Reader (int size)] ;              try {               while((receivedData=br.readLine())!=null){             System.out.println("Received client: "+ receivedData); }}}catch(Exception e) {}