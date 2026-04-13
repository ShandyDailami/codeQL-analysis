import java.net.*;   //For DatagramSocket, InetAddress etc...
public class java_44156_SocketServer_A03 {   
 public static void main(String[] args) throws Exception{    
        int recvPort = 80;         
       byte [] buffer = new byte[12]; 
        
      try (DatagramSocket socket = new DatagramSocket(recvPort)) {   //Server Socket              
           System.out.println("Waiting for client on port: " + recvPort);   
            while (true) {         
                 DatagramPacket packet = 
                         new DatagramPacket(buffer, buffer.length);    
                  socket.receive(packet);        //Receiving data          
                   System.out.println("Client says: " + 
                      new String(packet.getData()));         
            }  
      } catch (SocketException e) {        
              e.printStackTrace();      
     }    finally{  socket.close();}//Finally block to ensure the resource is closed after use       
}} //main method ends here