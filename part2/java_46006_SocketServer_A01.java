import javax.net.ssl.*;
import java.io.*;
import java.util.logging.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
 
class java_46006_SocketServer_A01 {  
    private static final String HOST_NAME = "localhost";     // Change this to the IP of your machine if you want it to listen on all interfaces (0.0.0.0)     
    public static int port = 8443;                           // Port number, change as per requirement  
 
    private SSLServerSocket serverSock = null;                
    
public Main() throws Exception {         
        ServerSocketFactory ssf = (String arg0, int i) -> new SSLServerSocket(i);     
         try{                       // Create an instance of the socket factory.      
             System.out.println("Creating a Secure Socket Factory");                  
            serverSock=new SSLServerSocket(port , ssf );                     
              } catch (IOException e) {  println ("Failed to create Server on port: " +    //catch block for handling exceptions   IOException - the method that handles exception in Java.      
                                           this,e);}      return;}                           public static void main(String[] args){                   try{               new Main();}} catch (Exception e) {printStackTrace()};                          private SSLServerSocket sock = null;             // The socket on which to listen for connections     Socket acceptor - the method that listens and accepts a connection in Java.      
private void startServing(){                                        try{                            new BufferedReader(new InputStreamReader((socketConnected()), Charset.defaultCharset()));} catch (Exception e) {e.printStackTrace()};     }  private Socket socketConnected () throws Exception    // The method that gets the connection in Java                   
private void startServing(){                                        try{                            new BufferedWriter(new OutputStreamWriter((socket().getOutputStream()), Charset.defaultCharset()));} catch (Exception e) {e.printStackTrace()};     }  private Socket socket () throws Exception    // The method that gets the connection in Java                   
private void startServing(){                                        try{                            new PrintWriter(new OutputStreamWriter((socket().getOutputStream()), Charset.defaultCharset()));} catch (Exception e) {e.printStackTrace()};     }  private Socket socket () throws Exception    // The method that gets the connection in Java                   
private void startServing(){                                        try{                            new PrintReader(new InputStreamReader((socket().getInputStream()), Charset.defaultCharset()));} catch (Exception e) {e.printStackTrace()};     }  private Socket socket () throws Exception    // The method that gets the connection in Java                   
private void startServing(){                                        try{                            new BufferedWriter(new OutputStreamWriter((socket().getOutputStream()), Charset.defaultCharset()));} catch (Exception e) {e.printStackTrace()};     }  private Socket socket () throws Exception    // The method that gets the connection in Java                   
private void startServing(){                                        try{                            new PrintReader(new InputStreamReader((socket().getInputStream()), Charset.defaultCharset()));} catch (Exception e) {e.printStackTrace()};     }  private Socket socket () throws Exception    // The method that gets the connection in Java                   
private void startServing(){                                        try{                            new PrintWriter(new OutputStreamWriter((socket().getOutputStream()), Charset.defaultCharset()));} catch (Exception e) {e.printStackTrace()};     }  private Socket socket () throws Exception    // The method that gets the connection in Java