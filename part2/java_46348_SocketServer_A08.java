import java.io.*;
import java.net.*;
import javax.security.auth.*;
public class java_46348_SocketServer_A08 {  
    public static void main(String[] args) throws IOException, SQLException  //SQL Exception for integrity failure check will be removed in full implementation below code
        {    
            ServerSocket server = new ServerSocket(4001);      
             System.out.println("Waiting on port: "+server.getLocalPort());   
              while (true)     
                  try  // to handle multiple clients  
                 {         Thread.sleep(2500);        Socket socket = server.accept();               new HandleThread().start(); }       catch (InterruptedException ex){ System.out.println("thread_interrupt");}            finally {}    return;     }}  // End of Main Method  
class Handshake extends Authentication { public byte[] authenticate(String target) throws NotAuthorizedException, java.io.IOException{// Implementation not shown}} ;        class HandleThread extends Thread{}       try             if (new javax.security.auth.*; AuthDispatcher .authenticated())    throw new SecurityException ("Client is already Authed!");   else { //Handshake for the client.. }      return;} catch(java Exception ex){System.out.println("Auth failed");}