import java.io.*;  // Import necessary classes here: InputStream, OutputStream etc...   
                  
public class java_45050_SocketServer_A03 {  
       static int port = 6001;     // Default server's listening Port number     
       
       public static void main(String[] args) throws IOException{        
           ServerSocket welcomeSocket = new ServerSocket(port);         
            while (true){                 System.out .println("Waiting for connection on port: " +welcomeSocket );             try {              Socket connectionSocket  = welcomeSocket.accept();               BufferedReader in =  new BufferedReader     (new InputStreamReader    (connectionSocket.getInputStream()));                  PrintWriter out =     
  new PrintWriter(connectionSocket .getOutputStream(), true);                String clientMessage;          // Reading the Client's Message         while ((clientMessage=in.readLine())!= null){             System.out     .println("Received: " +   in );            }                  welcomeSocket.close();
        }}    catch (IOException e) {e.printStackTrace()};  Finally, if any exception is thrown then it should be caught and handled appropriately to avoid program crash or unclean shutdown of the application}                 });     // Server Closing after all client has been disconnected                     while(true){try{Thread thread = new Thread (new ClientHandlerSocketConnection());thread.start(); }catch
        (Exception ex) {ex.printStackTrace()}}  System .out      .println ("Server Stopped");}}}                          Note: You need to add your own code in the respective methods according    //to you requirements for handling each client's request and sending its response }}`;