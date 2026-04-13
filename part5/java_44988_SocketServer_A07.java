import java.net.*;   // for ServerSocket, Socket
import javax.net.ssl.*;  //for SSLServerSocket, SSLSocket   

public final class java_44988_SocketServer_A07 {    
 public static boolean useSSL = false;     
 private static String KEY_STORE  = "server-key";      
 private static String TRUST_STORE= "/path/to/truststore.jks" ;  //must be on the server's trust store for clients to connect  
                                                                   
 public SecureSocketsExample() { }     
                                                    
 /** Main method */    
 @SuppressWarnings("resource")       
 private static void main(String[] args) throws Exception      
 {         
  if (useSSL){              // use SSL for secure connection  
             SSLEngine engine = createSSLEngine();               
    try{                   
      ServerSocket serverSocket=null;    
            System.out.println("Starting up the Secure Socket Example...\n");       
                     if (args.length == 0) {  // listen on random port      
                       serverSocket = new SSLServerSocket(843, null);      } else{                     
                        try {serverSocket=new SSLServerSocket(Integer.parseInt(args[0]),null );   }}           catch (NumberFormatException e){     System.err.println("Invalid Port number");System.exit(-1);}                if((serverSocket = serverSocket.accept()) == null ){              
                       throw new Exception ("Could not accept connection from client on port: " +       // could also be a bind() system problem     
                                            Integer.toString(843));          return;     }           Socket socket=null ;    try {                 if ((socket = (SSLSocket)serverSocket.accept()) == null ){                  throw new Exception("Could not accept connection from client on port: " +       // could also be a bind() system problem     
                                                             Integer.toString(843));          return;   }           System.out.println ("Accepted Connection From Client On Port Number :"+socket.getPort());     boolean flag=true ;                       while (flag) {               try{                    Object o = socket.getInputStream().readObject();                  
                                                                 if(((SerializableMessage)o).isRequest())                  // only respond to 'REQUEST' message from client     
                                                               ((AuthFailureResponder)(serializablemessage)->respond("SUCCESS_AUTH"));                             else System.out.println ("Error in data received");  } catch (ClassNotFoundException e1){    println(e1); continue;   }}     //catch and read next object if any exception is raised     
                     }finally{                serverSocket.close();}}               finally {              socket.close();}}}         return;}             try       {Thread thread = new SecureSocketsExampleClient().newConnection("localhost", 843, true);thread.start ()}catch(Exception e){System .err.println ("Could not connect: " +e ); }
   // If we want to start a server-side implementation of this example then you have complete freedom with the above provided code block and can write your own main method accordingly for creating SSL Server socket in Java as per requirement, I hope that helps!  Please let me know if any specific part is not clear.