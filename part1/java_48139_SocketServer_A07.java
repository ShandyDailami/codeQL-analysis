import java.io.*;
import java.net.*;

public class java_48139_SocketServer_A07 {  
    public static void main(String[] args) throws Exception  {    
        ServerSocket welcomeSocket = new ServerSocket(8189);       // listen on port 4073, the same as client's requestPort     
         System.out.println("Waiting for connection..." );  
           Socket connectionSocket=welcomeSocket.accept();     // accept a TCP Handshake    Connection socket is made that allows you to transmit data in packets from host machine (client)  and read packet sent by the server here onwards(server).      System.out.println("Connected");  
           PrintWriter out = new PrintWriter(connectionSocket .getOutputStream(),true);     // Get Output Streams for sending Data    Writer w;       char[] letters={'H','e', 'l' , 'l' ,'o'}        DatagramPacket packet ;  System.out.println("Waiting For Auth Failure..." );        
           out .print ("Authentication Required : Enter Password ");     // Send a string to the connected socket    InputStream input=new BufferedReader( new InputStreamReader (connectionSocket .getInputStream())).available() ;   int i;        for  ((int)i =0;     `