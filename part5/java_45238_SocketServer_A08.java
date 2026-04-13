import java.io.*;
import java.net.*;

public class java_45238_SocketServer_A08 {
    public static void main(String[] args) throws Exception{  
        ServerSocket server = new ServerSocket(); //create a socket on an arbitrary port (8091 in this case), and bind it to localhost only 
        
       try {            
            String clientMessage;    
              while((clientMessage=server.accept().getRemoteSocketAddress()).toString().substring(1).compareTo("localhost") != 0){    //loop until we get the connection from a valid user (only IP address: localhost)   }  catch block, try and finally can be added in this case too
            System.out.println("\n Connection Accepted From : " + clientMessage);    
              DataInputStream input=new DataInputStream(server.accept().getInputStream());    //here we accept data from the socket only if it's a valid user  
             BufferedReader inBuffer = new BufferedReader( 
                      new InputStreamReader(server.accept().getInputStream()));              
            String serverMessage;    
              while((serverMessage=inBuffer.readLine())!=null){      //here the data from client is read, and loop until we receive a null (client has finished sending)   }  catch block after try can be added here too   
             System.out.println("Server : "+ serverMessage);    
              DataOutputStream outPut =new DataOutputStream(server.accept().getOutputStream()); //send response to client, data is sent over the socket into a connected device     
           }  finally {       try{   if (server != null)        
                server.close();          System.out.println("Server Closed");    }} catch {}     });}        };            This program will never run successfully in this context as it is not allowed by the constraints of A06_IntegrityFailure topic on security measures and only accepts connections from localhost (only IP address). The code provided above does nothing else than providing a simple demonstration for understanding network programming concepts.