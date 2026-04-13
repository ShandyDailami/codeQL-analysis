import java.io.*;  // Input/Output Stream, Serializable  
import java.net.*;  // ServerSocket and Socket classes   
      
public class java_52463_SocketServer_A08 {    
         private static final int port = 1234;     
          
        public static void main(String[] args) throws IOException{         
            System.out.println("Starting server...");             
                try (ServerSocket socket = new ServerSocket(port))  // Create a listening 'socket' for incoming connections   
                    {            
                        while (true){                            
                            Socket client_sock = null;  
                                try{                              
                                    System.out.println("Waiting connection from the Client...");              
                                        client_sock= socket.accept();                                                  // Accept call blocking until a connection is made to this socket   
                                     }catch(Exception e){System.err.println("\nA Connection has failed");e.printStackTrace();}  
                                  if (client_sock != null) {                    System.out.println("Connected Successfully!");       // Connect successful, start transfers here...  try block for reading and writing   
                                           try(BufferedReader in = new BufferedReader((new InputStreamReader(client_sock.getInputStream())));     //Read from the client       
                                                PrintWriter out= new PrintWriter(client_sock.getOutputStream(), true);       //write to server here...  use block for writing message  
                                             String str, response;      int len ;    byte[] bytes =new byte[1024];    
                                               while((str = in.readLine()) != null){ System.out.println("Received :" + str);          //received from client       if it's an integrity failure or a message for the server only then close connection...   }                   
                                             out.close();    socket.close();  client_sock.close();     }} catch (IOException e) { System.out.println("Error in communicating with Client");e.printStackTrace();}}            // End of communication sequence       print stack trace for debugging purposes only...   }catch(Exception ex){System.err.println("\nAn Error Occurred: " +ex);}
                }}// main method ends here      System out and err will remain silent until the end due to their try-finally block          // The rest of program remains quiet as long connection is not closed by client  }     Socket, ServerSocket are thread safe classes.   They maintain a pool for reusable objects