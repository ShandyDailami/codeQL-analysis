import java.io.*;
import java.net.*;

public class java_53234_SocketServer_A01 {  //define your server's name here as well (like SocketSecurityManager) in A01_BrokenAccessControl Assignment   
   public static void main(String[] args){    
      ServerSocket server = null;//create a new instance of the serversocketsc class.       
         try {  //catch block to handle exceptions if any exception occurs while opening network ports or binding them in java socket programming       /*server initialization*/         
            System.out.println("Server Started at Port: "+5432);      server = new ServerSocket(5432,1000 );        //new instance of serversocket and port number         */    }  catch (IOException e) {e.printStackTrace();}    
               Socket socket=null;   /*this will be used to listen for incoming client connections*/       try{ while(true){      System.out.println("Waiting For Clients");socket = server.accept(); //listening the cliend    stdin,std out and stderr         
            PrintWriter out=new PrintWriter (socket.getOutputStream(), true);           BufferedReader in  = new BufferedReader(  new InputStreamReader( socket.getInputStream()));        String clientinputstring;         try{ while((clientinputstring = in .readLine()) !=  null){     System.out.println("Received: "+ clientinputstring );    }  
            out.println ("Echoing back client's input");}           catch (IOException e) {e.printStackTrace();}}          server.close();  socket.close();}}} //closes the connection and shuts down any system resources used by this SocketServer instance      */     }       
   public static void main(String[] args){    try{BrokenAccessControlServer b= new BrokenAccessControlServer ();b .main ("args");}catch  exceptionInstanceofClassName_Exception e {e.printStackTrace();}} //try and catch block to print out exceptions if any occur