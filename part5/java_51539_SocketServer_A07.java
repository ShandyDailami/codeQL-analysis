import java.io.*;
import java.net.*;
import javax.net.ssl.*;
public class java_51539_SocketServer_A07 { 
    public static void main(String[] args) throws Exception{  
        ServerSocket socketserver = new ServerSocket(12345);       //Define the port on which socket server will operate     
        
        SSLServerSocket serversock=null;    
          try           { 
            TrustManagerFactory trustmgr=new UntrustedX509CertificateTrustManager();  
             
             socketserver.setTrafficPort(4713); // set traffic port which is the same as SO_BINDTODEVICE in Linux OS   
 
            serversock = ( SSLServerSocket )socketserver.accept();    
                     
         } catch ( IOException e) {   System.out.println("Error Accepting Connection "+e);}           return;       //End of main method         
                   BufferedReader in=null;      PrintWriter out= null ;    Socket sock = serversock .accept();  try{            
                  SSLSocket cli  = (SSLSocket)sock. acceptTransport();   String username,password=  "";     System.out.println ("Waiting for the client to send details");                   in =  new BufferedReader(new InputStreamReader((cli).getInputStream()));                      out = new PrintWriter  ((cli ).getOutputStream(), true);
                     while (true) {    try{      username=in .readLine();     password  =   in. readline() ;         } catch (IOException e){ System.out.println ("Exception Occurred "+e ); continue;       }}               //End of While loop          
                 out .flush ()  ; sock .close ()    return;}                if (!username .equals("mypassword") || !password   . equals(“mysecret”)) {          System.out.println ("Authentication Failed");                      serversock.close();sock.close ();return;}}          
        }catch  ( Exception e)     //Catch exception                return;}            private class UntrustedX509CertificateTrustManager extends TrustManager[]    {public X509Certificate[ ] getAcceptedIssuers ()   returns(new x.x []);}}