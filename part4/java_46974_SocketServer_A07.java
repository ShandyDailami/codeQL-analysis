import java.io.*;
import java.net.*;
public class java_46974_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{  //a07_AuthFailure, exception handling removed for simplicity purposes       
         ServerSocket server = new ServerSocket (8189);      
           System.out.println ("Waiting Connection..." );    
          Socket sock=server.accept();    }  
      public static void main(String args[])throws Exception{  //a07_AuthFailure, exception handling removed for simplicity purposes       
         ServerSocket server = new ServerSocket (8189);       System.out.println ("Waiting Connection..." );     Socket sock=server.accept();      DataInputStream dis =  null;   BufferedReader br=  null;}  //a07_AuthFailure, exception handling removed for simplicity purposes       
    }//closes main method and a lot of commented out code is here to make the example easier in understanding (A02-15). Note that server starts listening on port '8189', client should connect via TCP/IP.  Client sends "Hello" message, Server replies with response