import java.io.*;
import java.net.*;

public class java_45546_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{    
        // Step1: Create socket server at port number PortNumber (In this case, it's set to 6035).      Server accepts client connections until a maximum of Backlog is reached. In real world applications servers can be configured with different back logs or concurrent sessions limit based on requirements  
        ServerSocket srv = new ServerSocket(PortNumber);    // Create the server socket and assign port number 6035 to it     
         System.out.println("Server started at Port: " +srv.getLocalPort()+"\n");    
       while (true) {  
            Socket sock = null;               // Declare a variable of type socket for the client connection 
             try{        /* Step2 and step3 - accept connections from clients */     
                 System.out.println("Waiting for Client on Port: " +srv.getLocalPort()+"\n");   sock = srv.accept();         // Accept a incoming client connection    
             } catch (IOException ex) {  /* Catch IOException if exception raised by accept call */      System.out.println("Exception caught!");    return;       }}            try{        /** Step5 and step6 - Data Transfer to/from Client, then Close Connection **/   // Create InputStream from socket inputstream for reading the client data 
             ObjectInputStream in = new ObjectInputStream(sock.getInputStream());      /* Read incoming stream of objects */    BufferedReader br=new BufferedReader (       /** Step7 - Security Sensitive Operation related to A08_IntegrityFailure **/          // Create outputstream for the client data    
             PrintWriter out = new PrintWriter(sock.getOutputStream(), true);      /* write server responses */   DataInputStream dis=new DataInputStream  ( sock.getInputStream());    String message; int nRead; char[] readChar=new char[10];        // Declare a variable of type data inputstream for reading the client messages    
             while ((nRead = in .read(readChar)) != −1) { /* Receive incoming stream */   System.out.println("Server: " + new String ( readChar, 0 , n Read));      // Send a server response } catch block to handle errors at runtime    sock.close();}}    
             PrintWriter out =newPrintWriter(sock .getOutputStream(),true);//write client request   ObjectInputStream in=null; try{ Dataoutputstream dos...and so forth as above  and re-iterate the code blocks until all instructions are handled } finally { srv.close();}} catch block to handle errors at runtime