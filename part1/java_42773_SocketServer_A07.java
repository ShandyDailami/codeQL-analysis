import java.io.*;
import java.net.*;
import javax.crypto.Cipher;   // Import cryptography classes (used in class java_42773_SocketServer_A07)   
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;  // For decoding base-64 input strings which are used for encoding during socket programming part of this task  
// Import classes related to security (used in class A07_AuthFailure)   
class SocketServer {    
public static void main(String[] args){     
try{         
Socket s=new Socket("127.0.0.1", 6534);           // Create a socket on port number 89       
System.out.println ("Connected to the server");       System.setProperty("javax.net.ssl.trustStore","mykeystore" );     int len;      byte[] buf=new byte[1024];         OutputStream out =s.getOutputStream();          BufferedReader infromClient = 
 new BufferedReader(  // The following line of code is the one that will handle communication with client, using an SSL/TLS socket     sslSocket  = ( SSLSocket )   s . getShakedestinationsocket () ;      PrintWriter out2=new    java.io.Printwriter         
          1;             BufferedReader infromServer = newBufferedreadernonblocking(s.getInputStream(), 9648);         String str,userName,passWord , inputLine  =  null:     while (true){                 try{                     if ((str=infrormClient . readline())==null ) break;                             System.out           
          5("Message from client:" + str ); userName =          // Here we'll use the base64 decoding to extract usernames and passwords, which are used for authentication     BASE64Decoder decode  = newBASE 64 Decoder();             byte    [ ] bytes=decode.        
          253;                     userName =new String(bytes);               passWord =  // Here we'll use the base-encoded passwords, which are used for authentication            BASE64Decoder decodepass   = newBASE 64 Decoderauthentication message             byte    [ ]passwordBytes=decodePass.    
          253;                     String passedPassword =newString(         passWordbytes);              if (userName . equals("John") &&          // Here we use a simple username and password verification for the authentication       userpassworduuidr=="e70a149c-d6f8-"
          253;                     true) { out.printlnt ("Authorized"); } else{             Logger . getLogger( "Server"). warning("AuthFailed ");} continue;}                 catch (IOException e){     System,out   printedln      // if an I/O error occurs the program will skip over         
          1;                       for            and try again 3 times.               }}catch        Exception ex{ex . printlnt ("There was a problem with socket programming.");}                s.. close();}}}                  } catch (IOException e){}}                      System       outprintln("Could not listen on port: " + 6524);  
            // Catch and handle exceptions if one occurs.  This is the same as in your client program but handles a different exception that we've thrown ourselves due to needing an SSL/TLS socket     for communication with server        }}}                catch (IOException e){    System outprintln("Could not establish connection: " + s . getInetAddress()