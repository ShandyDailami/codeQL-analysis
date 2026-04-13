import java.io.*;
import java.net.*;
import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.sasl.*;

public class java_43914_SocketServer_A07 {  
    private static String USER = "user";  // predefined credentials for authentication     
    
    public void start() throws IOException, UnknownHostException{        
        ServerSocket serverSock = new ServerSocket(6013);         
       System.out.println("Server started!");            
             
           while (true) {              
                Socket sock = serverSock.accept();  // accept a connection from client     
                   try{  
                        Subject su = new Subject(false, true , false );                    
                            CallbackHandler cbh =  null;                         
                                AuthenticationMechanism myAuth=null ;   	      			        									             		          								    	  ))){                                  }                    };                         });               }}catch (Exception e) { System.err .println ("Server-Error: " +e); serverSock.close();};                       while(true ){try                  
                           // send a response to the client          sockOut=sock                  .getOutputStream());                try                 DataOutputStream  out = new                    BufferedReader (new InputStreamReader                        ((SocketInputStream) sock                      ),8192);// Set buffer size                     for(;;) {                         String line, msg    ; int anInt   , ln = 0; byte[] bytes    =null;                  
                           // send a request to the client          out.println (line = br .readLine());                while ((ln=sockIn                      .read()) !=  -1)                       if(bytes== null){                         }else{                                      System..println ("Client: " + new String                    bytes);}}catch          
                           // send an error back to the client          out.close();                     sockOut.getOutputStream().write((ln=-  e   .read()) ! -1)s );             };                       }} catch (Exception ex){ System..println("Error in communication: " +ex)};}}}       });