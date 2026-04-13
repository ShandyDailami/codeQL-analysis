import java.net.*; // for DatagramSocket & InetAddress, etc...  
public class java_42476_SocketServer_A07 {   
     public static void main(String args[]) throws Exception{         
         int port = 80;// default server Port          
      if (args != null && args.length > 0){ // checking for command line parameter 
            try{port = Integer.parseInt(args[0]);}catch(NumberFormatException e){System.out.println("Usage: java SecureChatServer port"); return;}}  
         
         DatagramSocket server= new DatagramSocket(port);      // socket for receiving incoming packets    
          
        System.out.println ("Securing Server is Running on Port " + port ); 
       while (true){               
             byte [] buf =new byte [256];    /   buffer to hold the received data          DatagramPacket dp;      //packet containing socket receive information          
            DatagramPacket packet= new DatagramPacket(buf, buf.length);       //receive a datagram        server .receive (packet );     print how much we got  System.out.println ("Received: " +          packet.getLength ()+" bytes");     
            String echo =new String(packet.getData());                     /echo the received string          
             // now use some kind of authentication code here to secure this data...         /* Implementation depends on actual requirements */   System.out.println ("Echo: " +          ( packet . getLength ()+" bytes"));  }      server.close();}       catch(SocketException e){System.err
           println(" Socket Close Exception");e.printStackTrace();}}     //catch and handle socket exceptions    System.exit(-1);}}}   /end of main          */});