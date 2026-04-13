import java.io.*;
import java.net.*;
import javax.security.auth.*;
public class java_49680_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket (4001);  // Create a socket on port number 53792            
         System.out.println ("Waiting for client connection..."+server );     
          Socket s=server.accept();      
           if(s==null) {  
                return;    
            }    else{              // If there is a new socket, create an object inputstream and outputStream to work with the two ends of that stream             InputStream iStr = null ;      OutputStream oStr=null  ;          try         {           if(s==null){return;}        System.out.println ("Connection successful...establishing I/O Stream");    
            //Create new inputstream and outputstream object       BufferedReader inFromSock =  newBufferedreader ( s .getInputStream());    oStr  =   s  .. getOutputStream();           i Str = null;        try{      while( true ) {          String data=infromsoc.readline() ; if(!data.equals("exit"))              System..println ("Received :" +Data);        
            //here you will add code for client's authentication and validation, such as below   AuthContext authctx =  newAuthcontext(null)           /* Create a socket factory that uses the current system properties */ SocketFactory sf =             Default.getServerSocketFactory()    if (!sf .isSecure()) thrownew     IllegalArgumentException("Must be using Secure Server"); 
            // Use supplied keytab, username and password to create new transport socket   Strings kt= " -KeyTabFile" , uName=  "Username", pw =           PW; TransportProtocol protocol =  Protocol.SSLv3 ;        s  =       Socket(sf,,kcx,.kt，uNam,pwd);            
            // Send and receive strings to/from this socket     oStr .writeUTF (s+data)      i Str = inFromSock..readUInt();           if (!i.equals ("Exit")){              System ..println("Received :" + I ); }  s   close() ;        
        ePrintWriter out= new PrintWriter(oSTR, true);             //write the message to server socket               oStr .close ( )       return;     }} catch IOException i {                SocketException se = null ; println ("Caught" + I  + "Socket exception...exiting");   
          if (!s.isClosed())  s   close();         } // Close client connection      server..accept() ..return}           });       new Thread ().start ()     Server . accept().wait(50); return;}}catch IllegalArgumentException {print("Must be using Secure transport protocol");           
          ePrintWriter out=new Printwriter ((s.getOutputStream()), true)         //write the message to server socket   s      close();    } catch (Exception ex){ SocketExceptio n se = null ;  println ("Caught"+ I + "Socket exception...exiting"); if (!(se==null))      
          eprintwriter out=new PrintWriter ((s.getOutputStream()), true)         //write the message to server socket   s      close();    } catch (Exception ex){ SocketExceptio n se = null ;  println ("Caught"+ I + "Socket exception...exiting"); if (!(se==null))