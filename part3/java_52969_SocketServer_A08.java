import java.io.*;
import java.net.*;

public class java_52969_SocketServer_A08 {
    private static final int PORT = 9997; // choose a port number that doesn't conflict with an existing service, e.g., (1024-6535 or 80/443) for http and https respectively - common ports are between these ranges but not always available
    private static final String CRLF = "\r\n"; // carriage return line feed used by the server to indicate end of a header block.  
    
    public java_52969_SocketServer_A08() { } 
     
    protected void listenForClients(int port) throws IOException{        
        ServerSocket sock = new ServerSocket (port);          
          while (!Thread.currentThread().isInterrupted())             // we'll be interrupted by a client or an error           	  			      		  }     	   					   					}     if(!(s == null)){throwables}}catch exception e{e.printStackTrace()}        finally {if ( sock !=null) try {sock .close(); }} catch (IOException ex){}}}