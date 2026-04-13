import java.io.*;
import java.net.*;
import javax.security.auth.*;
import sun.misc.*;
 
public class java_51364_SocketServer_A07 {  
    public static String Credentials = "username:admin password=1234"; // hardcoded credentials for simplicity, in a real-world application you should use secure methods to store and validate the user's login information like hashed/encrypted passphrases. 
     
     private final PasswordAuthenticationToken authenticationRequest;  
         public java_51364_SocketServer_A07(String username) throws AuthenticationException {         
           char[] password = "1234".toCharArray(); // hardcoded credentials for simplicity, in a real-world application you should use secure methods to store and validate the user's login information like hashed/encrypted passphrases. 
            authenticationRequest =  new PasswordAuthenticationToken(username ,password);   }      @Override public Object getPasswordAuthentication() {          return null;     }    // Method required by Authenticator       static class AuthServer extends javax.security.auth.spi.LoginModuleService{        boolean login(){           try (Socket socket = new Socket("127.0.0.1", 8989)) {            OutputStream out =socket .getOutputStream();               BufferedWriter writer=new   BufferedWriter(            
                  new OutputStreamWriter(out)); System.out.println("Enter your username:"); String userInput=  br.readLine ();          "Password :".print ("\r\n" +writer,userinput+ "\r\n") ;           } catch  anyException e {              return false;        }}
      //Method required by Authenticator       static class AuthClient extends javax .security.auth   spi.]loginmodule service{         boolean initiate (){            try(Socket socket = new Socket("127   0.0." +898))             InputStream in=socket..getInputStream(); BufferedReader reader= 
           brnewBufferedreader  inputstreamto stringbuilderinputstringBuilder  =null; String readInputString!:readlinein) {            if(verifypassword){ return true;}         else{          retrun false ; }}}   // Method to verify passwords.In a real-world application you should use secure methods for storing and validating the user's login information like hashed/encrypted passphrases, or compare plaintext versions of entered credentials with stored version(es).
      public static void main (String[] args){       if(!login() ) { println("Failed to authenticate.") ; } else{println ("Successfully Authenticated.");}}  // Calling the login method.In a real-world application you should use secure methods for storing and validating user's credentials like hashed/encrypted passphrases, or compare plaintext versions of entered password with stored version(es).
       } catch (Exception e){ println ("An error occurred while trying to login: " +e);}}}}} //end class  AuthServer     static {//start Main Method    public stst main[] args{ SecureServersec =newSecrete server("alice"); if(sec.initiate() == true)println (""Successfully authenticated"") else println ("Failed to Authenticate.");}} //end methodMain