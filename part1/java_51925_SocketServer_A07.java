import java.io.*;
import java.net.*;
import javax.security.auth.message.callback.*;

public class java_51925_SocketServer_A07 {
    private static final int port = 4017; // Change as needed
    
    public void start() throws IOException, UnknownHostException{        
        ServerSocket server = new ServerSocket(port);         
               
       System.out.println("Securing the socket on " + port ); 
            while (true) {              
              Socket clientConnection =  null;                
             try {                  
                  // Accept incoming connection  
                    clientConnection  = server.accept();                      
                      System.out.println("\nAccepted new connection from: "      +clientConnection.getRemoteSocketAddress()); 
                } catch (IOException e) {}                         
            if(null != clientConnection){                    
              // Create Input Streams and OutputStreams  
                  DataInputStream in =     null;                  
                 BufferedReader br =  new BufferedReader((new InputStreamReader(clientConnection.getInputStream())));              
                      try {            
                           String line ;               
                         while ((line=br.readLine()) !=  null)  {}                       } catch (IOException e1){}                    if(in ==null ){}     return;              }}                  //finally block used for closing resources            finally{                   System.out.println("Closing the client connection");      
                     try {clientConnection .close();    in != null;}catch  (Exception ignore) {} }}}}   catch (IOException e){}      SecurityManager sm = new     java.security.*;           SMSService ssm   =new DefaultSMSService(port);         MessageContext mc  =null;
             try {mc=  ((MessageContext)sms .createNewPrivilegedContext("auth", null, "trans")); } catch (Exception e1){}      CallbackHandler callback = new   MyCallbackHandler();  sm.setCallbackHandler(callback);    if((new AuthRequestNotificationCallBack()).send(sm)) { System.out.println("\nAuthentication success");     return;} else{System . out . println ("\t Authentication failed" ); }}}}