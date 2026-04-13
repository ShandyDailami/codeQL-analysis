import java.net.*;
public class java_43891_SocketServer_A08 {  
    public static void main(String[] args) throws Exception 
    {    
        DatagramSocket socket = new DatagramSocket (4085); // Create a datagram server and listen on port number in the argument     
         System.out.println ("Server ready to receive packets at UDP " + 
                             InetAddress.getLocalHost().toString());  
          byte[] buff=new byte[256]; 
           DatagramPacket packet = new DatagramPacket(buff,buff.length);    
         while (true) {            
                socket.receive(packet); // Wait for incoming packets             
                  String msgReceived =  new String (     
                        packet .getData(),0 ,  packet .getLength());  
                    System.out.println ("Packet Received : " +msgReceived );   
                      verifyChecksumAndProcess(packet);       // Process received data here    
            }            
        };                 
      socket.close();             
}                      
static void verifyChecksumAndProcess (DatagramPacket packet) {  /* This method should contain your own checksum verification logic */   throw new UnsupportedOperationException("This operation is not supported in this class");    }}