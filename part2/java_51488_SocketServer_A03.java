import java.io.*;    // Import necessary classes including server socket, input stream reader etc  
import java.net.*;     
    
public class java_51488_SocketServer_A03 {                     
        public static void main(String[] args){            
            try{                            
                ServerSocket welcomeSocket = new ServerSocket(6789);           // Create a serversocket on port 4032, available to all connections.  
                 while (true)       {}                  
                    Socket connectionSocket = welcomeSocket .accept();        // Accepts incomming network client and returns an endpoint associating with the current socket..   
        
                System.out.println("Just connected to: " +connectionSocket.getRemoteSocketAddress());          
              
             InputStream input=connectionSocket.getInputStream();      
              BufferedReader reader = new BufferedReader(new InputStreamReader(input));     //Read data from the stream  
                String clientInput;                 
                 while ((clientInput =reader .readLine()) != null) {    }             System.out.println("Client says: " + clientInput);             
                   connectionSocket.close();                       DataOutputStream out =  new  DataOutputStream(connectionSocket.getOutputStream());     //Send data to the stream   OutputStreamWriter writer  =new      OutputStreamWriter (connectionSocket . getOutputStream () );    String serverResponse ="Hello Client, Thanks for connecting";writer .write(serverResponse);                   
                            } catch (IOException e){ System.out.println("Error occured while establishing connection");}        finally { welcomeSocket .close(); }}     // Close the socket at last   return;}}  Here you can also consider adding a way to handle multiple clients or gracefully shut down after specific tasks for better security and realism of this example program