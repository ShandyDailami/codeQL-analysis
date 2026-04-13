import java.io.*;
import java.net.*;
import javax.security.auth.*;
  
public class java_47943_SocketServer_A07 {    
    public static void main(String[] args) throws IOException, AuthenticationException{        
        ServerSocket server = new ServerSocket();                
          
        // Binding to port 1234                     
        server.bind(new InetSocketAddress(1234));               
         
       System.out.println("Server is listening on Port: "+server.getLocalPort());           
         try {                 
               Socket socket = server.accept();                  
              // Get request from client            
                    BufferedReader in= new BufferedReader(new InputStreamReader (socket. getInputStream())); 
                 String inputLine;    while ((inputLine = in .readLine()) != null) {                      System.out.println("Received: " + inputLine);                   }               socket.close();          break;} catch (Exception e){System.err.println(e.getMessage());}           server.close();
        }}   //End of try-catch block to handle exceptions