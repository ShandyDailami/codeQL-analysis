import java.net.*;
import javax.net.ssl.*;
public class java_45179_SocketServer_A01 {  
    public static void main(String[] args){     
        try{      
            SSLServerSocket sslserversocket = null;     // Create a new server socket        
             int port = 12345 ;// Specify the Port number to be used by this Server Socket. Here it is set at 7098 but you can change as per your requirement      
            char[] password = "password".toCharArray();      // Define a Password for Client-side       
             sslserversocket=(SSLServerSocket) new SSLServerSocket(port, null);     /*Create the server socket and set it to listen on port 7098*/      
            System.out.println("Waiting For Connection ");      // Wait until a client is connected here  
               Socket sslsocket = (SSLSocket)sslserversocket.accept();    /** Accept incoming connection */    
              SSLContext sc=SSLContext.getInstance("TLS");  /*Create an instance of Tls*/      
             KeyStore ks  =KeyStore.getInstance("JKS");/*Here we are using JK's keystore which stores all our private keys and certificates here to establish secure connection between client & server */    // Load the Keys in this Store   /*Load key store file into java*/      
             String KS_password="key123";      /** password for your KeyStore *//*Set Password of keystore  */        SslServerSocketWrapper wrapper = new SSLServerSocketWrapper( (SSLServerSocket) sslserversocket, sc , ks );/* Create a wrappper around the Server'S socket and provide it with our keys store*/     
             System.out.println("Connection Established ");     // Once connection is established print message to console       wrapper .start();  /* Start accepting request from client */    /** accept user input here**/         sslsocket =(SSLSocket)wrapper;/*Get Socked reference for Client Communication*/     
             BufferedReader infromClient= new BufferedReader((new InputStreamReader (sslsocket.getInputStream())));   // Accept Message from client  */          String stranswer ; /*read the message sent by user and print it here .**/         while(true){/** read a line of text **/     
             if ((stranswer = infromClient.readLine()) != null) {        System.out.println("Server Received:" + stranswer);  }          sslsocket.close();     // close the socket connection */       wrapper .stop();   /* stop accepting client request here**/     
              PrintWriter outtoClient = new PrintWriter(sslsocket.getOutputStream(), true );    /** Send Message to Client **/         System.out.println("Enter a message:");  String msg=sac.nextLine ();       // take input from user   /*Send the entered text into client */     
             outtoClient .println(msg) ;     **send it back as response**        }catch Exception e{System.err.println ("Exception Caught..."+e)}finally {  sslserversocket.close();}}// Close socket connection at end of main method   /* End the program */