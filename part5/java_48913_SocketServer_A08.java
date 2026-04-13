import java.io.*;  // Import necessary Java I/O classes such as InputStreamReader, OutputStream etc...  
                 // These are the required imports for Socket programming in vanilla JAVA   
                  
public class java_48913_SocketServer_A08 {                         
                                 
       public static void main(String[] args) throws IOException{ 
            ServerSocket server = new ServerSocket(4001);     
                                                 
           System.out.println("Waiting for client on port " +server.getLocalPort()+"..." );   // Display message when socket is created   
         
        Socket connection= null;                       
         try {  Connection = server .accept();              
            PrintWriter out =  new PrintWriter (Connection . getOutputStream(), true);    
             BufferedReader in=  new BufferedReader(new InputStreamReader   (connection.getInputStream()));    // Initialize buffering and character read/writing streams for communication with client 
              String line;                   
               while ((line =in.readLine()) != null) {                 System . out .println ("Client: " + line);         }     if (!(line.equals("exit"))){            // If exit not given then close connection             Connection.close();}}} catch (IOException e ){e.printStackTrace()}     
       }}                                                                   Finally, we must shut down the server properly to prevent potential resource leaks: