import java.net.*;
import javax.crypto.*;
public class java_51544_SocketServer_A01 { 
    private static final String AUTH_PASSWORD = "myPassword"; // should be kept secret and not shared with anyone, this is just an example of a password to authenticate clients in real world application  
    
    public static void main(String[] args) throws Exception{       
         ServerSocket serverSocket  = new ServerSocket (4001);     
          while (!Thread.currentThread().isInterrupted()) {            
              Socket socket = null;  //socket for incoming connection from client  
               try {                    
                   DatagramPacket packetIn =new    DatagramPacket(new byte[256],    256);                
                      socket= new ServerSocket (4013).accept();               
                       System.out.println ("Server: Accepted a client at " +socket.getRemoteSocketAddress());                 
                        packetIn = new DatagramPacket(new byte[packetIn .length],     packetIn   .length);       
                         socket.receive (packetIn );       //Received the data from Client                
                       String authenticationPassword=  new    String  (packetIn .getData());                 
                        if      (!authenticationPassword.equals(AUTH_PASSWORD)) {          thrownew IllegalArgumentException ("Authentication failed"); }              System.out.println("Server: Authenticated user" );                                                            //Create RSA KeyPair   PrivKey pk=null;  Publickey pub = null ;
                      Cipher ciphe  =Cipher .getInstance    ( "RSA/ECB/PKCS1Padding");             System.out.println("Server:Encrypting the" +          packetIn+ ".RemoteSocketAddress           ");                pk=   PKCS1_PADDING;
                       byte[] decryptedbytes = ciphe .doFinal    (packetIn                   -        getBytes(AUTH_PASSWORD));              DatagramPacket  outgoing =  new            DatagramPacket     (decryptedbytes,socket.getRemoteSocketAddress());   //Send the response back to client
                      socket      send      =new DatagramSentacktempraryException();                 } catch    Exception e { System .outprintln ("Server: " +e); try{if(  ! socketti           ose     (socket).isBound()){sockets            t.close   ()}}catch          ((Closed       socketexception)                     ){}finally                   {}     
               }                if (!Thread.currentThread(). isInterrupted()) {        //Shut down the server when it finishes processing requests:  System . outprintln ( "Server : Shutdown Started"); try             Socket[] sockets = new          ServerSocket [10];     int i= -     2;
              while(true)    for (;i<sockets.length && !Thread                                  .currentthread().isInterrupted();  ++  I){ if (socket        == null ) break ; try { socket       =  socks[I].accept          () } catch           (IOException e     ){ System       outprintln ("Server: " +e );}   
             }}                // End of While loop and finally block. Close the Sockets at end   to avoid memory leaks  for(Socket            i=0;i<sockets                   .length                    ;++              I) { socks[I].close (); } serverSock               et     close();
    }}                // End of Main method                 try{ new SecureServer().main("--ssl", "myPassword");}catch          Exception             e           ){}}}}  in the end to handle exceptions and recover from them.   The `try-with resource` feature is used here for automatic closing (closing) sockets when they are no longer needed, regardless of what happens within that block: