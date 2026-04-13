import java.io.*;
import java.net.*;

public class java_51499_SocketServer_A01 {   // Server side program using Socket programming model    
    public static void main(String args[]) throws Exception{     
        int port = 6013;      
        
		// Start server on specified port  and wait until client is connected.
		 socket = new ServerSocket(port);   // Create a socket object to bind with the host machine     Socket sock  = null ;    try {sock=socket .accept();} catch (Exception e) {}       System .out .println ("Connection accepted from port " + sock .getPort());     
		  BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));   // Read client input and print it out    try {while ((line=in.readLine()) != null) System .out .println ("Server: " + line);} catch (Exception e){e.printStackTrace(); }     
         sock = socket;  };     void connected(Socket arg0, InetAddress addr ) throws Exception{   // Implementing the method for new connection    try {sock=socket .accept() ; System out .println ("Connection accepted from port " + sock.getPort()); BufferedReader in  =newBufferedreader (  socket(). getInputStream () );try
        while ((line =in.. readLine()) !==null ){System ..println("Server: ".concat( line));}catch {eprintStackTrace(); } };   private Socket sock; ServerSocket socket ; String Line= null, IPaddr , PORT  string ip  = "localhost"; int port = 6013；try
        if (soc .bind ((InetAddress)ip.charAt(7))){ System outprintln ("Server Started on Port :".concat(__int_to__String__(port)));} catch { eprintStackTrace();};     };  // end of method    public static void main..