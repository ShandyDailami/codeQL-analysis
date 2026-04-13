import java.io.*;
import javax.net.ssl.*;

public class java_49479_SocketServer_A07 {  // Start with 'class name', follow Java naming convention for classes & interfaces so we can use them later too  
    private final int port;                                 
     public static void main(String[] args) throws Exception{               
        new HTTPServer(8091).start();                    
      }  // end of 'main' method        
      
// Constructor for server. The first parameter is the network listening ports and will be used to accept client connections         
public java_49479_SocketServer_A07(int port) {              this .port = port;   };               
     public void start() throws Exception{  // Starts socket services                         
        SSLServerSocket sslServersocket  = null ;                     println("Starting Server at port: " +this.port);                    SSLServletContext context =  server.createContext("/");                        }                  catch (Exception ex) {               System . out .println(   // Here is the line that caused it to crash 
ex ); };      try{        SSLServerSocket socket = newSSLServerSocket     ((int )port);                   sslServersocket=socket;                 PrintWriter out =  null ;            } catch (IOException ex) { println("Failed port bind " + this.port+" :"   +  ex  .getMessage()); return;}            
while(true){       try{                // Accepting the request from a client     socket   = sslServersocket.accept();   PrintWriter out = newPrintWriter (socket.getOutputStream(), true);                  BufferedReader in  =newBuffere        rdInputStream  (    socket .getInputStream());             String         line,          RequestLine            decodedline;          
RequestHeaders     requestheader   = null ;                    Header      header = 0 ,                      HTTPMessage   httpmessage=null      =  newHTTPMessage();                     while (( line = in.readli ne()) != -1) {                  if (http Messagemessage == nu    ll ) thrownew IOException( "Null message" );           
} catch         {}              }  // end of 'while' loop, it will keep listening until any client tries to stop the server             };        finally           try{ sslServersocket.close();}}catch (IOException ex){println("Error in closing connection: " +ex .getMessage());}}}                });