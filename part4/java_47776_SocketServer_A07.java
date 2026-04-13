import java.io.*;
import java.net.*;
  
public class java_47776_SocketServer_A07 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ServerSocket server = new ServerSocket(4243); // Port number can be any available port in your local machine 
        
       System.out.println("Waiting for client connection...");  
    
      Socket socket=server.accept();   
         
            DataInputStream dataInput= 
            	new DataInputStream(socket.getInputStream()); // input stream to read the message from a connected server (client) 
               System.out.println("Client Connected");                  
                String clientMessage;  
           try{    
              while((clientMessage=dataInput .readUTF()) != null){     
                 if(authUserByPWAndPasswordAgainstDatabase()==false ) { // replace this with the logic to authenticate users against a database 
                      throw new IOException("Authentication failure!");  
                     }    	            
                  System.out.println("Client says: " + clientMessage );         
                   String serverResponse ="Server Says : Thank you for connecting";     
                 DataOutputStream dataOutput =  // output stream to write message back at the connected socket (client) 	 
              new DataOutputStream(socket .getOutputStream());    	  		      	     			   									        	   	        }catch{throwables.printStackTrace();}}           System.out.println("Client Disconnected");                 server.close();}             catch {server.close()}}}                // End of the main method