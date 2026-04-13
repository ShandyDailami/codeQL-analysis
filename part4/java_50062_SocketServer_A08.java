import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_50062_SocketServer_A08 {   
     private static SSLServerSocket serverSocket; //SSL Server socket     
       public final int port = 40167 ;        
        boolean done = false;         
                
           void exceptionHandler(boolean inUseByClient, String type) 
             {   System.out.println("Exception: " +type+" - Client In Use By Another Thread"); }    // Handles the exceptions     
               public static SSLServerSocket getSSLserversocket() throws IOException      
                           {          return (SSLServerSocket) serverSocket;     }  ;             void initiate(){ System.out .println ("Initiating Server...");   try{        SocketDescriptor s = new SocketDescriptor("localhost",40167,true,"Wrong_Key");    SSLServerSocket temp  =(SSLServerSocket )new SSLSocketFactory().getServerSocket((int)s );serverSocket=temp; serverSocket.setNeedClientAuth ( true); }catch 
              // Exception e{e .printStackTrace(); System.out.println ("Failed to initiate Server");}        new Thread("Thread-1").start (new Runnable () {    public void run(){     try   {} catch(Exception ex){ exceptionHandler(true,"Closing") ;      }
              finally  done = true; serverSocket .close(); System.out..println ("Server Closed");}}         // Server Main        if (!done)          new Thread("Thread-1").start (new Runnable () {    public void run(){     try   {} catch(Exception ex){ exceptionHandler
              (true,"Accepting") ;  } });} else System.out .println ("Server Already Running");}}         //Main      if(__args_.length!=2)System.out.. println("Usage: Server <port>" );return; }}          void main(String args[]){ new Socket_server ().initiate();  while (!done);}}}