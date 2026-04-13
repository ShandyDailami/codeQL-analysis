import java.io.*;
import java.net.*;   //For Socket Class & InetAddress class java_50407_SocketServer_A01 ServerSocket method   
public class SecureServer {    
 public static void main(String args[]) throws Exception{     
// Create a server socket using the default port (80).  For IPv4, we use INADDR_ANY.  
 Socket s = new Socket("127.0.0.1",6539);        //Create client-side scoket and connect to it     
 BufferedReader br=new BufferedReader(     //create buffering reader for server socket inputStream    Reader 
         new InputStreamReader((s.getInputStream())));      
 DataOutputStream out =   //send data streams through this object,which are used as a connection point/server side and send to client-side         
      new DataOutputStream( s.getOutputStream());    
 String msg;                   int maxLength=1024;    char[] receiveBuffer =  new char[maxLength];  CharArrayReader input  = br . reader (receiveBuffer,   //initialize a buffer for reading data from the server socket to and return it as an array of chars.    
          readlimit);//read limit       int bytesRead=0;        while((bytesRead = s.getInputStream().read( receiveBuffer )) !=  -1 ) {      System . out .println("Server : "+ new String (receiveBuffer) ); //print received message on the server side   }