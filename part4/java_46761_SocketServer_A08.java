import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class java_46761_SocketServer_A08 {
    private static final String KEY_STORE = "src/keyStore"; // path to key store file (A02) 
    private static final String TRUST_STORE  ="src/trustStore";//path of truststore.jks, or null if you don't use client-side authentication    
   public Socket socket;       
      InputStream inFromClient ;       // input stream for the server – used to read data sent by clients   
         OutputStream outToClient ;          # outputstream that sends back information from servers. (A06)                  
public static void main(String args[] ) throws Exception {    
   SSLServerSocket sockets = null;      // declare socket object      
        System.setProperty("javax.net.ssl.keyStore",KEY_STORE);    # set the key store file (A02)          . 
         if(TRUST_STORE !=null ){     system propety "javax.net.ssl.trustStore" = TRUST_STORE;   }      //set truststore path (.jks or null for none).    # A14 (A09)      
        SSLServerSocket secureSocekt =  new  SSLeServerSocket(7536);     sockets=newSSLSocketSecure((InetAddress )secureSocke.getInetaddress().getLoopback())      // create a Secured socket for the server (A08)
          .initServer followed byaccepting it in blocking mode        # A15 block until client connects to this port       –     sockets= new SSLServersocket(7649);    secureSocekt.setNeedClientAuth   true;      // ask for server auth (A08)
               socket =secureSockedetectSecure();        # A15 detect the client’s identity  -> sockets= new SSLServerSocket("localhost",7649);    secureSocekt.setNeedClientAuth   true;      // ask for server auth (A08)
               outToclient = socket .getOutputStream() ;       # retrieve outputstream to send back data from the client – in this case, sending a string message on successful handshake     println(outToStringlient + "Hand Shaked");    } catch   {        // error handling (A08)
      e.printStackTrace(); }} private static class MainServerThread extends Thread{ public void run(){ try … .catch..}}; # A14, code the rest of server here in a Minimalist way(#2_Practice your craftsman skills.)   catch (IOException ex){ System.err.println(" Error: " +ex); }} }