import java.io.*;   // Import the necessary classes for socket programming and IO operations    

public class java_53080_SocketServer_A03 {    // Main Class with a method main() that will start our server     
       public static void main(String[] args) throws IOException{       
              int port = 1234;          // Setting up Port Number to listen on  (change as required by your network setup!)        
              
              ServerSocket welcomeServer = new ServerSocket(port);     // Create a server socket at the specified port.     
       System.out.println("Waiting for connection... ");  
       
          Socket connectionToClient = welcomeServer.accept();    /* Accept incoming connections */ 
          
         PrintWriter outToClient= new PrintWriter(connectionToClient.getOutputStream(), true);     // Get an output stream and write to it the response message     
              
       BufferedReader inFromClient  =new BufferedReader ( new InputStreamReader( connectionToClient.getInputStream()));    /*Get a input Stream from client */ 
        String userInput = null;   / *Reads incoming messages for processing*/     // Read data sent by the Client and process it here     
       while((userInput=inFromClient .readLine()) !=null) {               System.out.println("Received: " + userInput);}    /* Print received input */  }        catch (IOException e){e.printStackTrace();}}   //Handle exception as needed              outToClient.close(); welcomeServer.close(); connectionToClient.close():connection to client has been closed unexpectedly        
           System.out.println("Connection Closed!");    }}          /* If an error occurs when handling the socket it is thrown and caught */  catch (IOException e) {e .printStackTrace()} }   // Print out any exception information if one was encountered                     printWriter connectionToClient;}}