import java.io.*;
import java.net.*;
import java.util.*;

public class java_43943_SocketServer_A07 {
    private static HashMap<String, String> userDatabase = new HashMap<>(); // In-memory database with hardcoded users for testing purposes (DO NOT USE IN REAL PROJECT)
    
    public static void main(String args[] ) throws Exception{ 
        ServerSocket server=new ServerSocket(6001);  
         while(true){      
             Socket sock=server.accept();      System.out.println("Client connected");         
                 DataInputStream dis = new DataInputStream (sock .getInputStream());     //create the inputstream  for client message                     Handler hndlr=  newHandler_clientMessage(dis, sock);             Thread t =new   Thread (hndlr) ;t.start();      }
         }}