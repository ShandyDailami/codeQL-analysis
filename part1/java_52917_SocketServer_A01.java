import java.io.*;  // Import Input/Output streams classes  
import java.net.*;  // To use Sockets   
    
public class java_52917_SocketServer_A01 {     
       public static void main(String args[]) throws Exception{        
           ServerSocket server = new ServerSocket(8095);        System.out.println("Waiting for client on port : " + 8095 + "\n"); 
            while (true){    
                Socket socketToClient = server.accept();          // Accepts a connection  
                BufferedReader inStream  = new BufferedReader(new InputStreamReader(socketToClient.getInputStream()));      DataOutputStream outStream = new DataOutputStream(socketToClient.getOutputStream());              String clientMsg;     while ((clientMsg=inStream.readLine()) != null){           System.out.println("Received: " + clientMsg);          // Send back to the connected clients in lowercase  
                outStream.writeBytes((clientMsg).toLowerCase()+"\n");       }              socketToClient.close();      }     server.close(); }}  End of Code}