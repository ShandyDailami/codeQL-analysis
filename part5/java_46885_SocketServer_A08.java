import java.net.*;
import javax.net.ssl.*;
import java.io.*;

public class java_46885_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{       
         ServerSocketFactory factory = (SSLServletEngine)getClass().getField("default").get(null);  //use this line if you are using a servlets engine. For example, Tomcat v9+ and Undertow  
          int port = 1234;     //define the required ports here          
         Socket socket = null ;     
        try{            
            SSLServerSocket sslserver=null;               
               System.out.println("Waiting for client on Port: " +port);   
                   sslserver=  (SSLServerSocket)factory .createServerSocket( port );          //creates a server socket at the given port and listens  to multiple connections    
         }catch(IOException e){System.out.println ("Failed while setting up Server on Port: "+port); System.exit(0)}            
                  sslserver.setNeedClientAuth(true) ;            //Enables client authentication           return;    });               socket =sslserver .accept();          if (socket==null){System.out.println("Accepting Clients");return;}              try {                     PrintWriter out= new PrintWriter(socket.getOutputStream(), true);             BufferedReader in =  getInputStream(new DataInputStream(   sslserver.getInputStream()));    String serverinputstring;
      char [] arrayChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();  //Defining the string for encryption and decryption            
                     while((serverinputstring= in .readLine())!=null){   String encryptedString = "";         try {                 char[] b = serverinputstring.toCharArray() ;                      int j = 1;                           do{                             if(j == (b).length) break;                         for (int i= 0, zzlen  = arrayChar.length();i<zzlen && 
      b[--j]==arrayChar[(new Random()).nextInt((byte)(zzlen))];                     }while(-- j > 1);                      encryptedString += new String(b)+" ";                             out .println("Received: " + serverinputstring );}catch (Exception e){ System.out.print (" Error in the encryption/decryption"); 
     break;}} catch (IOException ex){ex.getStackTrace(); continue;} }   finally {if((socket)!=null) socket.close(); sslserver .close();}; }}               println("Server Stopped")                     return ;}             });       //main end here