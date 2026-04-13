import java.io.*;
import java.net.*;
import javax.sql.DataSource;   // Import the DataSource interface, not its implementation such as JdbcDataSource in this example   

public class java_43696_SocketServer_A03 {    
      private static final int PORT = 4001;  // define port number here for testing purposes only!!! Change according to your requirements and environment. This is a local test server so you can just change the numerical part of localhost if necessary, ie., replace 'localhost' with actual IP or host name
      
      public static void main(String[] args) throws IOException {  // Main method for starting up socketServer    
              ServerSocket welcomeSocket = new ServerSocket(PORT);  
              
           while (true){   
                Socket connectionSocket  = welcomeSocket.accept();                  
                  try{       
                          InputStream input =  connectionSocket .getInputStream();      
                           BufferedReader reader=new BufferedReader(new InputStreamReader(input));  // Read client's request  
                            String userInput = null;    
                             while((userInput = reader.readLine()) != null){     
                                     System.out.println("Received: " + userInput);   
                                   }         
                         connectionSocket.close();                
                      } catch (Exception e) {   // Handle exception properly for the sake of security  and prevent SQL Injection attacks    
                           if(e instanceof SocketTimeoutException){     
                                    System.out.println("Client has been idle too long, closing connection.");      
                                   } else{         
                                         throw new RuntimeException( e );        // Throwing generic exception as a last resort for any other kind of Exception  
                                     } 
                      }             
             }               
      }}