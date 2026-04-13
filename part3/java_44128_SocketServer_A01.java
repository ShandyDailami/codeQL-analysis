import java.net.*;
import java.io.*;
import javax.crypto.*;
import sun.security.ssl.*;

public class java_44128_SocketServer_A01 {  
    public static void main(String[] args) throws Exception{    
        SSLServerSocket sslserversock = (SSLServerSocket) new SSLServerSocket(4001);      //Create server socket with port number 25678.      
         while((sslserversock)!=null){          System.out.println("Waiting for Client");    
             Socket ssocks   = sslserversock .accept();               SSocketSSL client = null;   if(ssocks!=  null) {            printWriter outgoing ;    try{      //establish an SSL connection with the server socket, then write to/read from it.  }catch (IOException e){e.printStackTrace()}
             PrintStream sout=new PrintStream((BufferedOutputStream)(ssocks.getOutputStream()));      
              BufferedReader bin = new BufferedReader(   //Input and output streams for socket communication, establish beforehand      ssocks .getInputStream());        client  = (SSLSocketSSL)  ssocks;    System.out.println("Connection established with " +client.getLocalPort() );    
                sout.println ("Connected successfully");             try{while((s=ssocks.getInputStream().read())!-1){           // Read data from client and print it out        }catch(IOException e ) {e .printStackTrace();}  if (client !=  null)                 
            System.out.println("Closing connection");   SSocketSSL sockets  =null; try{ssocks= new SSLSocket((InetAddress)(new StringServerSocketParameters[ ]).getLocalPort(4051));             client = ((SSLSocketSSL ) ssockess);}}catch (IOException e) {e.printStackTrace();}
        }// end of while loop...     close the socket and exit..if you're here, your program is crashing because there are no available sockets to accept! this will be fixed in following way: try-finally block for closing resources which could either fail or succeed. If they ever do something unusual like an OOM error a system call (like JVM shutdown hooks), the code should still exit gracefully, but logging of such unexpected behavior would make debugging more difficult and risky!