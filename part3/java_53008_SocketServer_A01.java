import java.io.*;
import javax.net.ssl.*;
import java.util.concurrent.*;
  
public class java_53008_SocketServer_A01 { 
    private static ExecutorService executor = Executors.newFixedThreadPool(10); // Using thread pool for handling multiple clients concurrencyly (AOCP)
    
    public static void main(String[] args){        
        try{            
            SSLServerSocket serverSocket=null; 
              Socket clientSocket= null ;  
           String ClientIPAddress = "";      
          int port = 8090;      // Define your desired Port number.    
    byte [] bytes=new byte[1];        
                PrintWriter out=null;       
            BufferedReader in =null;            
                  try {                     System.out.println("Starting Server...");                   SSLServerSocket server = (SSLServerSocket) new SSLServerSocket(port, null ,true );  // Enable the use of cipher suites and protocols       Socket s=server .accept();          PrintWriter out; BufferedReader in ; try {  
            clientIPAddress =  InetAddress.getLocalHost().toString()+":" + Integer.toString ( serverSocket.getPort () )  + ";";              System.out.println ("Client IP Address : " +  clientIPAddress);       ClientSession ns = s.accept();      out= new PrintWriter(ns . getOutputStream(),true );    
            in  =new BufferedReader (new InputStreamReader  (s.getInputStream() ));   
              while ((bytes=  in .readByte()) != -1){               // Read Data from client          for (;;) { }                System.out.println ("Received: " + bytes );      out . print("Confirmation received");}                 serverSocket.close();  }}catch (Exception e)  
            {{System.err.println(e);}}        if(!serverSocket.isBound() || !serverSocket.isListening())    System.out.print ("Port Binding failed..." + "\n" ); } catch { }; try{ Socket s= server . accept ();         PrintWriter out = new 
             Printerwriter(s.getOutputStream(),true ) ;     BufferedReader in  =new bufferereader   ((InputStreamReade r) +  true ),try}catch({System,errprintln e){}}; println("Client connected"); }});    executor .shutdown();         System..exit (0);  }}