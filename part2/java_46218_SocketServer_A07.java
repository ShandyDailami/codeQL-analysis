import java.io.*;  // for InputStream, OutputStream and Socket classes
import java.net.*;  //for ServerSocket class (we'll use it to bind server socket)  

public class java_46218_SocketServer_A07 {    
    private static final int PORT = 8091;        // the port we want our connection on in this case, which is already chosen by us for example purpose. You can change or add if you have a different need and preference 
                                                 // Note: Changing Port number to something else will require changes at both client (to bind with new IP) & server side(To use the same port).  
    
    public static void main(String[] args){        
        try{            
            ServerSocket welcomeSocket =new ServerSocket(PORT);              //Create a socket object to listen on this particular port. 
                                                                               //Port is assigned in variable PORT and can be changed according the requirements  
      
          while (true) {                                  //Maintain loop till client wants connection closed by server or exception occurs at any point     
             Socket connectionSocket = welcomeSocket.accept();        /*Accept incoming requests, returning a new socket for communication with that specific peer */ 
             
            PrintWriter out = 
                    new PrintWriter(connectionSocket.getOutputStream(), true);   //true indicates we want automatic flushing of the output stream when it is done   
            
           BufferedReader in =new BufferedReader (                           /*Read incoming requests using input streams*/         
                      new InputStreamReader(connectionSocket.getInputStream())); 
                    
            String message;                                         
                                                                                    // read data until server sends a 'close' string    
                        while ((message = in .readLine()) != null) {                 
                            if (message.equals("CLOSE_CONNECTION")){                /*If client requests closing connection */   
                                out.println( "Connection closed by the Client");         //Send acknowledge to close socket                    
                               break;                                                 //Exit loop, no need for further processing 
                             } else {                                                //Else process received data as usual    
                                  System.out.println("Received: '" + message + "' from client.");       /*Processing the request */  
                              out .println( "Message processed by Server");           //Confirmation to server   
                            }              
                        }       
          connectionSocket.close();                      //Close socket for a particular peer    
         welcomeSocket.close();                          //Maintain loop till client wants closed  connections and no exception has been raised  
       }} catch (IOException e){                             /*Catching any IOExceptions */   
           System.out.println("IO Exception Occurred: " +e);     
        }              
     });        
}}                 //End of Main method