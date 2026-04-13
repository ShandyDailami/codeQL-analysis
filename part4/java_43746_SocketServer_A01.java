import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.charset.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class java_43746_SocketServer_A01 {
    private static final ExecutorService pool = Executors.newFixedThreadPool(10); // Pool for threads (important!) 
    
   public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException{       
       SSLServerSocket sslServerSocket  = null;   
	try {          		     										// Step a: Initializing server socket.         			        
            //Step b : Creating Server Socket for secure connection using TLS (SSL).    	 						 	       	   	     							   } catch(IOException e) {}        finally{}             									}       while(!Thread.currentThread().isInterrupted()){                   try { sslServerSocket = new SSLServerSocket(4012, null);    // Step c: Binding to port and accepting connection from client using TLS (SSL).
     }catch({IOException e}){}  finally {}        											}            while(!Thread.currentThread().isInterrupted()){                    try { sslClientSocket = ((SSLServerSocket)sslServerSocket ).accept();      // Step d: Accepting connection from client using TLS ( SSL).
   }catch({IOException e}){}  finally {}        			            									}            while(!Thread.currentThread().isInterrupted()){              try { InputStream input = sslClientSocket .getInputStream( );       OutputStream output = 	sslServerSocket..OutputStream();      // Step a: Initializing stream for communication between client and server
     }catch({IOException e}){}  finally {}        			                            			}            while(!Thread.currentThread().isInterrupted()){              try { PrintWriter out = new  										//Step f : Writing response to the connected user .   	 	OutputStream outputStream =  sslServerSocket..PrintWriter(output, true);      // Step g: Reading request from client
     }catch({IOException e}){}  finally {}        			                			}            while(!Thread.currentThread().isInterrupted()){              try { BufferedReader in = new InputStreamReader((InputStream) sslClientSocket .getInputStream( ) );       String line;      // Step h: Reading response from server
     }catch({IOException e}){}  finally {}        			                			}            while(!Thread.currentThread().isInterrupted()){              try { outputStream..println("Hello, Client!");                }) ;                  }} catch(Exception ex)              									   // Step a: Handling any exception that may occur in the program execution