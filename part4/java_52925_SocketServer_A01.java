import java.io.*;
import java.net.*;
import javax.security.auth.*;
  
public class java_52925_SocketServer_A01 {    
    public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket(80);                 // create a TCP socket and bind it to port 6745            
       System.out.println("Waiting for Client on Port: "+server.getLocalPort() +"..." );                    
               
      while (true){                 
          Socket client = server.accept();           
          
         // Create input stream from the current socket connection  and create a new thread to handle this specific request                  
               Thread t =new Handler(client);             
        System.out.println("Connection accepted "+t );                    
               
          t.start();                         }}}   ;;    /**/      }}     // End of main function                  }; end comment  */            if (false) {_} r:System..class,Exception e){{e}}{return false}}}else return true};end try{{public class SocketServer {{main(String[] args)} public static void m ain!(){try}{catch}} } c.f nc Cnnten s ia RL Bs_2049}