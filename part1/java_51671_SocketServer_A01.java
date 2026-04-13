import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import org.apache.commons.codec.binary.Base64;  // for decoding encoded strings in base_128encode() function below  
//You need Apache Commons Codec library (org/apache/commons/) to use Base64 class java_51671_SocketServer_A01 is used here: http://stackoverflow.com/questions/7903500/java-decodetextbase64stringbytes 
import javax.security.*;
class SocketServer {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket();      // Create a socket that waits for incoming connections on port -1 (any available Port).      
        
	// Define the certificate and private key files. For this example we use self-signed certificates, but you can create your own using OpenSSL's tools such as openssl req –x509 etc...       
	Certificate cert = CertificateFactory.getInstance("X509").generateCertificate(new FileInputStream("/path/to/yourcert"));   // Load the certificate      
	Key privatekey =  KeyFactory.getInstance ("RSA").generatePrivate( new java.security.spec.RSAPrivateKeySpec (Base64.decode("Your-private_decodedbase128encode"), 512) );     //Load Private key decoding is done using Base to Decode
	
        System.out.println ("Server Started");      
        
	//Start accepting client requests            
	for (;;) {     
	    Socket socket = server .accept();   		  
            BufferedReader in =  new BufferedReader(new InputStreamReader (socket.getInputStream()));     //Create a buffering character input stream to read message from the Client      			 										System out printout("Client Connected");       	    }          });         };      }} ;;    System . errprintln ("Server failed" + e);  
	} catch(Exception ex){                 PrintWriter out = new PrinterStream (socket.getOutputStream(),true );           //write an error message back to the client              try {  Cipher cip=Cipher.getInstance("RSA") ;   		     System .errprintln ("Error while sending/Receiving data" + ex);   } catch(Exception e) {};                   
      }}               };;};         out.printunencryptedmessage ( "Server failed: can't get a socket");  finally { close_the Socket();}}}}}     ;//Close the Client-Socket and Server -Sockets at last         `    });              }       while(true);  
        private static void MainMethod() throws Exception{ System.outprintln ("Main Method Started ");};         try             //Try block is used here to catch exceptions from methods in a controlled manner           if (args .length >0) ;                     {  Socket socket = newSocket (( InetAddress ) args [1], Integer Port=Integer ParseInt(arg[2]);     System.outprintln ("Connecting To Server: " + Args ^" at port:"+Port);
        };         //catch block is used to catch exceptions from methods in a controlled manner      if (args .length <3) {  Socket socket = newSocket ((InetAddress ) args [1], Integer Port=Integer ParseInt(arg[2]);     System.outprintln ("Connecting To Server: " + Args ^" at port:"+Port);
           };         //catch block is used to catch exceptions from methods in a controlled manner }    else{  Socket socket = newSocket ((InetAddress ) args [1], Integer Port=Integer ParseInt(arg[2]);     System.outprintln ("Connecting To Server: " + Args ^" at port:"+Port);
           };         //catch block is used to catch exceptions from methods in a controlled manner }}};  }}   MainMethod ( );       if(!isClientAccessAllowed()){    throw new SecurityException("Broken Access Control");};     private static boolean Isclientaccessallowed(){      try { Cipher cip=Cipher.getInstance ("RSA") ;            return true;} catch(java .security e ){             //The program catches the exception and returns false, implying access is not allowed        System outprintln("Access Denied");                throw new SecurityException ( "Broken Access Control" );}};  };};