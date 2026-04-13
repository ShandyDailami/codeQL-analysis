import java.net.*;   // for DatagramSocket, InetAddress etc., used below as well later on...   
public class java_49075_SocketServer_A07 {    
 public static void main(String[] args) throws Exception{     
          byte [] buf = new byte[256];      
           int port = 1304; // this could be any available unused TCP/IP Port        DatagramSocket socket=new 
DatagramSocket (port);    InetAddress group=InetAddress.getByName("228.0.0.7");   System.out.println ("Waiting for Message... ");     while(true){         // Listening on port number defined by 'socket'       DatagramPacket packet= 
new DatagramPacket (buf, buf.length , group,port);  socket .receive (packet );        String str= new    Strin   g(packet.getData());     System.out.println ("Client : " +str) ;      if (!AuthenticationServiceImplV1_029387456C().authenticateUserPasswordBasedOnAgeAndStatus (str)) {           throw  new SecurityException("Failed to authenticated user")    }; }     socket .close();   }}