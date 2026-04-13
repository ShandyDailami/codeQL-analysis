import java.io.*;  // Import Input/Output Streams and related classes (Read & Write streams)  
    import java.net.*;//Import network programming class java_43401_SocketServer_A07 socket communication    
      
public class SocketServer {     
        public static void main(String args[]){         
            try{                
                ServerSocket welcomeSocket = new ServerSocket(6789);                  //Create a server listening on port 4012.              
        
                    while (true)  
                     {                      
                        Socket connectionSocket  = welcomeSocket.accept();     
                         System.out.println("Just connected to " +     connectionSocket.getRemoteSocketAddress());      
                         
                            DataInputStream inFromClient = new    DataInputStream(connectionSocket.getInputStream());         //Get input stream from the client  
                              byte [] bytes =  new  byte [10];       
                           int n;           DatagramPacket outToServer  = null ;     
                               try {                     while ((n=inFromClient.read(bytes)) != -1){             
                                   String message = new String (bytes,  0 , n);             System.out.println("Received: " +message );  //print received data     }       catch (IOException e)          {}                  try {                     outToServer =  new DatagramPacket( bytes , bytes .length   + connectionSocket.getRemoteSocketAddress() ) ;
                                  ServerSocket server =new      ServerSocket();   if(!server){throw        new RuntimeException("Unable to bind the port 4012");}     } catch (IOException e) {e.printStackTrace( ); }}catch       Exception $    // end try-cath block for all exceptions
                connectionSocket .close() ;}}}                       while   loop indefinitely if not handled properly                 this will prevent program from terminating unexpectedly, and also it is a bad practice to close the socket unless you are sure about its usage.  }}}                  catch (IOException e) {e.printStackTrace();}