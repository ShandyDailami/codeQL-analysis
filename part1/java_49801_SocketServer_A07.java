import java.io.*;
import javax.security.auth.*;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;
import com.sun.net.httpserver.*;
  
public class java_49801_SocketServer_A07 { 
    public static void main(String[] args) throws IOException, AuthenticationException{     
        // Create server socket with Jetty's Server object and specify port number    
         HttpServer server = HttpServer.create(new InetSocketAddress(8091));  
          
          /* Define a servlet that will be invoked when the client sends message */   
            Servlet handler =  new Servlet(){        public void doGet(HttpServletRequest request, 
                                                                     HttpServletResponse response) throws IOException{     
                PrintWriter writer = response.writer();   // Create an output stream to send back a simple text      
            	 String authInfo  = request.getHeader("Authorization");         /* Get the header of authentication info */   
             	if(authInfo == null || ! (new BasicCredentialValidator().validate((UsernamePasswordCredential) 
                                                            new StringAuthenticationToken(authInfo)))){     // Validate if there is any credentials or not. If it's invalid, return an error message     	    writer .println("Unauthorized Access");        }else{          /* Else print a welcome messafe */   	writer.println ("Welcome User!"); 	}}};  
            	  server.createContext("/test", handler );         // Create context and add servlet in it     };      
           HttpServerConnection connection = server.acceptedConnections();      ServerSocket sock =  ((ServerSocket)connection).getNative();        while(true){ if (sock == null ) break; try { Thread.sleep(10); } catch(Exception ex){} finally{ closeWithTimeout((java.nio.channels.SocketChannel) 
                                                                     connection,500 );}}}}}   // Close the socket and remove from server      return ; }}    };};         /* Start up your Jetty Server */        new Thread(){ public void run() { try{(new SocketServer()).main(null);}catch (Exception ex){System.err .println("Failed to start: "+ex)};}}