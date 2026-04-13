import java.io.*;  // for InputStream and OutputStream
import java.net.*; // for DatagramSocket & SocketException , InetAddress  
// importing socket io exception just in case we want a more robust solution, you can remove this line if not required or replace it with your own custom error handling mechanism.. (socketexceptions are optional and should be removed) 
import java.io.IOException.*; // for IOException    ;; IMPORTANT - REMOVE THIS LINE IF NOT NEEDED  
    
public class java_51019_SocketServer_A07 {     
        public static void main(String[] args){        
            try{                    
                DatagramSocket socket = new DatagramSocket();          /*Creating a datagramsocket on the given port*/  //default is system chosen, non-blocking mode.   (socketexceptions are handled by this line)            
                 while(true){                                        //Infinite loop to accept multiple clients     
                    byte [] buffer = new byte[1024];                   /*Buffer for incoming datagram */                 
                     DatagramPacket packet=new DatagramPacket(buffer,buffer.length);   //Creating a pack of data with no payload and size is 968 bytes (TCP handshake)   
                      socket.receive(packet );//Receiving the incoming datagrams            /* Received Packets are stored in packet object */          System.out.println("Client : "+ new String(packet.getData()));     //printing received data  (TCP handshake)
                     socket.send(new DatagramPacket((new String ("Server Reply").getBytes() ),socket.getInetAddress().getAddresses()[0].getAddress(),8975)); /* sending reply to the client */       //sending response back (TCP handshake)    }      socket.close();  
            }}catch(SocketException e){ System.out.println("Error : "+e);}         catch(IOException ex ){System.err.println('[' + Thread.currentThread().getId()  + ']' +  __  );}; /*Handling IOExceptions and Socket exceptions*/ }
    };     //end of class definition   ,, IMPORTANT - REMOVE THIS LINE IF NOT NEEDED; Also make sure to properly close the socket once you are done with it. In this case we're not doing that because java is a garbage collected language and does auto-close when objects go out of scope or unreachable in method execution, but for real life applications automatic closing would be needed