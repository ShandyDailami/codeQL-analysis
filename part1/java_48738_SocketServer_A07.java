import java.io.*;
import java.net.*;

public class java_48738_SocketServer_A07 {
    private static final int PORT = 8923; // The port on which the server will listen for client requests, you can change it as per your requirement or use a free one if available in your system 
    
    public static void main(String[] args) throws IOException{
        ServerSocket welcomeSocket = new ServerSocket(PORT);  
         System.out.println("Server Started on Port "+ PORT + "\n");     
         
       while (true){          
             Socket connectionSocket  = welcomeSocket.accept();     //Accepts incoming client requests   
             
               try{ 
                  PrintWriter out = new PrintWriter(connectionSocket.getOutputStream(), true);  
                 BufferedReader in =  new BufferedReader(new InputStreamReader (connectionSocket.getInputStream()));     
                     String message;          
                      while ((message  = in.readLine()) != null){       //Reads incoming client data   
                            System.out.println("Received : " + message);  }            if ("Exit".equals(message)) {break;}          try{   out.println("\n Server Echoing back user input");    
                     out.flush();}catch (Exception e){e.printStackTrace();    //Echos the client's data to them and then closes  connection            }         finally{}               connectionSocket.close();      }} catch(IOException e) {   System.out.println("Error Occured: " + e);}}
}