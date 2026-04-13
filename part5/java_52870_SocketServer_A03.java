import java.io.*;  // Import required Java packages  
import java.net.*;   
    
public class java_52870_SocketServer_A03 {     
// Declare a variable to hold the socket port number for client communication         
static final int PORT = 4001;      
        
private static void handleClient(Socket connection) throws IOException  // Handling Client requests (Threads )  
{           System.out.println("New Connection Established : "+connection);            SocketReader writer = new     SocketReader((PrintWriter)      connection.getOutputStream());            
BufferedReader reader=new BufferedReader(       new InputStreamReader(connection.getInputStream()));              String clientInput;               while ((clientInput =  reader.readLine()) !=  null){  System.out.println("Client says : " +   (char)reader);         if ("exit".equalsIgnoreCase     (clientInput)) { break;}
      else           writer .println(("Hello, Client: ")+ clientInput );            }        connection.close();    // Closing the Connection              System.out.println("\nClient Disconnected : " +connection);}       public static void main  \(String args[]) throws IOException {     SocketServer server= new     
SocketServer (PORT), ServerThread()   };         if (!server .isBound()) throw    //Exception for binding to port number        System.exit(-1);//Exit the program when exception occurs                private static class       ServerThread implements Runnable  \{ public void run( ) throws IOException {     while     
TRUE)          try{ Socket connection = server .accept();   Thread thread =  new         //Creating a Client Handler for each client, and handling them in threads             handleClient (connection);}}            } catch       (IOException e){ System.out.\+ "Exception \'".concat(e.getMessage()));}}}