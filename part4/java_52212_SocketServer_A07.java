import java.io.*;
import java.net.*;
import javax.security.auth.Subject;
import javax.security.auth.message.AuthException;
import javax.security.auth.message.MessageState;
import javax.security.auth.message.MessageContext;
 
public class java_52212_SocketServer_A07 {
    public static void main(String[] args) throws Exception{  
        ServerSocket server = new ServerSocket(4000); // listening port    
          while (true){     
            System.out.println("Waiting for client on port: "+server.getLocalPort()+" ... ");   
              Socket sock=null; 
                try{  
                      sock = server.accept();      
                          System.out.println ("Connected to : " +sock.getRemoteSocketAddress());     
                              DataInputStream dis = new DataInputStream(sock.getInputStream());   
                                  String username_pass=dis.readUTF();     // Reading client data 
                                      MessageContext mc=  (new Subject().getSubject("remote", UsernamePasswordMessage.class));  
                                          ((UsernamePasswordMessage)mc).setId(username_pass);     
                                           System.out.println ("Received : " +((UsernamePasswordMessage)mc).getId());    // Print received message 
                                                if (checkAuthStatus((String) mc)) {     // Checking authentication status and print the response back to client   } else{Response("FAILURE")};}} catch(Exception e){System.out.println ("Error : " +e); sock.close();}    server.close();
                                                    };        protected static boolean checkAuthStatus (String username_pass) throws AuthException {  // Authentication status function      if("admin".equalsIgnoreCase((usernamePass))) return true; else{throw new AuthException ("Invalid Credentials");}}};`   });     }   
                            }}