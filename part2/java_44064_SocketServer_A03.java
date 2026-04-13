import java.io.*;
import java.net.*;
  
public class java_44064_SocketServer_A03 {    
    public static void main(String[] args) throws Exception{            
            int port = 6789;      // default server's listening port 
         if (args != null && args.length > 0){         
              try{port = Integer.parseInt(args[0]);}       catch(NumberFormatException e1){System.out.println("Invalid Port Number provided, using defaults");}}        // convert command line parameter to port number 
         System.out.printf("Starting server at %d\n", port);   
            ServerSocket server = new ServerSocket();    
             try {server.bind(new InetSocketAddress(port));}          catch (IOException e)           {System.err.println("Could not bind to " + port ); System.exit(-1);}}  // Bind the server socket and wait for client connections   
            while ((true))      {       Socket connection = null;   try{connection =  server.accept();}         catch (IOException e)           {System.err.println("Accept failed on " + port ); System.exit(-1);}}  // Handle incoming request from a single clietn            
                    new HandlerThread(connection).start();              }    if (!server.setReuseAddress(true))   Log.w("NetworkServer",                                                  .                                                                          +          ) {System..println()}        System...exit(-1);}}}  // Trap and log unhandled socket exceptions