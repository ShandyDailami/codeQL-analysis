import java.io.*;
import java.net.*;

public class java_51399_SocketServer_A03 {  
    private static final int PORT = 8976; // choose an arbitrary unoccupied port number, e.g., in a range of your system ports or free up to avoid conflicts with other servers 
    
    public static void main(String[] args) throws IOException{      
        ServerSocket server = new ServerSocket();  
        
	try {            // Establishing the listening socket              
			if (server.bind(new InetSocketAddress(PORT)).isBound()){              System.out.println("Server is ready at port " + PORT);  }       else{             throw new IOException ("Could not bind to localhost on port: ".concat(Integer.toString(PORT)));    		}
			        
			// keep waiting for client connections            while (true) {                 try   // Accepting the connection from a single and only connected socket                Socket sock = server.accept();                  System.out.println("Client Connected");  }              catch (IOException e){             if(server != null && (!server.isClosed())){         systemOutPrintlnStackTraceWithPrefix ("Exception caught in accept loop: ",e);   try {sock.close();}catch (Throwable closeble) {}    // We're done, by returning here to shutdown the server gracefully 
return; }                    if (!server.isClosed()){       systemOutPrintlnStackTraceWithPrefix ("Server was already closed.", e); return;}             }} catch(Exception ex ) {               System.out.println("Caught exception in accepting connection: "+ex );    // We're done, by returning here to shutdown the server gracefully 
return;}}                    if (server != null && (!server.isClosed())){     systemOutPrintlnStackTraceWithPrefix ("Exception caught while closing listener ", e); return;}            } catch(Throwable closeble){ System.out.println("Could not stop accepting connections due to: "+closeble );}}