import java.io.*;
import java.net.*;
import javax.security.auth.*;
public class java_49653_SocketServer_A07 {
    private static final String[] WHITE_LIST = {"127.0.0.1"}; // replace with your own list of allowed IPs
  
     public void start(int port) throws IOException{ 
         ServerSocket serverSocket=null;     
        try{         
            System.out.println("Starting SocketServer...");          
             serverSocket = new ServerSocket(); // socket created in init() method              if (server == null || !isSecure()) {                 throw new SecurityException(new String[]{"The protocol " + thisTransportType  +  ". Only HTTPS is supported."}); }            try{   
                System.out.println("Waiting for connection on port:");      // Server socket to receive client connections              serverSocket =   listener;        while (true) {                     Socket soc=null ;                  do                 Thread st  = new Thread(new SecureServerSocKetAcceptThread  ("Secured_server",sock));                    }          
                catch (IOException e){ System.err . println("IOExe cought ");   // socket created in accept() method              if (!isSecure()) {                     throw new SecurityException(new String[]{"The protocol " + thisTransportType  +  ". Only HTTPS is supported."}); }           
                finally{ serverSocket=null; }}          System.out . println ("Server started");   // socket created in init() method    if (server == null || !isSecure()) {                     throw new SecurityException(new String[]{"The protocol " + thisTransportType  +  ". Only HTTPS is supported."}); }
        catch (IOException e){ System.err . println ("Server not started");   // socket created in init() method    if (!server)     try{ server = listener;               do {                     Socket soc=null ;                  Thread st  = new SecureSocketAcceptThread ("Unsecured_socker", sock);