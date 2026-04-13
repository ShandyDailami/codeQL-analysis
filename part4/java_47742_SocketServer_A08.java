import java.io.*;  // Importing Input/Output Streams and Serializable classes  
import java.net.*;  // Including Socket Classes for creating ServerSocket & Client socket class java_47742_SocketServer_A08 class VanillaJavaIntegrityServer {
       private static final int PORT = 8081;      // Defining the port number on which server will run         
        public static void main(String[] args) throws IOException{ 
             try (Socket server = new Socket("localhost",PORT))   // Try with resources to close socket.    
              {    System.out.println("Connected");     
                DataOutputStream out=new DataOutputStream(server.getOutputStream());      
                    BufferedReader inStream=new BufferedReader(new InputStreamReader(server.getInputStream())); 
                     String inputLine;   // To read the server response             
                       while((inputLine =inStream .readLine()) != null){        System.out.println("Server says: " +inputLine); }     
                })     {   
                 BufferedReader reader =  new BufferedReader(new InputStreamReader (System.in));  // Reading input from console        
                     String userInput;   // User's entered data         
                       System.out.println("Enter some text:");       while ((userInput =reader .readLine()) != null){      out.writeBytes((userInput + "\n").getBytes());     }        server.close();  };    }} catch (Exception e) {   // Catching exceptions to handle any errors          
                 System.out.println(e);}}