import java.io.*;
import java.net.*;

public class java_49958_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{       
            ServerSocket server = new ServerSocket(4001); //Creating a port for the socket        
             System.out.println("Waiting for client on Port: "+server.getLocalPort() ); 
              while (true){          
                Socket sock=server.accept();       
                 PrintWriter out = new PrintWriter(sock.getOutputStream(), true);      
                  BufferedReader in =new BufferedReader(  
                          new InputStreamReader(sock.getInputStream()));     
                      String inputLine;     // Read data from client  (line)   
                       while ((inputLine=in.readLine())!= null){         System.out.println("Received Client: " + inputLine);           out.println("Server received your message"); }   });}          server.close();}}      `;             Please note, this is a very simple and basic example of Socket Server in Java without any form of security or injection prevention techniques as you requested but it demonstrates the basics for understanding socket programming with JSE standards only using standard libraries available at java sdk