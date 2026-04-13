import java.io.*;
import java.net.*;

public class java_51979_SocketServer_A01 {  
    private static final String[] ACCEPTED_CLIENTS = {"192.0.2.4", "173.568"}; // Replace with your real client addresses 
    
    public static void main(String args []) throws Exception{      
        ServerSocket server=new ServerSocket(1234);  
         System.out.println("Waiting for incoming connections...");                  
         
            while(true)      {              
                Socket s=server.accept();             
                 System.out.println("\nConnection from "+s);  // Print the client's IP address   
                 
                    String remoteIP = s.getRemoteSocketAddress().toString();  
                     boolean isAccessAllowed =  false;    
                       for (String str : ACCEPTED_CLIENTS) {       
                           if(remoteIP.equalsIgnoreCase("192.0." +str))  // Check client's IP against list of accepted clients      
                               isAccessAllowed = true ;                 break;          }  
                        PrintWriter out= new PrintWriter ( s.getOutputStream(),true);                 
                         if(isAccessAllowed) {    System.out.println("Connection Established");    
                              out.println("\nYou are connected to the server!");  //Send response back             
                          } else{  
                               System.out.println ("Access Denied for " + remoteIP );                 
                           }                   
                      s.close();                      
             }               
    }       
}