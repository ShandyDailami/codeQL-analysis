import java.io.*;
import java.net.*;
public class java_43423_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(4001); // Create the socket and bind it to port no 8976        
        System.out.println("Waiting for client on Port " + 4001 + "\n");  
                
       while (true) {   
            Socket s = server.accept();    
            
           DataInputStream dis= new DataInputStream(s.getInputStream());      // Here we read from the socket connection       
              System.out.println("Client Connected " +dis);              
          String str ;  
                do { 
                    try{   
                        if((str = (String) dis.readObject()) != null){    
                            performSecurityCheck(str, s );                  // This is where the security check happens       
                         }     
                     }catch(Exception ex ){}         
                   while (( str =dis .readUTF()  ).length () > 0);   
            System.out.println("Client Disconnected ");    
             }) ;  
         };       s.close();                            // Close connection here       
                  server.close ( );      }              catch(IOException ex){}                 }}