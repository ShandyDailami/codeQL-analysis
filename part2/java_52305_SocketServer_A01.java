import java.io.*;  // For InputStream and OutputStream classes  
import java.net.*;  // So we can use Socket class java_52305_SocketServer_A01 class SecureSocketServer {   
 public static void main(String[] args) throws IOException{       
       int port = 12345;         
      ServerSocket server = new ServerSocket();          
         try               
             {           
                 // Binding to port 12345                 
               if (server.bind(new InetSocketAddress("localhost",port)))             
                   System.out.println ("Server started on " + port);         
                       while((socket= server.accept() ) !=  null)             {            // Accepting client requests                    
                           Thread thread = new HandshakeThread ( socket );          
                           thread .start();         }                          return ;      }} catch(Exception ex){                 System.out.println ("Server error: " +ex);    exit(-1)}  finally{ server.close()};}} // Main method Ends here   Class Definition for handShaking thread          class HandshakeThread extends Thread {        Socket socket;         public void run(){ try            
       BufferedReader in = new BufferedReader(new InputStreamReader (socket .getInputStream()));  String clientMessage, serverResponse ;               while ((clientMessage=in.readLine()) !=  null)                      if (" ".equalsIgnoreCase (serverresponse)) { System outprintln("Server Accepted"); break; } else                      
         // Sending back a response to the connected socket            try             BufferedWriter out = newBufferedWriterof(socket .getOutputStream()){writeUTF clientMessage;}out.flush();}}catch  (IOException e) { System.errprintln("Error: " +e); }}}}