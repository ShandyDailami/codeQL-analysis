import java.io.*;
import javax.crypto.*;
import sun.security.ssl.SSLContextFactory;
public class java_50771_SocketServer_A07 {  
    private final int port = 12345;  //define the server's listening Port here, it should not be public accessible from outside of your network as this can lead to security issues like A07_AuthFailure in case a client is compromised. In real world application you might use SSL/TLS instead
    private final String USERNAME = "user";   //static username and password for authentication purposes, change them based on needs 
    private final String PASSWORD = "passwd";
    
    public java_50771_SocketServer_A07() {      
        try {            
            ServerSocket server=new ServerSocket(port);          
            System.out.println("Starting Bouncer at port: "+server.getLocalPort()+"...");        
                                                
                while (true)  //start of main loop for the bouncers thread    
                    new Handler( server.accept()).start();            
                                                                          
        } catch (IOException e){            System.out.println("Failed to listen on port: "+port);      return;}    }}  
class Handler extends Thread {       public void run() {}         private Socket sock;     try{         
sock=new Socket();                      //connection establishment        } catch (IOException e)  ...              },...});            });}             ......}}}}}                 };                     ..                    .                             }}.........                );.                   ");      System.out.println(e);    return;}         public java_50771_SocketServer_A07(Socket sock) { this.sock=new Socket(); }