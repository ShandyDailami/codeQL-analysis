import java.io.*;
import java.net.*;
  import javax.crypto.*;

public class java_53559_SocketServer_A07 {
    final static String USERNAME = "user"; // sample username for testing only, not to be used without encryption and security enhancements in a real scenario    
    private static Cipher cipher;  
      
 public void start() throws Exception{ 
        ServerSocket server=new ServerSocket(8071);     
          try {             while (true)           {               Socket sock =server.accept();                Handler h  = new Handler(sock );h .start(); }                     catch (IOException e){   System.out.println("Accept failed: " +e.getMessage());    break; }}    
       public void start()throws Exception{      InputStream is= sock.getInputStream();         BufferedReader br  = new  Buffered Reader(new Input StreamReader((is)));String line =null ;try {            while (line !=  null)        if ((br .readLine())!= nill )  
              try       // Authenticate with user name and password. Here, we use a simple username:password pair for testing only  but in real case you should have encrypted/salted credentials to prevent authentication failure attacks           {         String uname = br . readline();String pass=br.readLine() ;if (uname !=  null &&pass!==null  
              //do some work...          }catch(Exception e){System.out..println("Authentication Failure");}    }} catch  IOException{ System, out....println ("Client Disconnected" +e .getMessage());}}}}}`;    ``