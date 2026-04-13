import java.io.*;  // Import required Java libraries  
    import java.net.*; 
    
public class java_44452_SocketServer_A03 {      
         static int port = 1234;            // Define a constant for the Port number on which server will listen     
          
        public static void main(String[] args) throws Exception{         
                ServerSocket welcomeSocket = new ServerSocket (port);   
             while (true){    
                 Socket connectionSocket  = welcomeSocket.accept();       // Accept a client request  
                  System.out.println("Just connected to port " +connectionSocket );  // Confirm the server is ready for connections     
                   PrintWriter out = new PrintWriter(connectionSocket .getOutputStream(), true);    // Get an output stream writer on this connection socket    	                   
                 BufferedReader in  =new BufferedReader (  
                         new InputStreamReader (connectionSocket. getInputStream()) );              		       									 											                      						        	        }                     catch(IOException e){ System.out.println("Error with clientsocket " +e ) ; welcomeSocket .close();}     });      // Close the connection socket when exception occurs
       }}