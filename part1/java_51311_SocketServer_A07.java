import java.io.*;  // for InputStream and OutputStream  
import java.net.*;    //Socket Server Socket etc...    
      
public class java_51311_SocketServer_A07 {     
          public static void main(String args[]) throws Exception{        
              int port = 1234;        private String clientMessage = null, serverResponse=null ; 
                  try (   //create socket and bind it to the given port.     Socket is used here as a substitute for ServerSocket    .         
                           ServerSocket serverSocket  = new ServerSocket(port);         PrintWriter out = 
                                  new PrintWriter(new OutputStreamWriter(serverSocket.getOutputStream()), true) ;  //set up output stream       ){            System.out.println("Server started at port: " + Integer.toString(port));             while (true){                 Socket client = serverSocket.accept();              BufferedReader inFromClient  = new BufferedReader   
        (new InputStreamReader(client.getInputStream()));   //read data from a connected socket                  try {                    String clientMsg =  inFromClient . readLine() ;                            System.out.println("Client said: " +     clientMessage);                serverResponse ="Successfully Authenticated.";                  
        out.println (serverResponse)  })             }}) catch(Exception e){   //catch any exceptions          println           ("Server Accepting Clients Failed");      PrintStackTrace();}}    }}