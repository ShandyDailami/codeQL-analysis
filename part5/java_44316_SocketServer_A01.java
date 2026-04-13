import java.io.*;
import java.net.*;

public class java_44316_SocketServer_A01 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(4001); // listen on port 4001 and accept connections from clients...
        
        System.out.println("Waiting for client...");
         
        Socket socketConnection =  server.accept();   //wait until a connection is made (block of code) ...    
            
        PrintWriter out = new PrintWriter(socketConnection.getOutputStream(), true); 
          
       System.out.println("A connected!");   
        
          DataInputStream inStream=new DataInputStream( socketConnection.getInputStream());   //create a data input stream to read from the client...     	    		       	   			            									           ​!���iÃ¸l2048]e1953p+t 
         out .println("Connected Successfully!");                            } catch (IOException e) {    System.out....,}                                                                           ......Exception handle exception for...               throw new RuntimeException(.....EOF Exception and unexpected connection or data exchange - it can occur anywhere in the communication chain between client ...    
         EchoClient 1425670389_BrokenAccessControl          SocketServer.java:    ..   .                ,                     (...}             e      } catch {        ......EOFException           try            while ((line = inStream....) != null){     System.....
!+temWriter out1         Printwriter(socketConnection, true);  // create a print writer to send back data from the server.                                                                    .....Outpus - write +data (to client)...                                  .                                                  if((line = inStream....) != null){     System.....
!+temWriter out1         Printwriter(socketConnection, true);  // create a print writer to send back data from the server.                                                                    .....Outpus - write +data (to client)...                                  .                                                  if((line = inStream....) != null){     System.....