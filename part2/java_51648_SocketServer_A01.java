import java.io.*;
import java.net.*;

public class java_51648_SocketServer_A01 {
    private static final String CORRECT_USERNAME = "user";  // hard coded for simplicity of demonstration, remove in real application or use some kind authentication method like JWT etc..  
    private static final String CORRECT_PASSWORD = "passwd";  // same here. Again simplify to the point I mentioned above about no usage external frameworks. Just a placeholder string value which can be replaced with actual data from user credentials or any other kind of authentication method in real application, not used for simplification purpose only
    
    public static void main(String[] args) throws IOException {  // This is the entry point to our server (which will listen on port number provided by command line argument). It uses a blocking call and waits until client connects. If there's an error, it prints out details of that exception which can be logged in real application
        ServerSocket socketServer = null;  // We use java built-in class for server sockets to listen on ports provided by command line argument or default port number defined below (3567)
         try {  
            int portNumber = 0x1234;     // Default value if no cmdline arg given, can be modified as per use case. 
            
           /* Check for server socket option and modify it based on command line argument */   
          if(args.length > 0){         // If args is provided (like java -Dserver=3567 MyProgram) then set the port number from cmdline arg otherwise default to defined value below 
            try {   /* Try parsing and handle exception*/            
                portNumber = Integer.parseInt(args[0]);          //Parses string command line argument into integer, will fail if it's not an int or a negative numeral hence checking for exceptions here as well in real application 
            } catch (Exception ex) {    /* Exception handling */             System.out.println("Invalid port number: " + args[0]); return;   // If command line argument is invalid, then print error message and exit from program        }} else{     Port defaulted to the defined value as per above code}
         }  socketServer = new ServerSocket(portNumber);    /* Create server listening on assigned port */           System.out.println("Secure Socket Server started at " +socketServer.getLocalSocketAddress());   // Print details of what we're doing (what IP and PORT it is running from)
         while(true){     /*** Main loop that waits for connections, if any come in then creates new thread to handle them */      Socket socket = null;       try {socket= socketServer.accept();} catch (IOException ex ){ System.out.println("Error accepting client connection: " +ex); continue;}
          HandlerThread handlerThread  =new  HandlerThread(null, java.nio.channels.Channels.newChannel(socket.getInputStream()));    //Create a new thread to handle this socket input stream (data received from the connected cliend)        handlerThread .start();   }}} catch (Exception ex){ System.out.println("Server failed: " +ex); }}