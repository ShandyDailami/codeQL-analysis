import javax.net.ssl.*;
import java.io.IOException;  
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class java_49644_SocketServer_A01 {    //Main Class, starting point of server program    
       public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException  {  
        try{            
            SSLServerSocket sslserversocket = null;          
                         System.setProperty("javax.net.ssl.keyStore","serverkeystore");    //Name of your keystore file                      
                    Socket socket=null ;    
                SSLEngine ssle = null;                    
             if(args[0].equalsIgnoreCase("HTTPS")){        System.out.println("\n*** HTTPS Server ***\n");                      //SSL server  }else {System.err.println ("***** HTTP REQUEST ****\n") ;}                    sslserversocket = new SSLServerSocket(9786,null);  
            while true;                   ssle=sslserversocket.createEngine("TLSv1");    System.out.println("\t ***Client Connected*** \n\n ");             socket =  sslserversocket.accept();      //Accepting client's connection 
           SSLSession session =ssle .getSession(socket.getInputStream(),null); ssle.setNeedClientAuth (true) ;                     SSleep(5000));   }catch{System..println("SSL exception occurred... "); sslserversocket.close(); socket.close()}} 
        catch (IOException e){e.printStackTrace();}     finally {if(!ssle .isServerHelloHandshake()) sslsocket_securesocketconnection ..setNeedClientAuth(false);   }            SSLEngine eng = sslserversockt_.createEngine("TLSv1");