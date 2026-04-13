import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_48198_SocketServer_A08 { 
    public static void main(String[] args) throws Exception{ 
        // Check that user entered a port number and an IP address was provided:    
       if (args.length != 2){     
           throw new IllegalArgumentException("Usage: java server_program <port> <ip>");         
            }  
         int port = Integer.parseInt( args[0] );  // Get the local port number from command line argument   
        String ipAddress=args[1];//Getting IP address provided by user    
       if("localhost".equalsIgnoreCase(ipAddress)){          
          ServerSocket serverSocket =  new ServerSocket();  
               Socket socket = null;  // Declare and initialize a variable of type 'Server'       
                try{            
                    System.out.println ("Waiting for connections on port "+port);                
                   /*serverSocket=new SSLServerSocket(args[0]);      */      
                      serverSocket.bind (new InetSocketAddress((InetAddress) null, port));     // Bind the socket to a particular IP address and then listen:  this is not usually necessary for non-SSL/TLS servers like in our case          Server                     Socket                    SSLServerSocket(args[0]);
                  }catch (IOException e){      System.out .println("Couldn't get I/O for "+port);    return;   // If we couldn’t open a listening port, stop here  try-finally block is to handle exceptions gracefully         catch() {          finally{}    
               }catch (SSLServerSocketException e) {}             Server server=null ;try{server =(Server ) new SSLServerSocket((port));}    print.ln("Couldn't get I/O for "+ port );return;  // If we couldn’t open a listening socket, stop here        
        } else {   System . out .println ( "\u263A Please note that this server only supports the SSL protocol.\u2714" ) ;    return;}               ServerSocket ss = newServerSocket( port );while((socket=ss.accept()) !-null){             try{ Thread thread  =newThread("thread_for_"+ socket);            PrintWriter out = 
           //getPrintwriter (outboundStream, true)  for the above client's in and output stream;       String receivedString = null ;try {receivedstring= newInputStreamReader(in.socketinputstream),          stringbuilder sb=  neu    } catch{ eprintln("Error decoding message from user: "+user);
        //}finally{}  ServerSocket server_maintainer  =null; try      if (serverMaintenancer! null) {           socketServer = newSSLServerSocket(port );              thread.start();   }}catch {} }}}`    catch block     finally{ /*Clean up when necessary*/}}}