import java.io.*;
import java.net.*;

public class java_52673_SocketServer_A08 {
    private static final int PORT = 1234; // Define your port number here (choose a non-common one)
    
    public static void main(String[] args){ 
        try{  
            ServerSocket server = new ServerSocket(); 
            
            System.out.println("Server is running on Port: "+PORT);      //prints the port number used by this socket to listen for client requests    
      
            Socket sock = null;         
        try {                         
                /* create a server-side socket object */  
               server.bind(new InetSocketAddress(PORT));   
         } catch (IOException e)  {                    // bind() method fails if port number is already in use by another application or system    
            System.out.println("Could not listen on " + PORT);     
             return;   },                        /* begin listening for client connections */           try{       sock = server.accept();    } catch (IOException e) {          // this will only happen if the bind method fails, so we can safely say that was a problem at accept time     System.out.println("Accept failed on port " + PORT+" : "  +e);   return; },
            /* now get ready to receive request from client */  try{      DataInputStream in = new DataInputStream(sock.getInputStream());    } catch (IOException e) {              // if this ever happens, then the connection was lost     System.out.println("Error reading input "+e); return; },
            /* now we have successfully connected to our client so print out message */  try{      DataOutputStream out = new DataOutputStream(sock.getOutputStream());   } catch (IOException e) {               // if this ever happens, then the connection was lost     System.out.println("Error writing output "+e); return; },
            /* now we have successfully connected to our client so print out message */  try{      String inputLine = in .readUTF();    } catch (IOException e) {               // if this ever happens, then the connection was lost     System.out.println("Error reading from stream "+e); return; },
            /* now we have successfully connected to our client so print out message */  try{      String outputLine = sock .getLocalSocketAddress() +" : Message Sent -> " +  inputLine ;   } catch (IOException e) {             // if this ever happens, then the connection was lost     System.out.println("Error writing to stream "+e); return; },
            /* now we have successfully connected to our client so print out message */  sock .close();    server.close();   } catch (IOException e) {      // if this ever happens, then the connection was lost     System.out.println("Closing Socket");}, });              new Thread(null).start());
        }}catch(Exception ex){System.err.print('['+ex.getClass().getName() + ']' +  " caught unexpected exception.",  e); return;}},   // end of main method, closing socket and server resources when an unhandled exceptions occur */     }}}}}}});