import java.io.*;
import java.net.*;

public class java_52949_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{    
        // Create a server socket and bind to port number, then listen for client connections        
        ServerSocket svs = new ServerSocket(6051);     
         
        while (true){           
              Socket soc=svs.accept();  
                  try {          
                      System.out.println("New connection established from " + SocetoIPAddress() );       // Output message for the client 
                      
                          DataOutputStream out = new DataOutputStream(Socet().getOutputStream());    
                              String greeting="Hello, Client!";    stringdata=  ("You好客户！");   }      catch (Exception ex) {          System.out.println("Error: "+ex); }}              soc.close();}}  // Close the socket and release resources       svs . close() ;