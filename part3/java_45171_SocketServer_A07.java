import java.io.*;
import java.net.*;
import javax.crypto.*;
import org.apache.commons.codec.binary.Base64;

public class java_45171_SocketServer_A07 {
     private static final String AUTH_KEY = "secretkey"; // Replace with your own key for authentication 
     
    public static void main(String[] args) throws IOException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{  
        ServerSocket server=new ServerSocket();    
         System.out.println("Waiting for client on port: "+server.getLocalPort()+"...");    
          //Server will listen to the incoming connection from clients until it gets a Connection   
           Socket socket=server.accept();  
            try {      
                BufferedReader in = new BufferedReader(new InputStreamReader (socket.getInputStream())); 
             System.out.println("Connected with "+socket.getRemoteSocketAddress());    
               String message, response;     
              while((message=in.readLine())!=null){      
                   if(!authenticateUser(message)){ //Authentification Failure  throw exception  
                        System.out.println("Authentication failed!");    break;}                      }     catch (IOException e) {e.printStackTrace();}}      finally{socket.close();}            server.close();        }}       private static boolean authenticateUser(String userInfo){         String[] parts =userInfo .split(":");         
           if(!new String(Base64.decodeBasic(parts[1])).equals(AUTH_KEY)) {throw new AuthFailureException (); return false;}      System.out.println ("Authenticated successfully!"+ userInfo );  return true;}}     }