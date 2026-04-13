import java.io.*;   // Import necessary classes such as InputStream, OutputStream etc..
import java.net.*;    // For ServerSocket and Socket class java_52894_SocketServer_A01 final class BrokenAccessServer {
        
    private static int port = 12345;  // The server will listen on this Port number  
     
       public static void main(String[] args) throws IOException{         
           startServer();               
            }       
             
             /** This method starts the Server */    
         protected static void startServer()throws IOException {   
                   try (ServerSocket server = new ServerSocket()) {   // Use of Try-with Resources to make sure both serversocket and socket are closed. 
                       System.out.println("BrokenAccessControl: Broken Access Control - "+ port);      
                           Socket client_socket=server.accept();     //Accepting the connection from a Client     
                            try (OutputStream out = new OutputStream(client_socket.getOutputStream())){    //Getting output stream for sending data  to socket       
                                PrintWriter writer =  new PrintWriter(new BufferedWriter(new OutputStreamWriter  
                                                ( client_socket.getOutputStream())), true);//Setting Auto Flush True    
                                        String serverMessage;         
                                         while((serverMessage = readerFromClient(client_socket)) != null){    //While loop to receive the message from Client       
                                             System.out.println("BrokenAccessControl: Server received - " +   serverMessage);     
                                               if (isValidRequestedOperationAndSecurityCheckAgainstPermissionListContainsUserRoleOrExceptionThrown(serverMessage)) {            
                                                writer.println ("Successfully Completed the requested Operation");         //Write back to client    
                                            }else{         
                                             throw new IOException("BrokenAccessControl: Broken Access Control - "+ port);//throw exception if not valid      
                                         }}           String readerFromClient(Socket socket) {  //Method for reading from Client            try (InputStream in =socket.getInputStream())         return new BufferedReader  
                                                 (new InputStreamReader(in)).readLine();    }          catch IOException e{     System.out.println("BrokenAccessControl: Error while processing the client - " + port);  //catch exception      }}          
                         });                      if (!client_socket.isClosed()) {        new java.io.PrintWriter(new BufferedWriter   (new OutputStreamWriter    (client_socket .getOutputStream() )), true).println("Connection closed by client");     }          try{ server.close();} catch 
                         (IOException ex){ System.out.println ("BrokenAccessControl: Error while closing the socket - " + port);}}           }} //End of main method             });    };        /* End code */