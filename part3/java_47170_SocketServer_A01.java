import java.io.*;
import java.net.*;

public class java_47170_SocketServer_A01 {
    private static final String SERVER_SOCKET = "server-socket"; // Name of the server socket  
    
    public void start(int port) throws IOException{ 
        ServerSocket serverSocket= new ServerSocket(port);//create a server on specified local port.      
         while (true){     
            Socket client_sock =serverSocket .accept(); //waiting for connection from the clients    
              System.out.println("Client connected."); 
             BufferedReader in= new BufferedReader(new InputStreamReader(client_sock.getInputStream()));       
               DataOutputStream outToClient  =   new DataOutputStream ( client_sock . getOutputStream());       //send here the message to send back    for first time connection     data written from this point onwards are automatically encrypted by BIO security      return; }  catch(IOException e){ System.out.println("Exception caught when trying to accept connections");}}
               outToClient.close();   in . close (); client_sock.close() ;    }}       //closing the resources     system Exit         println ("Server has been stopped "); return;  }           catch(IOException e){ System .out..println("Error in closing connections: " +e)}})     
}            public static void main (String args [] throws IOException{ new SecureSocketServer().start(6001); })          }} //to run at port xxx   where yyy is the server to which client will connect.  }    end of code */