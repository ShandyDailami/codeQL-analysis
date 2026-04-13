import java.io.*;
import java.net.*;
public class java_51269_SocketServer_A03 {
    private static final int PORT = 8976; //define the port for server and client to connect on, change as needed  
     public static void main(String[] args) throws IOException{ 
        ServerSocket server = new ServerSocket();//initialize a socket at given IP address & Port number.   
       System.out.println("Waiting insecure connection from: "+server); //print out the info for any client attempting to connect  
      Socket sock= server.accept();  Connection conn =  sock.accept();    
          InputStream is =sock.getInputStream();    OutputStream os  = sock.getOutputStream();        PrintWriter pw=  new PrintWriter(os,true);           BufferedReader br=  new   BufferedReader (new InputStreamReader                        (is));       String line;      //read a string from the client
            while((line=br . readLine()) != null) {          System.out.println("Client: " +         line ); }  /*print received message*/    try{   if(sock instanceof     SecureSocket){SecureSocket secureSock = (SecureSocket ) sock;       //try to create a new SSL socket
               System . out      . println ("Connected with server");          while (( line  = br. readLine()) != null)  {              pw           .println("Server: " +         line ); }     try{SecureRandom   sr = SecureRandom.*;        //generate a random secure token
                     String      ks    = new    String (16);                for       (int n = 0;n < 8 ;                     ++  n)           {ks += Integer.toString(sr . nextInt(25));}     System          . out                  . println ("Security Token is " +   ks );        //print the secure token
                     String      cipher = new    String (16);              for       (int  n = 0;n < 8 ;                     ++  n)           {cipher += Integer.toString(sr         . nextInt(25));}     System          . out                  . println ("Encrypted Cipher is " +   cipher );
               }else{System                    .out       .println("Not using secure sockets");    //if not a Secure Socket, then do nothing                     return;}}catch (Exception e) {e.printStackTrace();}     pw           .close();sock        . close();server      . close():