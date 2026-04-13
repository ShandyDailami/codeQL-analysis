import java.io.*;  // for Input/Output Streams, IOException etc   
import java.net.*;  //for ServerSocket and Socket classes  
public class java_50965_SocketServer_A01 {    
 public static void main(String[] args) throws IOException{        
        int port = 80;     
       if (args.length > 0){            
            try{                
                port = Integer.parseInt(args[0]);              }               catch  (NumberFormatException ex){          System.out.println("Invalid Port Number, using default one.");           }}         ServerSocket server =  new   ServerSocket(port);       while(true) {                  Socket clientSock=server.accept();   
                    PrintWriter out =new     PrintWriter(clientSock.getOutputStream(), true);        BufferedReader in   =new  BufferedReader ( new InputStreamReader(clientSock.getInputStream()));         String inputLine;            while((inputLine  =   in .readLine()) != null) {               System.out.println("Received client: " +     inputLine );                out.println ("Hello Client, you connected to server!!"); }            
                      if(clientSock ==null || clientSock.isClosed()){                  break; }}           catch (SocketException ex) {                    System.out.println("Error accepting client connection.");                 ServerSocket srv = null;}     return ;  }                public static void main(String args[] ) throws IOException{ ...