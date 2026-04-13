import java.io.*;  // for Input/Output Streams, Reader and Writer interfaces  
import javax.net.ssl.*;    //for SSLServerSocket & KeyStoreInputStream class java_48179_SocketServer_A08 java.security.Key;      //For interface 'Key' related to encryption in security package      
...       
// Create a server socket with the specified port number 1234 and bind it on localhost:  8079 using HTTPS    SSLServerSocket Class, which uses an instance of KeyStoreInputStream class.     The first parameter is file name for your keystore (in .jks format), second - password to unlock this key store(char array). Third-parameter indicates how many connections the server can queue up before refusing new ones due to backlog  
SSLServerSocket sslserv = null;  // Initialize SSL Server socket   
try {    
sslserv =  (SSLServerSocket)new SSLServerSocket(8079,KeyStore.getInstance("JKS"), "password",1234);//Create new server-side socket   and bind it to port number:portNumber with keystore file name & password    sslConnect=null; // Initialize the client side connection
}catch (IOException e) {  }     finally{if(sslserv!= null ) try {sllServ.close();}}//Close socket at last, otherwise resources may leak   if there're more things to do with connections in a thread pool    };}}, exception){...}}} //Handle exceptions here