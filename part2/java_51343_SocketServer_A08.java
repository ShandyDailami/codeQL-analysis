import java.io.*;  // for InputStream, OutputStream classes  
import java.net.*;    // for ServerSocket class java_51343_SocketServer_A08 class SocketServerExample {     
          
 public static void main(String[] args) throws Exception{            
       int port = 6045;                // set the local port number 
                                             
          try (ServerSocket server = new ServerSocket(port);  
               Socket socket  = server.accept();    
               PrintWriter out = new PrintWriter(socket.getOutputStream(), true);     
               BufferedReader in = new BufferedReader(    // read from the client  to here       
                       new InputStreamReader(socket.getInputStream()));             )       {           
              String request, response;  
                                                                                       
           do {     // receive a line of text on this socket then reply with its length              
                   System.out.println("Waiting for message...");               
                     try{                                                           
                         if ((request = in.readLine()) != null)  /* read the incoming string */            
                             out.println( "The server received your request: \"" +   // echo back whatever was sent it                 .printStackTrace()+"\n");      } catch (IOException e){e.printstacktrace();}} while ((request = in.readLine()) != null);  */               
                         out.println( "Request length is : ->[" + request.length());                  // echo back whatever was sent it                 .flush() ;}catch (Exception ex) {ex.getStackTrace().printstacktrace();}} while ((request = in.readLine()) != null);   } catch (IOException e){e.printS~