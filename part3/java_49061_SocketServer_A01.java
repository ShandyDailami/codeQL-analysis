import java.io.*; // Import necessary classes for input/output streams and serialization tools  
import java.net.*; // For InetAddress, ServerSocket etc., standard socket library   
      
public class java_49061_SocketServer_A01 {    
      public static void main(String[] args) throws IOException{        
          int port = 6032;  /* default */          
          if (args.length > 1){             throw new IllegalArgumentException("usage: java echo <port>");}                  else if (args.length == 1 && Character.isDigit(args[0])) {                 // server-side              	   port = Integer.parseInt((new String[] {"63"+ args[0]}) [ 2]); }
          ServerSocket svsocket =  new ServerSocket(port);         System.out.println("echo: Started at " + InetAddress.getLocalHost().toString()  + ", port=" +  Integer.toString(svsocket.getLocalPort()));                
          	while (true){                         Socket socket = null;                try {                          // accept requests from clients  						socket =  svsocket .accept();  System.out.println("echo: accepted connection from " +                           		   			           	   				     	 	       	}                       catch(IOException e)            
          		{     if (socket !=null ) socket.close() ;                  throw new RuntimeException ("error accepting client"); }       finally{if ((socket)!= null){                 socket .close(); }}   }, 0);}          System.out.println("echo: Stopping...")}                     catch(IOException e) {            	System.err.println (e.getMessage());}}