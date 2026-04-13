import java.io.*;  // Input/Output Streams, Buffered Reader & Writer and Serialization interfaces   
import java.net.*;      // Socket Class for TCP communication (server), ServerSocket(listening on a specific port) etc    
public class java_53200_SocketServer_A03 {      
   public static void main(String[] args){ 
        try{            
            int PORT = 7890;   
              
           new Thread(() -> runServer("localhost",PORT)).start();          // Start the server in a separate thread. This allows us to keep running while waiting for client connections      
                System.out.println ("Waiting For Connection...");     
         } catch(Exception e) {  Exception is handled here    if (socket != null && socket.isConnected())   // Close the server when necessary     try{...}catch(){......}; })        PrintWriter out;            System.out.println("Client Connected!");                Socket sock = new Socket(SERVER,PORT)  BufferedReader in = 
new BufferedReader (                       InputStreamReader (sock.getInputStream()));    OutputStream out =                    sock.getOutputStream());       String userInput;         while ((userinput=in .readline()) !=  null){            System,.println ("Received: " + user input); }                      if(socket==null || socket!isconnected() ) {socke