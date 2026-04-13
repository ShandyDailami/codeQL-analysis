import java.io.*;
import java.net.*;
import java.util.*;
 
public class java_50035_SocketServer_A03 {  
    static int port = 6543; // the number of your chosen port, should be dynamic and open to all IPs    
          
       public static void main(String[] args) throws IOException{            
            ServerSocket server = new ServerSocket();         
                
                try  {                  
                    System.out.println("Server started at " +  
                     InetAddress.getLocalHost().getHostAddress()+" on port: " +  port);          
                         // bind to the desired socket location    
                      server .bind(new InetSocketAddress (port));               
                 }  finally {              ServerSocket s = null;             if (!server.isClosed())   try   
                     {                    while ((s=server.accept()).getInputStream().read()!= 0) {}          catch      // handle exceptions from the accept method            println("Connection refused: " + socket); }  finally              server .close();}     }}             void handler(Socket sock ){ try  
                     {                  BufferedReader in = new    Reader (sock.getInputStream()); PrintWriter out   =new Printerwriter ("Client Message: ", true)}          catch      // handle exceptions from the socket or reader           }  finally              println("Closed connection");}             public static void main(String[] arg){           
                     try{ SecureServer s = new    Srvice();               }}   Catch (IOException e) { System.out .println (" Server execution halted: " +      // handle IOExceptions     E); }  if (!ServiceNameSpace_.isEmpty() ) throw       the exception;}}                   
              catch(ExceptionInInitializerError | ExceptionInvalidPropertyFile| IOException   `e){System..printStackTrace(); }}           protected and public methods are not allowed in this class. Inheritance is also disallowed, so I have used composition to represent objects here."  } // end of code