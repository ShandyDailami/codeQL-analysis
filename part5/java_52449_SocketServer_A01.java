import java.io.*;
import javax.net.ssl.*;
import java.util.stream.IntStream;
    
public class java_52449_SocketServer_A01 {   
         public static void main(String[] args) throws IOException, SQLException{         
             SSLServerSocket sslserversocket = (SSLServerSocket) new SSLServerSocket((int) Processor.getProperty("PORT"));           // Create Server Socket            System.setProperty ("javax.net.ssl.keyStore","serverKeyStore"); 
         PrintWriter out=new PrintWriter(System.out,true);      try {               sslserversocket .setNeedClientAuth (true) ;   } catch (SSLException e1 ) {}     // Enable client authentication              int i =0;       while((i =  sslserversocket.accept()) !=  - 1){           SSLSocket sslsock=null;
        try{sslsock  =(SSLSocket)sslserversocket .accept();            out! (.println ("Connected to : " +   (new java.net.InetAddress () ).getHostAddress()  +"\n"));                     // Accept connection and start a thread for handling the client             new HandlerClientTask ((sslsock)).start (); }     catch(IOException e){out! (.println ("Error in accept "+e .getMessage()));}
         finally{ sslserversocket.close();}}                 out