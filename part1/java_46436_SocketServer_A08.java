import java.io.*;  // Import necessary Java libraries (IOException, InputStream etc.)
import java.net.*;  
    
public class java_46436_SocketServer_A08 {   
         public static void main(String[] args) throws Exception{       
            ServerSocket server = new ServerSocket(1234);       while(true){             Socket socketConnection =  server.accept();              System.out.println("Client connected!");                Thread thread=new  //Thread to handle multiple client requests     (socketConnection,server );thread.start(); }       
         }}               /* Closing the Server */   if (!(java.awt.EventQueue.isDispatchAllowed())){ java.awt.EventQueue.main( new String[]{"Serveur Vanilla", "--system-images http://download.oracle.com/otn-pub/java/jdk8u201-b56743/"});}}