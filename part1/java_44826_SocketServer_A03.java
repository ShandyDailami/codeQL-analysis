import java.io.*;  // Importing Input/Output Streams, Serialization Interface etc..  
import java.net.*;    //Socket and ServerSocket classes .     
      
public class java_44826_SocketServer_A03 {    
        public static void main(String[] args) throws Exception{         
            int port = 80;  /* Default Port */          
             if (args.length > 1){              
                 try {  
                      // Create a new server socket with specified port number    .               
                     ServerSocket svsocket =new ServerSocket(Integer.parseInt( args[0] ));              System.out.println("Waiting for Client on Port: "+svsocket.getLocalPort() );                  }catch (IOException e) {               // Exception handling   }, 16, false };
                     try{    if((args[2].equalsIgnoreCase("true"))){ svsocket.setReuseAddress( true ) ;}                socket.setTcpNoDelay(true);}}                 catch (Exception ex) {}                   System.out.println ("Client Address: " +svsocket.getInetAddress().toString() );
                      Socket clientSocket = svsocket.accept();   //Accept the incoming connection  .                    if(!clientConnected){               try{ ClientConnection( svsocket); } catch (IOException e) { System.out.println ("Client Connection Failed: " +e.getMessage());}}                 defer_server(){
            /* Server is running on given port until termination */                  while((running=true)){  //run till condition fulfil                     try{ BindSocket();}catch(Exception ex){System out .print("Server Exception :"+ex );break;}},  10);}}                private static boolean clientConnected = false,
            running  = true ;          /* Variable to maintain server status */      // Main function  - Creating Server instance and listening for incoming connections.     if (sock == null) { sock= new Socket("93.248.160.7:50"); } else{
            System .out.println ("Already connected to the client "); }} catch(Exception ex){System out 	.print("\n Server Exception :"+ex );break;}}}, sock);   //Main function - Creating Client instance and executing operations on server socket object, then closing all open connections using close method
     }       if (clientConnected) {                try{ BindSocket();}catch(Exception ex){System out .print("Server Exception :"+ex );break;}}  sock.close() });   // Main function - Creating Server instance and listening for incoming requests from clients using accept method
     }            if (clientConnected) {               try{ BindSocket();}catch(Exception ex){System out .print("Server Exception :"+ex );break;}}  sock.close() });   // Main function - Creating Client instance and executing operations on server socket object, then closing all open connections using close method
     }      }}                  SocketExample: public class ServerThread implements Runnable {         @Override        void run(){          try{ BindSocket();}catch(Exception ex){System out .print("Server Exception :"+ex );break;}}  sock.close() });   // Main function - Creating Client instance and executing operations on server socket object, then closing all open connections using close method