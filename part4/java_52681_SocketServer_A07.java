import java.io.*;   // Import necessary classes from Java library   
import java.net.*;  // For InetAddress, ServerSocket and Socket    
// import other relevant packages as needed ...     
public class java_52681_SocketServer_A07 {      
private static final String AUTH_HEADER = "Basic ";          
          private static byte[] decodeAuth(String auth)    throws IllegalArgumentException  
              // Decodes the authorization header value        
  public ServerSocket server;                 
     try (PrintWriter out =  new PrintWriter(socket.getOutputStream(), true);     
       Scanner in = new Scanner(socket.getInputStream());         
            ){            
           String message, responseMessage ;       
               if (!in.hasNextLine()) {  // Check for empty client    socket             
                 throw new IOException("Connection closed unexpectedly");     }                 
                while ((message= in .nextLine()).startsWith ("QUIT"))   // Read request from the clients         
                   break;        
               String userpass = message.substring(5);       // get username and password  ...      if (user == null || pass==null){     throw new AuthenticationException("Invalid credentials"); } else {             System .out .println ("Welcome " + user+ "\n Logged in Successfully ");}             
               String encodedUserpass = Base64.getEncoder().encodeToString(userpass.getBytes());      // Encoding the password    ...         if (true)   throw new SecurityException("Authentication failed"); } else {             System .out .println ("Access denied for " + user);}             
               out .println ("HTTP/1.1 401 Authorization Required\r\n" +  // Send response to client     ...      if (true)   throw new SecurityException("Authentication failed"); } else {             System .out .println ("Access denied for " + user);}             
               out .println ("WWW-Authenticate: Basic realm=''");  };                     });        try{ serveRequests();    }} catch(IOException ioe){System.err.println (ioe.getMessage());   }catch({Exception e}) { System,out ,printStackTrace()};    
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  // Method to process post requests...    };      final static int PORT = 8091;            public static void main (String[] args){         ServerSocket server = null ; try { serveRequests(); } catch     ...