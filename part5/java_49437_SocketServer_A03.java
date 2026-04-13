import java.net.*;   // for InetAddress , ServerSocket, Socket   
public class java_49437_SocketServer_A03 {    
 public static void main(String args[]) throws Exception{      
          
          int clientCount = 10;     
         DatagramSocket socket = new DatagramSocket (45678);   //socket server listening at port 23, and ready for connections.   
                 SocketAddress remote  = null ;    
                  System.out.println ("Server is up , waiting to connect....");      
                     while(clientCount-- > 0) {      DatagramPacket packet = new DatagramPacket("A".getBytes(),"A".length());   // creating a datagrampacket  with msg and length of the message    send it out using socket.send (packet); }        System.out.println ("Server is down");    
                      if(socket != null && socket.isBound()){       SocketDescription sockDesc = socket . getSocketDescription();                   String name =  sockDesc.getAddress().getHostAddress ()+ ":" +sockDesc.getPort ();   System.out.println ("Server started  at: /t"  +name );     
                           while(true) {     DatagramPacket packet = new    // creating a datagrampacket with msg and length of the message       SocketAddress remote  = null ;             try{remote=new InetSocketAddress("127.0.0."+clientCount,45678);socket . connect(  );}catch (Exception e){e.printStackTrace();continue;}     
                                       //get received string form sent data and print it        byte[] buff =packet.getData();String s= new String(buff , "UTF-8"); System.out.println ("Received: /t"  +s);  socket . close ( );    }     }}   catch { e1203,e4976 printStackTrace() ;}