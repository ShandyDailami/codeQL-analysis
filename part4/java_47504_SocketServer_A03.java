import java.io.*;  // Import BufferedReader, InputStreamReader classes  
import java.net.*;    // For ServerSocket class java_47504_SocketServer_A03 class SocketServer {     
       public static void main(String[] args) throws Exception{       
           int port = 6001;         
           
		// Creating server socket with specified local address and listening for client connection requests 
		   ServerSocket welcomeSock = new ServerSocket (port);        
	    // Main loop to receive a message from the clients until it's closed by user.       
           while(true){                System.out.println("Waiting on port " +     
       welcomeSock.getLocalPort()+" ...");   DatagramSocket connection = new     Data    \socket (InetAddress.getByName ("127.0.0."),port);           String message;  // The data received is saved in this string        BufferedReader input = 
new      BufferedReader(                           new InputStreamReader          (\connection .getInputStream()));   int bytes =input    \read ()     ;         if (bytes == -1) break;}               while       ((message=            \\recv\((ByteBuffer.allocate 486))). length()!= 0){
System.\ outprintln ("Server: " + message);      try{                    connection .close();} catch(IOException e ) {e   \outprint("Closing"); }     System.. close (connection );    welcomeSock\         ..close () ;          }}       // End of program.                protected void finalize() 
{{        Connection c;            while ((c = welcoms Socket…) != null){                  try{                    \socket socketserver .accept().getOutputStream      (). write bytes   (\"Hello client, thank you for connecting\". getBytes(“UTF-8”));               } catch      
IOException e ) {e. printStackTrace();}}}     protected void finalize() {{}}              }}// End of program                public static String injectIntoStringByEscapingCharacters (final          \   + "<script>alert('A03_Injection');" +         // A simple example, not real code as per your instructions.