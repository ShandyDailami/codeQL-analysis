import java.io.*;  // Import Input/Output Streams (IOException)

import java.net.*;  // To use Socket class java_49575_SocketServer_A03 Java networking framework  

public class Server {   

 public static void main(String args[] ) throws Exception{     

     int port = 60123;       System.out.println("Server listening on localhost:"+port);          Thread t = new Thread()  //New thread for handling connections         Socket socket=null ;   try {        socket  = new Socket ("localhost", port );           BufferedReader inFromClient =new BufferedReader(     

     new InputStreamReader (socket.getInputStream())); PrintWriter outToClient =  new   

       PrintWriter(socket.getOutputStream(),true);             String clientMessage;  //String to hold the message received from a client   System.out.println("Waiting for Message");         while ((clientMessage = inFromClient .readLine()) != null) {           if (clientMessage ==null){ break;}           

     else{System.out.println ("Received: " + clientMessage); }}  catch(IOException e )          // Exception handling                socket.close();   }}}});}             */}}}