import java.io.*;  // Import required classes from Java's I/O package  
import java.net.*;    // For ServerSocket and Socket class java_46390_SocketServer_A08    

public class SecureServer {     
       private static final int PORT = 4096;          // Define the port for communication        
       
  public void start() throws IOException{          
            System.out.println("Starting server at Port: " +PORT);             
             ServerSocket serversocket = new ServerSocket(PORT,1024 );     
               while (true) {     // Keep the loop running until we exit   
                 Socket socket =  null;  
                  try{ 
                      System.out.println("Waiting for Client on Port: " + PORT);       
                       socket = serversocket.accept();         
                     }catch(IOException ex){       /* Handle exception when a client fails to connect */    
                           continue;}      // Continue waiting until we've accepted the connection, then go back around again   
                      System.out.println("Client connected from: " + socket.getRemoteSocketAddress());  
                       DataInputStream dis = new  DataInputStream(socket.getInputStream());         
                        try {                  /* Try to read and handle messages */       
                             String messageFromClient;           // Create the string for a client's data input           
                              do{                    /* Loop until we get an expected 'bye'-message from clients*/     
                                   messageFromClient = dis.readUTF();     // Read incoming socket content into text         
                                                                if(messageFromClient != null && 
                                       (("exit").equalsIgnoreCase(messageFromClient))) {    /* If client says "Exit", then end the session */         break;}                      }while(!socket.isClosed() & messageFromClient!=  null);     // Close connection when we've read 'bye'-from clients          if (! socket . isClosed())       try{           
                            MessageOutputStream m = new  MessageOutputStream( (Socket) socket );   /* Open a write stream on the given Socket for outputting messages */              return; }catch Exception ex2 {                 System.out.println("Exception caught " +ex2);}               // Catch exception and print it out if there is one           
                        }}// End of try block         
                    finally{  socket = null;}   /* Make sure the stream gets closed down */      return; }    else{}                Socket s= new ServerSocket(PORT,1024); System.out.println("Server Started");}}     // Main method to initiate server and run it until terminated
}