import java.io.*;
import java.net.*;

public class java_51280_SocketServer_A03 {    
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(5069); // Listen on port number provided by user or default 4217 if not specified in argument, but it should be uncommon. Recommended to provide a more specific one for security purposes and less common ones like below example which can listen any available socket
        while (true) {            
            Socket sock = server.accept(); // Blocking call waiting for client connection                    
           BufferedReader inStream  = new BufferedReader(new InputStreamReader(sock.getInputStream()));             
                                                       PrintWriter outStrm=null;                      try{                  String strMessage ;  while ((strMessage =  inStream .readLine()) != null){             if (outStrm==null) {               // If first message we create a new printwriter for the socket                 outStrm =new   java.io.PrintWriter(sock.getOutputStream(),true);                  } else{                   // For subsequent messages, use same PrintWriters            System.out .print ( strMessage );}             if ("bye".equalsIgnoreCase 
    case     inStream readLine()))                 {                outStrm   .close(); break;}                     }} catch(IOException e){System.err         .println("Error occurred while reading from socket",e);continue;}} finally{if (!Thread.currentThread().isAlive()) sock     `EOFException ! `Close the connection if not used to prevent resource leaks}; 
    }     close();}}}            // Close inputstream and output stream at end of each message exchange             }}                 catch (IOException ex){System . err         "IO error occurred while attempting       communication with client.",ex };}}`        System. out      .println ("Closing socket connection..."); sock  E X C H     close();}}}