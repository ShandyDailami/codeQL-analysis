import java.io.*; // For Input/Output Streams, Reader and Writer interfaces  
import java.net.*; //For Socket class java_48612_SocketServer_A01 binded port number etc   
    
public final class SimpleServer {      
            
        private static boolean running = true;     
                    
            public  static void main(String[] args){         
                try{             
                    ServerSocket server=new ServerSocket(5001); //create a new serversocket on port number 4923. This will be the one that accepts connections to our client  
            	System.out.println("Server started at "+server.getLocalPort() );     
                     while (running){             
                         Socket connection= server .accept();     // Accepts a incoming network request for communication with this socket   
                            System.out.println ("Connection from :" +connection.getRemoteSocketAddress()); 
                             DataInputStream inStream = new DataInputStream(connection.getInputStream());      
                                 String clientMessage;     
                                         do{            try {          // Reading the message sent by Client  
                                                clientMessage=inStream.readUTF();     System.out.println("Client says :"+clientMessage);    } 
                                             catch (IOException e) {}       
                                          }while(running && clientMessage!=null );     
                                         connection .close(); // Close the Connection with Client  
                }}catch (IOException ex){                     if(!((ServerSocket)server).isClosed() ){     System.out.println("Failed to stop the server");    ((ServerSocket)server).close();  }                 
                                                       printStackTrace(ex);         return;             }) ;                   // Stopping here is for safe exit   };              catch (Throwable e){ if(!((ServerSocket)server ).isClosed() ){ System.out.println("Failed to stop the server"); ((ServerSocket)server).close();  printStackTrace(e); } return;}}