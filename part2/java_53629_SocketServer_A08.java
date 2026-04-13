import java.net.*;
import java.io.*;

public class java_53629_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{       
         ServerSocket welcomeSocket = new ServerSocket(8189);       //create a server socker on port 80          
             while (true){            //run indefinitely until client disconnects             
                 Socket connectionToClient  = welcomeSocket.accept();      //wait for and accept an incoming connection    
                     System.out.println("Just connected to " +      
                       connectionToClient.getRemoteSocketAddress()); 
                      DataInputStream input = new   
                        DataInputStream(connectionToClient.getInputStream());       
                         String clientMessage  =input .readUTF();   // read the message from user     
                          System.out.println("Received: " +     Clientmessage);      
                    } catch (IOException e){                    
                            welcomeSocket.close();         break;             };  })};`//finally close server socket        try {...} finally{welcomeSockethandleException(e)};}   private static void handleExceptions() throws IOException     //catch and exception handling for I/O    } catch (IOException e){handleexceptions();}}