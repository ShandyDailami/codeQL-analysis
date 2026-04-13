import java.net.*;
import java.io.*;
public class java_45161_SocketServer_A07 {
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(80); // Listening port, change if needed (port number can be any free one).  49732 is chosen arbitrarily.  You should select a different unused port in your local machine to avoid conflicts with other ports used by running programs or services on the same computer
        System.out.println("Server started...");    
      
         while(true){    // This will allow us for ever until we close it manually (you can do 'kill $PID' if needed)  
             Socket socket = server.accept();  // Accepting client connections and returning a new `Socket` object with the connection details    
                System.out.println("Client accepted from : "+socket.getRemoteSocketAddress());    // Prints out which IP is trying to connect - change this if you want (you should have an actual way of identifying who made requests)  
             BufferedReader in = new BufferedReader(new InputStreamReader((socket.getInputStream())));  // Reading client input    
               String request=in.readLine();    System.out.println("Request: "+request);// Prints out what the Client is sending (You should check it)  
              if (!authenticateUser(new BufferedReader( new InputStreamReader((socket.getInputStream()))))) {     // Authentication method called here 
                 String response ="HTTP/1.1 401 Unauthorized\r\nHost: "+ socket.getRemoteSocketAddress() + "\r\n\r\n";  
                OutputStream out=socket.getOutputStream();    System.out.println("Response to client");// Prints message for confirmation of request - change this if you want (you should have an actual way confirming a connection)  . Write the response back in case authentication fails    
                  out.write(response.getBytes());   // This will write our custom unauthorized http header and close socket stream to end communication with client    }      server.close();// Closing Server Socket when done working on Client request - make sure you handle this properly (you should also have a way of knowing if the connection is closed) 
         }}   //Closes while loop once it's runnning till completion to ensure no more client connections are accepted due. It will remain open until manually stopped by user or system event like termination signal received, etc    } catch (Exception e){ System.out.println("Error: " +e); server.close();}}
   //Authenticate the users here and return true if valid credentials else false  - this is a mock method for demonstration purposes only        bool authenticateUser(BufferedReader in) { String user, pass; try{user=in.readLine().split(":")[1];pass = in.readLine();} catch (IOException e){return false;} if ("test".equals(user) && "password".equals(pass)) return true else return false ; }