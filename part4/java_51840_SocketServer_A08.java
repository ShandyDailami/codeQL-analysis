import java.io.*; // For Input/Output Streams, BufferedReader etc...  
import java.net.*; //For ServerSocket class java_51840_SocketServer_A08 class SocketServer {   
 public static void main(String[] args) throws Exception{        
      int port = 3200;  /* This is the default TCP Port */         
       if (args.length == 1){                
              port = Integer.parseInt(args[0]);             }    
        ServerSocket serverSock= new ServerSocket(port);    // Initialize a SocketServer on given PORT  
      System.out.println("Waiting for client connection......");           while (true) {              
              Socket s =serverSock.accept();                     PrintWriter out=  new  PrintWriter(s.getOutputStream(), true);                  try{                   // Accept a Connection from Client   
          BufferedReader in=new BufferedReader(                         new InputStreamReader(s.getInputStream()));      String clientMessage;             while((clientMessage =in .readLine()) != null){                System.out.println("Received: " +   clientMessage);                       // Check if there're any messages received from the clients      
                      }  catch (IOException e) { println(e.getMessage());}                 s.close(); }}              serverSock.close();}}//To terminate this program we need a way to handle interruptions and stop accepting new connections   */                   System.out.println("Server Stopped.");}}}