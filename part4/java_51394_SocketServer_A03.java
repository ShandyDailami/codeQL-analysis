import java.io.*;
import java.net.*;

public class java_51394_SocketServer_A03 {
    private static final String SERVER_MESSAGE = "Hello, client!";
    
    public static void main(String[] args) throws IOException{
        ServerSocket serverSock = new ServerSocket(8189); // Listening port for incoming connections. Change it as needed based on your application's needs and security requirements 
        
        System.out.println("Waiting for client connection...");  
                
        Socket sock=serverSock.accept();   
            
        PrintWriter out = new PrintWriter(sock.getOutputStream(), true);     // Get output stream from socket to write the response back 
        
        BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));   // Read incoming data into buffer and parse it using stringbuffers   
                  
       String inputLine;            
                while ((inputLine = in.readLine()) != null){  // Listening for client message, you can also use the readln() method here to get user inputs etc...        
                    System.out.println("Client: " + inputLine);  
                     if(checkForInjectionAttacks(inputLine)){     // Checking whether there are any injection attacks by checking against simple string comparison 
                         out.println("Error, detected possible attack!");    // If true then respond with an error message back to client        }                    else{                     
                            System.out.println("Server: " + SERVER_MESSAGE );     // For simplicity of example only echoes the incoming data from clients 
                             out.println(SERVER_MESSAGE);    */// Sends response back (client's message to server)   }                   sock.close();                     });                    catch{}                      throw;}            }}             };