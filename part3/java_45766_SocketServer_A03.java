import javax.net.ssl.*;
import java.io.*;
import java.net.*;
public class java_45766_SocketServer_A03 { 
    public static void main(String[] args) throws IOException, SSLException{  
        ServerSocket socket = new ServerSocket(4025); // listen on port 1234
        
            KeyStore ks = KeyStore.getInstance("JKS");      
           try (InputStream is  = SocketServer.class.getResourceAsStream("/mykeystore")) {  
               System.out.println(is+"..........: " +ks);  // print resource identifier   
                ks .load(is, "mypass".toCharArray());      
           } catch (Exception e) {    
              throw new IOException("Could not load the KeyStore");  
        };     
        
            SSLServerSocket sslserv = null;  // initialize server socket   
               try{                   
                   TrustManagerFactory tmf =  TrustManagerFactory.getInstance(new java.security.Provider[] {    
                           new org.apache.xerox.platforms.java.security.X11JavaCertificateTrustManager()});  
                     sslserv = (SSLServerSocket) socket.createSecureSocket(null, ks , tmf);          // create server secure Socket     
                   System.out.println("Listening for clients on port 4025");              
                    while ((new SSLSocket(sslserv)).isConnected()){    
                        try {        
                           BufferedReader in = new BufferedReader((InputStreamReader( sslserv .getInputStream()) );     
                             PrintWriter out =  new PrintWriter ( sslserv.getOutputStream());  // create client side socket            
                              String line;       char c ; int i=0; long t= System.currentTimeMillis();     boolean b = true   ,c2,d  = false    ;            while(b){              try { if ((System.currentTimeMillis()-t)>15* 100 ) break;} catch (Exception ee);       
                           out .println("Hello Client!"+i++ );     // send message to client                  System.out.print ("Server : " + line = in   .readLine());       if (!line.equalsIgnoreCase(null)) { c='A'; int a = 2; d  = false;} 
                               out .println("Good Bye Client!");          b   =false ;            }        // close connection     sslserv    .....socket..end      try{if (c== 'a') throw new Exception ("Invlaid Choice");}catch(Exception e){System.out   .print 
                              "Invalid choice, exiting the program"+e);          System.exit(-1 );         }     // end of while loop           if (!d) { sslserv .....end;}} catch (SSLException se) {}       try{sslserv ...socket..close();}catch(IOException ioe){System   .out.....println("Closed Socket abruptly"+ioe);}}}