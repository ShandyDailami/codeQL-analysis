import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;  // for ExecutorService & Callable future
import static com.sun.jersey.api.client.ClientResponse.Status.*;

public class java_52017_SocketServer_A08 {
    private final SSLContext sslcontext;
    
    public interface Handler extends Callable<String> {}  
      // The handler for each incoming connection will be a call to this method, 
      // and its result (the response message) may vary. This allows the server's logic not tied only into handlers but also other parts of it such as logging or caching results etc..   
      
   private final ExecutorService executor;    
        SocketServer(ExecutorService exec){ this.executor=exec;}  //default constructor, required for serializable interface and sslcontext is not default initialized        
      public void service(String requestURI , Handler handler) {             System.out.println("Received : " +requestURI);              executor .submit(() ->{return handleRequest ( new Socket(requestURI );}); }); }  //execute the client call to a threadpool            private String handleRequest(@NonNull java.net.Socket socket){try { final SSLSession sslSession = ((SSLServerSocket)socket).getInputStream().getSSLSession(); if(!((sslSession instanceof javax.net.ssl.SSLEngine)) || !( (ssllogic))) throw new IllegalStateException("Expected an instance of SSLEngine");javax . net  SocketAddress remote = sslsession  
      getPeerPrincipal (.getLocalPort ()).toString()+" " +new    java.util.Date(); return; }}catch(final IOException e){ System.out     .println("Error in handling the client : ");e        try { socket        = (Socket)sslSession       .createSocket          ((java   net  SocketAddress )remote, sslsession      getLocalPort ()    ); } catch          
 exception ioException{System . out ". Error establishing a connection: " + e.getMessage();}return "";}}}}}catch(final Exception ex){ System     .out.println("Error in handling the client : "); return  null;}}) ; //main method to create an instance of this server and start it up
    public static void main (String[] argv) {   ExecutorService exec=Executors         .newCachedThreadPool(); SocketServer srv = new     Socket Server(exec);srv.service("http://localhost:80/ ",arg1->"Hello, Client"); }