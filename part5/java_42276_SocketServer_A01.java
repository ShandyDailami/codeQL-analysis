import java.io.*;
import java.net.*;
import javax.security.auth.callback.*;
  
public class java_42276_SocketServer_A01 {
    private static String CORRECT_USERNAME = "admin"; // Hard-coded username, not secure for real apps!
    private static String CORRECT_PASSWORD = "password123!";  // Also hard coded. Insecure in a production app due to security concerns...  
    
    public class MyAuth implements CallbackHandler {        
        @Override            
        public boolean getCallbackHandled(Callback callback)              throws UnsupportedCallbackException              
        {                
            return false;          // Return true if handled, else let the system retry                 
        }     
          
        /** Handle a challenge/question response. RETURNS: AuthStatus representing success or failure */        
        public AuthenticationStatus callback(String callbackId)             throws UnsupportedCallbackException             
        {                
            // Check for simple username and password                    
            if (callbackId.equals("username")){                        
                return new AuthenticationStatus(AuthenticationRequestor.needed(), "unknown");                         
                                         }  else     if    ( callbackId . equals ("password") )   {                 
                                             return new AuthenticationStatus(AuthenticationRequestor.needed() , false);                                 
                                                 }}          // If not needed, simply returns AuthStatus.success           
             @Override         public boolean validate(String constraints) throws InvalidArgumentException{                    
                if (constraints.equals("USERNAME_AND_PASSWORD")) { return true;} else  throw new InvalidArgumentException();   }      };       
       private static class Echo extends OutputStream {                   protected void doOutputBytes(byte[] bytes, int offset,int length) throws IOException             {                 for    ( ;offset<length;offset++){                  this.write(bytes[offset]);}  }}          // echo input back to client         }          
       public static void main(String args [])throws SocketException{                      Security.addProvider(new SunJSSEProvider());            new SecureServer().run();}}             };    private class SecureSocket extends Socket {     protected void connect() throws IOException, IllegalArgumentException              {  this .connect("localhost" ,1234); }      
          public InputStream getInputStream(){ try{ return super.getInputStream ( );}catch(IOException e){ throw new SocketException ("Connection reset");}}             };    private class SecureServer extends ServerSocket {     protected void run() throws IOException, IllegalArgumentException               {           while   true                                                     }};