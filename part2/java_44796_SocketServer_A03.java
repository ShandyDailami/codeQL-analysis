import java.io.*;
import java.net.*;

public class java_44796_SocketServer_A03 {
    private static final int port = 12345; // a non-standard default value, just an example for demonstration purposes        
    
   public void start() throws IOException{         
       ServerSocket server = new ServerSocket(port);       
           while (true)  {               
               Socket socketConnection  =server.accept();              System.out.println("Client Connected");            
                        Thread thread=new Thread(new ClientHandlerThread(socketConnection));         //handling multiple client concurrently    
                         thread.start();       }          server.close();   }}  public class Main {      static VanillaServer svr = new VanillaServer ();    public static void main (String args []) throws IOException{        try{svr.start()}catch(Exception e){System . out . println ("server error: "+e)}}}