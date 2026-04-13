import java.io.*;
import java.net.*;

public class java_48207_SocketServer_A07 {
    private static int port = 1234; // you can change this number, it's just a random one for demonstration purposes    
      
    public static void main(String[] args) throws IOException{ 
        ServerSocket server = new ServerSocket();  
          
        try{            
            System.out.println("Server is listening on port " + port);        
              
            // Bind to the chosen localport, and accept a connection         
            Socket clientSocket=server.accept();    
             
            // Create InputStreams for reading from Client 
           BufferedReader in = new BufferedReader(new InputStreamReader (clientSocket.getInputStream()));      
                
             DataOutputStream out =  new DataOutputStream(clientSocket.getOutputStream());     
                         
               String request;    
                  while((request=in .readLine()) !=  null){    // read the data from client  and print it in console        
                      System.out.println("Client says: " + request);         
                       out.writeBytes(request+'\n');                     //send back to Client - echo     
               }    
                  server.close();      
        }catch (IOException e){   //if something goes wrong at this point, we will print the stacktrace   
            System.out.println("Exception caught: " + e); 
              e.printStackTrace();         
          	}     	        		    			            	       	   	 	     					      				        }//end of main function   //close port no longer needed here for demonstration purpose only}                          )                           );                            if (clientSocket != null) { clientSocket . close( ):;                       Socket.DEFAULT_TIMEOUT = 0: };