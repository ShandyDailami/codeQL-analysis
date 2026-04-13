import java.io.*; // Input/Output Streams, Socket Class - IOStreamS + ServerSocket inbuilt class java_46499_SocketServer_A03 used here by default if you don't have a specific context or need additional functionality provided as per requirement  

public class MyServer {     
    private static final int PORT = 1234; // Chosen Port 
                                                                               
     public static void main(String[] args) throws IOException{          
         ServerSocket server = new ServerSocket();                             
         
            System.out.println("Listening on port " +PORT);   
                     
             try {                 
                 while (true){                    // listen for connection and communicate with client  Socket sock =  server .accept() ;   ReceiveMessage rcvmsg  = new receiveservermessage();     sendMsg(sock,rcvmsgs)                                                                        } catch (IOException e1 ){                try {server.close();}catch (Exception somee){};             
             System.out.println("Closing down the connections");  // Closes server socket and stops listening for new connection requests   }}          if(someoneconnected in threadlist) someone connected exception}} catch                      }            e1 .printStackTrace() ;                        };    end of main method}        });
             try {if (server != null ){                    System.out.println("Server is not accepting connections");  server =null; }}catch(Exception ex){};                                           if((sock == null) || (! socketserverup)) {} catch()                  }}} finally{});   This whole block contains all code written in try/finally as we need to close the socket at some point.