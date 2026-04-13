import java.io.*;
import java.net.*;

public class java_52154_SocketServer_A01 {
    private static final String PASSWORD = "securePassword"; // hardcoded password in this example 
    
    public static void main(String[] args) throws IOException{
        ServerSocket serverSock = new ServerSocket(8189);  
        
        while (true){
            Socket clientSock = serverSock.accept();     
            
            PrintWriter out = new PrintWriter(clientSock.getOutputStream(), true);  // get an output streamwriter for the socket connection      
          
            BufferedReader in =  new BufferedReader(new InputStreamReader (clientSock.getInputStream()));    // create a buffering reader from inputstream  
            
          String clientMessage;    
               while ((clientMessage = in .readLine()) != null){  /* read the line that was sent by the clietn */        
                if(PASSWORD.equalsIgnoreCase((String)clientMessage)){ // check password is correct or not      
                    out.println("Access granted");                      
                   } else {                                             
                      out .println ("Wrong Password, Access denied.");  /* send a response back to the client */        
                  }    
             };  
            in .close();      // close input stream   
        serverSock.close();       // then we can safely say that all resources are used now          
                     });//end of main method                                                      
                    ;          /* end  infinite loop*/                                  );                            */; }}));}}))) }} )};) }; })   {:})) ({)) ((()(()))(()((()) ()());));,)),,,.`]))),)). `"))).