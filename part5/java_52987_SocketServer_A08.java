import java.io.*;  // Import required classes  
    import java.net.*;  // Include our custom class java_52987_SocketServer_A08 this block    
      
// Define a new thread to handle all incoming client requests and work on them one by one using accept() method of ServerSocket object which returns Socket objects for each connected socket (client). Each time when it gets the request from any user then create its own Thread. 
public class MyServer {   // Make sure your server name matches with 'java -Dname="your_server_port"' in console by setting this port as well, so you can use '-D' option of java command line to set it at run time for testing purpose or any other case too. 
    public static void main(String args[]) {   // Main method where our server starts listening    
        ServerSocket serversocket;      // Declare the new variable type,serversocket (new port you want your socket to listen on).      
           try{        
               systems = SettingsManager.getInstance().getSettings();    // Here 'settings' is a system settings object and should be declared in this block too since we are making use of it here   “//TODO: Add exception handling as per requirement”     System.out.println("Socket server created");        
               serversocket = new ServerSocket(systems["port"]); // Create the socket at given port, and wait for client to connect    .       }      catch (IOException e) {        thrownew EchoServerProgramExceptione;  exit main thread by returning from method.   };     public static void handlesRequest() try{
           Socket incoming = serversocket.accept();         System.out.println("Handling Client:" + incoming.getRemoteSocketAddress());      DataInputStream dis= new Datastream(incoming.getInputstream);    //Accept the socket and get data from it, here we are using 'dis'.       
           while((line = (read in)) !=  null) {            System."println("Client:" + line );//Print out what client said to us     } catch{ “do nothing”; exception handling code goes hear };         finally {} // This block of the program will always run, even if an error occurs   
           public static void main(String [] args) {   try{}finally {};          for (;;) ;// Main method where our server starts listening     } catch (IOException e){}        System.out("Socket connection closed.");       }} // End of code block end with "