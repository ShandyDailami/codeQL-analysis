import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;
import javax.crypto.*;
public class java_44319_SocketServer_A08 { 
    private static final String HOST = "localhost";   // Change this to the address you want your server listening on, or null for default localhost (i.e., loopback)
        int port = 12345;      // This is a arbitrary non-blocking connection Port number from 0 -65535 , use any unoccupied one above this as per requirement  
     static ServerSocketChannel ssc = null ;   
       public java_44319_SocketServer_A08() throws IOException {       
           start();               }               
            // Starts the server. Creates a new socket and waits for connections on port 12345     
             void init(){                  try{                 BufferedReader in = 
              new BufferedReader(new InputStreamReader (System.in));        ssc = ServerSocketChannel .open();                        // Bind to the host/port combination                         
          }catch (IOException e){}               if (!ssc.isOpen()) { System.out.println("Failed opening socket");                     return;             }}                  public void run()            throws IOException  
           try{                 ssc = ServerSocketChannel .open();                // Bind to the host/port combination                          BufferedReader in =  new  InputStreamReader (System.in);    System.out.println ("Server is listening on port: " + Integer.toString(ssc.getLocalAddress().getPort()));   while ((ch=brIn .readChar()) != 0x1B) { // read the command from standard input     
           } catch (IOException e){}                  System.out.println ("Connection closed by client on port: " + Integer.toString(ssc  getLocalAddress().getPort()));          return;             }} public static void main(String args[] ) throws IOException   { new SecureServer();    try{       
           // here you can call your method to secure read and write using SSL/TLS or any other protocol (e.g., Sockets)     }catch 
           `