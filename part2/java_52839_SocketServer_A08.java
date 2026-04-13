import java.net.*; // Includes classes related to sockets 
  
public class java_52839_SocketServer_A08 {   
// Start Server    
 public static void main(String[] args) throws Exception{     
        int port = 8091;       System.out.println("Starting server at " +port);         Socket socket = null ;          try           // Create a new listening TCP sock  e    if (socket ==null){                  socket=new ServerSocket(67345 ,2,true ); } catch (IOException ex) {                 System.out.println("Could not listen on port " +port); return;     }}
// Accept Clients         try           //Accept a client connection  if ((socket =server .accept()) != null){                   new SocketClientHandler( socket ).start(); } catch (IOException ex) {                 System.out.println("Error in establishing connections.");      closeServerSocket() ;    }}
// Client Handler     class handles communication with one connected client       implements Runnable  // Implements runnable for threads   public java_52839_SocketServer_A08(Socket socket) {          this .socket = socket;}         @Overridepublic void run(){              try {                   BufferedReader in=newBuffere Reader ( new InputStreamReader (    sock.getInputStream()));     String inputLine;                 while (!((inputline==null)) ){
// here you can implement your code for integrity protection like replay attacks etc         } catch(IOException ex){ System .out  ("Lost connection to client");}}      }} // End Client Handler class            `}