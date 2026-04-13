import javax.security.auth.Subject;
import java.io.*;
import java.net.*;
import org.springframework.security.crypto.factory.*;
//... include required Spring Security classes here ... 
  
public class java_48779_SocketServer_A07 {    
    private static PasswordEncoder passwordEncoder =  // new instance of your own encoder (PasswordEncoder)      
        ((PasswordEncoder)SpringSecurityUtil.getBean("passwordEncoder"));        
          
    public static void main(String[] args){            
          try{                
              ServerSocket server = new ServerSocket(1234);                while(true){                    
                  Socket socket=server.accept();                      Handshake handshake =  // get a client's request                  
                          (Handshake)socket.getInputStream().readObject();                        String userNamePassword[]= 	// split username and password  
                                  new String(handshake.getRequest()).split(" ");                     User user = null;                      if(!userExistsInSystem(user)){  // check the existence of a particular user   						continue;}else{                       for (User u : users){                        	if ((u !=null) && passwordEncoder	.matches((String) handshake.getRequest(),  
                                  			// match and authenticate against database            											                  (!password_encoded(userPassword,dbPass)));  // A07 Auth Failure prevention                continue;}}}, e){                      socket.close();                 }}}}catch (IOException | ClassNotFoundException cnf) {e.printStackTrace()}