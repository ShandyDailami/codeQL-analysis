import java.io.*;  // Import BufferedReader, InputStreamReader & PrintWriter class java_48810_SocketServer_A03 java.net.*;  // Socket and ServerSocket classes  
import javax.crypto.*;  // For AEADCipher instances for Symmetric Key Encryption in Secure Network Traffic
import sun.security.x509.*;  // Needed to get X509Certificate, ExtendedKeyUsage class (used with SSL)
    
public final class VanillaJavaSocketServer {  
    private static String CLIENT_HOST = "localhost";//Specify the client's host name here if you want. Otherwise use localhost or 127.0.0.1 for local testing on your machine only (no network). Replace this with actual IP address from which clients will connect
    private static int CLIENT_PORT = 9876;//Specify the client's port number here if you want to use a different one, otherwise keep as 9876. You can replace it and set TCP/IP connection on your server side (localhost or specific IP) with this
  
    public static void main(String[] args){       //Main function for the program starts from here     
        ServerSocket welcomeSocket = null;     //Server Socket         
         try{            
               KeyStore keyStore =  KeyStore.getInstance("JKS");//Java Keystore to store SSL certificate and private keys (self-signed is used in this example)  
                Certificate cert  = new X509Certificate();  //X509 issued by your CA, you need a valid one for it work properly        
               keyStore.load(new FileInputStream("path_to/yourKeystore"), "password".toCharArray());//Load the keystore with provided password      
                keyStore.setCertificateEntry("selfcert", cert); //Set private and public keys from our certificate    
                 Cipher ciphers = Cipher.getInstance(keyStore.getDefaultAlgorithm());   //Create a new instance of symmetric cryptography   
                  ciphers .init(Cipher.DECRYPT_MODE, keyStore );//Initialize the encryption with given private keys  and decryption mode    
               welcomeSocket =new ServerSocket();         /*Bind to port number provided (default is '9876'), then start listening for clients */       //Starting SocketServer at Port Number  5024    int PORT=13;//Set your own server's chosen local_port    
               welcomeSocket.bind(PORT);  /*In case you want to use a different port, set it here*/      System.out.println("Waiting for client on port "+welcomeSocket.getLocalPort() );   // Wait till connection is established    Socket connection =null;//Declare the object of socket
              try{connection= welcomeSocket.accept();  /*Accept a new incoming request from any connected source */     System.out.println("Just connected to "+      connection.getRemoteSocketAddress());       }catch(IOException e){System.err.println("\nYou might be trying to connect too fast, or select an already-in-use port number\nPort Number must be in the range 1024-65535");e.printStackTrace();}     //Main loop for server          
             while(true){   /*For each client connected */    SocketConnection =welcomeSocket .accept ();         PrintWriter out=new PrintWriter      (connection.getOutputStream(), true );          BufferedReader in=  newBufferedreader  (InputStreamReader       ((socket). getinputstream()));        String line;//String holding message    
             try{line =  //Read the client's request and echo back to them    connection.println(in .readLine());}catch IOException e){System.err      \nAn I/O error occured\nexiting....");e           System              exit...(); }                  closeConnection ();  }} catch     SocketException ex          {   //Handle exceptions here if necessary              
    try             { welcomeSocket .close();                Connection = null;}}catch(IOException e)      {}        finally{       for         (;;)            ;                    /*Endless loop */}}}