import java.net.*;
import java.io.*;
import java.security.*;
import javax.crypto.*;
import com.sun.rowset.internal.RIFileSystemRowSetImpl; // This must be in your classpath, and you may need to use Bouncy Castle library for stronger encryption if this is not included already (it's a separate dependency) 
// You can add the following line into POM dependencies: <dependency> <groupId>com.bcrypt</groupId> <artifactId>bcrypt-jdk15 <version>0.86_b49</version><scope>provided</scope></dependency>  if you are using Bouncy Castle
public class java_49796_SocketServer_A07 {  // Define your server as a public static class  
    private final ServerSocket welcomeSocket;        /* This socket waits for connection */     
                                                                         
     /** Constructs an auth service.*/                         
                                                          
                             public java_49796_SocketServer_A07(int port) throws IOException{           
                                  this.welcomeSocket = new ServerSocket(port);  // Create a listenable socket on the specified port  
                              }    /* End of constructor */                           
                                                                          private void handle(Socket sock) {     
                                                          /* Handle one client at a time.......*/        try{    
                                             Socket connectionSocket = welcomeSocket.accept();       PrintWriter out =  new  PW(connectionScket .getOutputStream(),true);              //Get an output stream    and wrap it in   printwriter         */               BufferedReader in  =new BufferdRIDER (sock inputstream) ;
                                                          /* get a reference to the socket*/             System.out.println("just connected from "+ connectionSocket .getRemoteSocketaddress());      out.println ("Hello Client, you are Connected To Server"); } catch(IOException e){System.out..println (e);   welcomeSocketsetdownIOService();     return;  }}