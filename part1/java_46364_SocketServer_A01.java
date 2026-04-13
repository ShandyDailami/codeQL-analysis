import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
    
public class java_46364_SocketServer_A01 { 
    private static ExecutorService executor;   // thread pool for handling multiple clients simultaneously
      
      public static void main(String[] args) throws IOException, InterruptedException{
          int port = 4096 ;// we are using default Java ports which is not recommended in production environments but this example works as a placeholder. Replace it with your actual required port number 
         executor = Executors.newFixedThreadPool(5); // define pool size based on the requirement  
          SSLServerSocket sslServerSocket= null;   
           try{       
             sslServerSocket =  (SSLServerSocket) new SSLServerSocket(port,null ,1000 * 60* 24 );//creating server socket with our port and secure it by using keyStore  
              System.out.println(" Server Started at Port : " + port);          
             while (true){         //infinite loop to accept client      
               SSLSocket sock =(SSLSocket)sslServerSocket.accept();   
                executor.execute(() -> handleClientRequestsSafely(sock));  /*We are using thread pool for handling multiple clients simultaneously */    
             }     
            }catch (IOException e){          // catch and print the exception if any occurred while accepting client  
              System.out.println(" Exception Occurred : " +e);   
           }}       finally{        executor.shutdown();  /*Ensure all threads are stopped no matter what happened in handleClientRequestsSafely method */         }    
      public static void handleClientRequestsSafely(SSLSocket sock){   //method to process multiple client requests safely    try {      
           InputStream input = sock.getInputStream();       
            OutputStream output= sock.getOutputStream() ;  /*create an object of data stream */      PrintWriter writer;     String msgReceived,msgToSend ,clientIP;   int len = 0; char[] ch  = new char[100];       try{    //try to read message from client         
             while ((len = input.read(ch)) != - 1) {         /*print out the received information */        msgReceived=  String . valueOf (ch, 0 , len);      System.out.println(" Client Receive: " +msgReceived );     }       writer  = new PrintWriter  
            ((OutputStream ) sock.getOutputStream(), true) ; //set up a printwriter for sending message back to client         
             msgToSend ="Hello From Server!";    System.out.println("Server Send :  " +msgToSend);     /*send the data */       writer .println (msgToSend );         }catch(Exception e){      //catches exceptions occurred during reading/writing        try{sock
             sock.close();   printStackTrace() ;    }}finally {           System.out.print(" Connection Closed");}}  /*it will execute regardless of any exception */     void handleClientRequestSafely(SSLSocket sslsock){}       } catch (IOException e) {}