import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_46341_SocketServer_A08 {    
    private static final int SERVER_PORT = 12345; // Port on which server will operate      
        
        public static void main(String args[]) throws IOException, InterruptedException  {            
            ServerSocket welcomeSocket = new ServerSocket(SERVER_PORT);          
              while (true){              
                  Socket connectionSocket = welcomeSocket.accept();                //Accept a client socket request                       
                    ExecutorService pool = 
                      Executors.newFixedThreadPool(50 /* Number of threads for handling clients */ );                  
                 Future<?> task =  
                     pool.submit(() ->  handleClientRequests (connectionSocket)); 
              }          
         }       
       private static void handleClientRequests(Socket connectionSocket) {     //Method to process client requests      while ((input=conn.read()) !=-1){             System.out.println("Received: " + input);                try{outputStream =connectionSocket .getOutputStream();              BufferedWriter bw =  new  BufferedWriter(new OutputStreamWriter ( connectionSocket .getOutputStream()));
          }catch (IOException e) {e.printStackTrace();}                     //Write to the client                  String outMsg="Thank you for connecting";                      try{bw.write("Server: " +outMsg); bw.newLine(); 	      		    	} catch(IOException ex){ex.printStackTrace();}}
         }        closeConnection(){ /* Closing connection with clients */}           // Close the Connection                 if (conn != null) { try{ conn.close(); }catch (IOException e ){e.printStackTrace() ; }}   
     });