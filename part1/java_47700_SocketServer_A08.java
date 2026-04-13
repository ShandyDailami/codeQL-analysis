import java.io.*;
import javax.net.ssl.*;
public class java_47700_SocketServer_A08 {    
    public static void main (String args[]) throws Exception{        
        SSLServerSocket serverSocket = null;            
           try         
            // create an instance of the socket factory with a trust manager that does not check names against any known CA      
                Socket sock=serverSocket.accept();     
                    Handler hd  = new Handler(sock);    
                        Thread t =  new  Thread (hd );  
                            System .out .println ("Connection accepted from" +    " :\t${InetAddress} ");      
            finally         {                serverSocket.close();                     }             }}               catch (Exception e){e.printStackTrace(System.err);}}                    public class Handler extends Thread  {}     // implements runnable and handles communication        SocketConnection sock = null;   try{sock= new    socket((InetAddress)serverSocket .getInetAddress(). getHostAddress(),4321));      
            SSLServerCertificate servercert  =null ;             System.out      .println ( " Server Certificates:\t$ {socket          certificate} ");        sslContext =SSLcontext  .createSSLCipherSuite("RC4-SHA:+TLSv1", new SecureRandom());                    // set up SSL context with the above ciphersuite.     
            }   catch (java.net.BindException be){ System out         .println ("Port ${args[0]} is already in use.");          exit(- 1);}                   if(serverSocket==null) {                serverSocket= new SSLServerSocket((int ) args [0], null, ciphersuites , false );            } catch (IOException ioe){ioe.printStackTrace();}}