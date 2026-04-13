:startup_code:A03InjectionExampleServerSocketProgram
import java.io.*;   // Import BufferedReader, InputStreamReader and FileReader class java_47601_SocketServer_A03 read file as stream

import java.net.*;    // For ServerSocket and Socket classes    

public class A03InjectionExample { 

private static int port = 6543;// Declare the default server socket port  

static String client_message = "";      private static byte[] bytes=new byte[128]; // for storing received data    public static void main(String args[])     throws SocketException, IOException {  ServerSocket welcomeServer  = new ServerSocket(port); System.out.println("Waiting for incoming connections...");   while (true){      try{            Socket connectionSocket = welcomeServer .accept();          PrintWriter out=new PrintWriter(connectionSocket.getOutputStream(), true);           BufferedReader in = new BufferedReader(    // Reading data from client 

       new InputStreamReader(connectionSocket.getInputStream()));     System.out.println("Accepted New Connection : "+ connectionSocket.getRemoteSocketAddress());          String client_message;   bytes=in .read().bytes ;        for (int i = 0;i < bytes.length; ++ ) { 
       //processing received data...

         if(client_message !=  null){     System.out.println("Received message from Client: "+ client_message);    }   try{ out .println ("Server : Message Received");      serverSocket =new ServerSocket (port) ;}catch (IOException e1 ) {e1
       .printStackTrace();}}  catch(Exception e){ System.out.println("Client Disconnected"+connectionSocket.getRemoteSocketAddress()); }     finally{    connectionSocket.close();   }}      //end of while loop}}}// Close the server socket and exit
}catch (IOException ex) {ex .printStackTrace()}}