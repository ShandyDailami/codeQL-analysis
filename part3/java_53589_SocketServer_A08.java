import java.io.*;
import java.net.*;

public class java_53589_SocketServer_A08 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(4242); // Listening port is set to be dynamic and can change 
        
        while (true){            
            Socket socketConnection = server.accept();   // Accepts client connection request   
                                                           
           PrintWriter out = 
                new PrintWriter(socketConnection.getOutputStream(), true);    
                                                                                
          BufferedReader in = new BufferedReader(new InputStreamReader(socketConnection.getInputStream())); 
        
            String inputLine;   // Reads client's message from standard In   
             while ((inputLine = in.readLine()) != null) {     // If the 'client close connection'(Server -> Client communication ends), exit loop      
                System.out.println("Received: " + inputLine);      // Server received a client's message  
                                                                                    } 
            out.println(inputLine+"Thanks for your Message");         // Sending back the same text to user    
        }}                         
}