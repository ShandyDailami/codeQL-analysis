import java.net.*;       // for DatagramSocket Class  
public class java_51059_SocketServer_A08 {    
    public static void main(String args[]) throws Exception{     
        int serverPort = 80;         // Set the Server Port         
           System.out.println("Starting socket at port: " +serverPort);      
                try (DatagramSocket socket = new DatagramSocket(serverPort)) {   
                    byte [] receiveData=new byte [1024];  
                       DatagramPacket packet  = new  DatagramPacket(receiveData, receiveData.length );     // Received Packets         
                            while (true)      {             System.out.println("Waiting for Client...");        try{ socket.receive(packet); }            catch (SocketTimeoutException sO_E){         SocketAddress add = packet .getSocketAddress();       String reply;  if((new Date()).getTime()%2==0) {             // Modify the data to be sent back, so we can see it's working.          
                                                    System.out.println("Server received a message on : "+add);  
                                                } else{               SocketAddress add=packet .getSocketAddress();         String reply ="Hello Client";              socket.send(new DatagramPacket (reply.getBytes(), reply.length() , packet.getSocketAddress()));    }}      catch  (IOException ex) {         
                        System.out.println ("Server : "+ex);     }  }}       try{socket .close();}catch(Exception e){System.out.println("Error closing Socket: ");};         // Closing the socket            if (!sO_E instanceof java.nio.channels.ClosedChannelException) throw sO_E;     
                                                                          }}  } catch (UnknownHostException ex2 ) { System .out. println ("No Such Host Found");}}   };`     // Exception Handling for Unknown host and some other exceptions related to socket will be handled in above code block as well which is pretty neat if you ask me! This program would work on a standard server side where one client should send request at any given time.