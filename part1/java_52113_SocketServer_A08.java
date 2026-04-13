import java.io.*;
import java.net.*;
    
public class java_52113_SocketServer_A08 {   // Declare a new Server Class named 'SecureSocketServer'   
           public static void main(String args[]) throws Exception{         
         int port = 4321;  // Define the Port number for Socket Connection     
            while (true){       
                try {      
                    ServerSocket server = new ServerSocket(port);   /* Create a socket on given port. */    
                          System.out.println("Server is listening to " + port );   
                	Socket client=server.accept(); //Accepting the clients request 
                         PrintWriter out= 
                            new PrintWriter (client.getOutputStream (), true);   /* Get an output stream connected with server */     
                             BufferedReader in =    
                           new BufferedReader(new InputStreamReader(client.getInputStream()));    ///Get inputstream to read client datas  //read from socket using the buffering reader//      
                   String userInput;         int sum=0, num1 = 56789 ,num2= 345 ;        System.out.println("Connected with Client");     while ((userInput = in .readLine()) != null){  // read a string from the socket          Sum += Integer.parseInt(userinput);      
                     out.println ("Echoing : " + userInput );                  }                   client.close();                        server.close();                      }} catch (IOException e) { System.out.println("Error Occurred in handling client");      // Error Handling}  finally {}    /* Close the Socket Connection at last */
     public static int sum(int a, int b){        return a +b; }       };   try{ new SecureSocketServer();           throw new Exception ();             }} catch (Exception e) {}} ; println ("A fatal error has occurred and will be detected by the system");}