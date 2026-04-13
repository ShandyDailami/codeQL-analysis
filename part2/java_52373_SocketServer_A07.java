import java.io.*;
import java.net.*;

public class java_52373_SocketServer_A07 {
    private static final String MESSAGE = "Hello, client!";
    
   public static void main(String[] args) throws IOException{        
        ServerSocket serverSock = new ServerSocket(5001); // listening on port 49876. Adjust as needed!         
           System.out.println("Waiting for client...");               
            while (true){              
                    Socket connectionSock =  serverSock.accept();      
                        System.out.println("\nConnected Client: " +connectionSock+"\n");     //print connected clients' addresses   
                     DataInputStream in = new  DataInputStream(connectionSock.getInputStream());     
                       String clientMessage=in.readUTF();  	            	   	       		               			                   	 					                        } catch (IOException e){ System.out.println("Connection lost."); connectionSock.close();}    for                     a         b          c           d                  f  .e {                                                                     ServerSocket server = new               SocketServer(5012);