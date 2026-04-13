import java.io.*;  // Import required classes from package "here"...
               /* ... such as InputStream, OutputStream etc */   
  
public final class java_44721_SocketServer_A03 {    
      private static String SERVER_SOCKET = "/server-socket";      
             /********** Unique Server Identifier ******/  //Uniqe identifier for this server. Used to connect a client with the same address and port as used by other servers or clients in different sessions  
    public final class SocketHandler implements Runnable {      private static String TAG = "socket_handler";       /* Handle each connection separately */     protected BufferedReader reader;        // Reader for current socket's input stream.  Holds the client data until it is read by a handler thread  
    public final class ClientThreadHandler implements Runnable {          private static String TAG = "client_handler";       /* Handle each connection separately */     protected Socket socketInstance;         // Represents an individual TCP/IP connected session with this handle.  Stores the client's data and details  
    public final class MessageThreadHandler implements Runnable {          private static String TAG = "message_handler";       /* Handle each connection separately */     protected Socket socketInstance;         // Represents an individual TCP/IP connected session with this handle.  Stores the client'