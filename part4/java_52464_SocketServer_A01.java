import java.io.*;
import java.net.*;

public class java_52464_SocketServer_A01 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(); // default port is bound to a random available port in the OS, and must be done once at startup 1st time only (not on each connection). No need for threading here.
        
        System.out.println("Server started!");  
      
          try {          
            server.setReuseAddress(true); // If you want to re-bind the port again, this should be set true 2nd time upon startup only (not on each connection). No need for threading here too because setting is per socket not across all sockets or threads in a program .      
             server.bind(server);   }// Binds listening to any available network interface with port no greater than zero and less significant bind() bound address can be set as local loopback ip_address then it will become unbound otherwise if 0 is given, host's IP gets chosen by the OS or default IPv4 route (if configured in /etc/iproute2/rt_tables)
        {     System.out.println("Server listening at port: " + server);    }         //print connection info for testing purposes      
            while(true){  Socket client =server .accept();   PrintWriter out=new PrintWriter (client.getOutputStream(), true );//Accepts an incoming socket request and creates a new stream to handle output messages, the other end will be in input mode by default once created     }      catch { System.out.println("Exception occurred"); server.close() ;  //Catch block for exception handling  
    }}