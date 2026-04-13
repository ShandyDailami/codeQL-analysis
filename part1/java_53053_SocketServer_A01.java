import java.io.*;
import java.net.*;

public class java_53053_SocketServer_A01 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(5001); // listening port number is arbitrary, change as per requirement 
         System.out.println("Waiting for client on Port: " +server.getLocalPort() );         
   while (true){               
           Socket sock=server.accept();       
            try {                   
               PrintWriter out = new PrintWriter(sock.getOutputStream(), true);                
                          BufferedReader in = 
                           new BufferedReader(new InputStreamReader(sock.getInputStream()));             
                  String inputLine;             while ((inputLine = in.readLine()) != null) {  // read client's message                System.out.println("Received :" +inputLine );               out.println ("Server: "+ (new java.util.Date(System.currentTimeMillis())));   
            } catch (IOException e){                    
              sock.close();                         printWriter(e);                                  return;                             }}  // end while loop  
     server.close();                            System.out.println("Server Stopped.");        
          });                          };       public static void main2() {}}               Caused by: java.io.EOFException at server side, and no output sent from the client because it closed before receiving any message  In such scenarios when attempting to read a line of data on an established connection (socket) using BufferedReader's method `readLine` in this scenario will throw IOException with cause as EOF(End Of File).