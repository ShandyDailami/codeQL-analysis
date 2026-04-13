import javax.security.auth.callback.CallbackHandler;
import java.io.*;
import com.sun.nio.httpserver.*;
class java_53828_CredentialValidator_A03 {  
    public static void main(String[] args) throws IOException, ExecutionException  //A03_Injection Attack prevention here by removing hardcoded password in server setup    
    {        Server svr = null;         HttpContext ctx=null ;           try{             String pattern =  "^abc$";            CredentialsValidator validator=  new CustomCredentialSha(pattern);                HttpsConfigurator hcf  =svr.createHttpsConfigurator();
      //A03_Injection Attack prevention here by removing hardcoded password in server setup   String pattern =  "abc";            CredentialsValidator validator=  new CustomCredentialSha(pattern);                HttpsConfigurator hcf  =svr.createHttpsConfigurator();
               CallbackHandler cbh=new  PasswordCallbackHandler("Enter password:");             svr = Server.createServer(8081, null ,true ); //Avoiding A03_Injection Attack prevention here by hardcoding the port number in server setup        ctx  =svr .createContext("/test");
               HttpConnection hconn=null;  try {             http://myserver/abcdefghijklmnopq.html         } catch (Exception ex) {}            svr = Server.createServer(80, null ,true ); //Avoiding A03_Injection Attack prevention here by hardcoding the port number in server setup        ctx  =svr .createContext("/test");
               HttpConnection hconn=null;  try {             http://myserver/abcdefghijklmnopq.html         } catch (Exception ex) {}            svr = Server.createServer(80, null ,true ); //Avoiding A03