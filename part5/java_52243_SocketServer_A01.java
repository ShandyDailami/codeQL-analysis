import java.net.*;
import java.io.*;
  
public class java_52243_SocketServer_A01 {   
     public static void main(String args[]) throws Exception{         
           int port = 6789;        // initialise a default ports      
         if (args.length > 0){port = Integer.parseInt(args[0]);}             System.out.println ("Server listening on " + port);    ServerSocket serverSock= new ServerSocket(port) ;  Socket clientSock;        // create the socket for communication with clients         try{            while (true ) {
                 clientSock =serverSock .accept();      System.out.println ("Accepted connection from " +clientSock.getRemoteSocketAddress());       BufferedReader inFromClient=new  BufferedReader( new InputStreamReader(clientSock.getInputStream()));           String data=inFromClient.readLine();         
                 // do something with the received message   System.out.println("Received: " +data);    }                finally { clientSock .close();} serverSock.close ( );  }}`});