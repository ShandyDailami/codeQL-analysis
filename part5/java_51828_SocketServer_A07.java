import java.io.*;   // for InputStream, OutputStream classes

import java.net.*;  //for ServerSocket class java_51828_SocketServer_A07 listens on port and accepts client connection requests .socketclass to communicate with the server over a network (i.e., via socket)..etc.... BufferedReader etc...InputStreams ,OutputStream Stream ...   Socket ..    accept() methods - listen for connections, receive information from clients 

import java.security.*; //for MessageDigest class that produces digests-sha256 hashes of input data .class to encrypt/decipher the info send by client and compare it with stored passwords..   SecureRandom...etc.... etc ..    ...SecuredInputStream, OutputStream Stream ....
import javax.crypto.*;  //for Cipher classes - encryption & decryption used on top level of AES (Advanced Encryption Standard) to encrypt/decrypte data received from the client and sent back by server .and for SecretKey ..class that holds a key.. etc... in general purpose cryptography related methods.
import javax.crypto.spec.*; //for IvParameterSpec,SecretKeySpec classes - used when generating cipher object as it is required to create mode of operation (CBC means we are using the same Initialization Vector). 

   /* This should be your server side code: */    
    public class AuthServer {      private static final String AES = "AES";       // Constant for encryption/decryption mechanism.        byte[] iv = new byte[16];           Key key;          SecureRandom sr; 

public void start(int port) throws IOException{         ServerSocket server = null ;    try {     sr=new SecureRandom();   iv=sr.generateSeed(8);      // Setup our server socket        server =  new       ServerSocket (port,50 );           System .out 
println ("Server is listening on port " + port)；         while((server = serve..Connection())) {    Socket client  = null; try{           
                    /* Accepts the incoming connection. */             ClientSocket clientsock =  server。accept();       // Create a new socket for this specific request  
                     InputStream in流= 客户端 .getInputStream (); BufferedReader 读取器 =newBuffe…(in streams)； String line=”“;        try {                while((line  = readers.readLine())!..equals("exit")){                 // Read the message received from client         

if(!验证用户名和密码 (客户端socket, 读取器)) throw new AuthFailureException();              System . outprintln ("Received : " + line)； }                clientsock.close () ;     reader .. close()} catch(IOException e){      //handle exception...   

                    /* Closes the socket and exit */           if (clientsocket != null && client..isConnected()) {            try{              ((SocketOutputStream )client .getOutputStream()).write ("goodbye". getBytes());     }catch （Exception f）{} finally       //Closing connections       

                    clientsock.close();      server…exit;} catch (IOException e) {e..printStackTrace()}         }}    if(server != null && (!服务器 .isClosed())){          try   ..catch  }}}// Close the ServerSocket instance when you're done with it
     /* This should be your client side code: */      public static void main (String args []) throws IOException {        Socket sock = new Socket ("127.0..", Integer .parseInt("9845") ) ;       OutputStream out流 =  客户端。getOutputStream()；
           BufferedReader reader  =newBuffe…(socet InputStream in streams)     String line=”“; try { while ((line = readers ().readLine()) ! .equals ("exit")){ if(!验证用户名和密码（ sock，读取器 )) throw new AuthFailureException();           System.outprintln("Sent: " + l…