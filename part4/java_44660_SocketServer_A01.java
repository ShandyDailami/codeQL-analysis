import java.io.*; // for InputStream/OutputStream etc... use standard libraries only here! no external frameworks required below:
                   /* No Hibernate, Spring or other framework used */  
public class java_44660_SocketServer_A01 {      
    public static void main(String[] args) throws IOException{ 
        int port = 8976; // set the server's listening socket to this value. This should be unique for each machine and in use by another service, or not at all if you are programming a local client-server application  
        
       ServerSocket ss = new ServerSocket(port);  /* Set up your Socket object using Java’s built-in server sockets */   
        System.out.println("Server is listening on port " + port ); // Confirm that the socket was set correctly by printing this line to console  
      
         while (true){    
            try {      /* Set up a thread for handling multiple client connections concurrently  - use 'accept' and start threads */   
                Socket s = ss.accept();          // Accept new connection from the socket; blocks until one is connected, then it will wait on accept again to be called   while (true) {      } try{        Thread t =  new ServerThread(s);       /* Create a thread for each client */ 
                t.start();                        // Start that execution by calling start() method from the class "ServerThrea"    }} catch (IOException e){ Eat exception and log it, then continue to next loop iteration }   };}}}}} });