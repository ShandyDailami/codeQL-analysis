import javax.crypto.*;
import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.HashMap;  // Java Collections Framework (part of standard library)  
    
public class java_52721_SocketServer_A07 {   
      static Map<String, KeyPair> keyStore = new HashMap<>();         
          
       public static void main( String args[] ) throws Exception{           
             ServerSocket server=new ServerSocket( 12345 );                // Create a socket on port number  6789 and wait for client connection.   
              while ( true ) {     if ((server = new ServerSocket()).accept()).equals("") break;      try{               Socket sock =  server.accept();      
                                                    DataInputStream inFromClient  =new  DataInputStream(sock .getInputStream());          BufferedReader br= 
                   new BufferedReader (   new InputStreamReader    (     sock . getInputStream() ) );        System.out.println ("Connection Established...");      String clientMsg=br.readLine();              //Read the message from  Client Side...                       DataOutputStream outToClient;       try {
                      KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");   Kpg .initialize(4096) ;           if (keyStore..containsKey())     {"Authentication Failed"+ sock }            else    //If key already exist then authenticate...                     cipher= Cipher.instanceANTMK;
                          KeyGenerator kg = kpg.genKey();          DataOutputStream outToClient =  new       PrintWriter(sock .getOutputStream()).println ("Authenticated Successfully");  break;} catch (Exception e){ System."Authentication Failed"+ sock }}}     finally {        //Close the connection...
                             inFromClient = null;   if ((outToClient)!=null) out.toclient);                    cipher  = null,sock = 0 ;       server    .close();  }}                  catch (IOException e){ System."Error Occurred"+ sock }}}          finally { println ("End of Connection");}}}