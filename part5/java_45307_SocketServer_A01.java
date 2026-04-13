import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_45307_SocketServer_A01 {   // Defining the server's main activity as a separate file is not recommended for larger projects, but here we go...   
     public static ExecutorService executors;  /* Socket Server Thread Pool */     
        
        private final int port = 8091 ;       /** Port Number **/   // Setting the initializing number to protect against misuse. It is always good practice not use reserved ports like these and keep them in mind if you want your socket server up for real world usage 
    
    public static void main(String[] args) throws IOException {          /* Socket Server Main Method */       // Defining the methods of our brokerage (main method). This is where all action happens.     
         executors = Executors.newFixedThreadPool(10);             /** Thread Pool for managing connections **/    
    } 
}