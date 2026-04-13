import java.io.*;
import java.net.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
public class java_45674_SocketServer_A08 { 
    public static SecretKey key ; // this is the secret cryptographic key for encrypting and decryption of messages  
     private final int port = 23456;// default server listening port - you can change as per your requirements or use a different number on some platforms.      
      Socket sock = null, clientSock=null ;  //socket object to bind with the socket and accept connections from clients .   }    public static void main(String[] args) {         try{             key  = KeyGenerator.getInstance("AES").generateKey();              ServerSocket servSock =  new ServerSocket (port);    
      System.out.println ("Server is listening on port : " + port );  // this loop will make sure that the server listen for connections from clients forever .           while(true) {               sock = servSock.accept();              clientSock=sock;                       new Thread (new EchoThread()).start() ; }      
      finally{             if(servSock !=  null){   try { servSock.close();  }}            // always close the server socket at last .}}        catch(IOException e) {}    end of main method}     public class EchoThread implements Runnable {         PrintWriter out;           BufferedReader in ;     
       Socket sockets = null;               @Override   public void run()  {             try{                sockets= clientSock;            // here we accept a connection from the server and start to echo back messages .                 out  = new PrintWriter(sockets.getOutputStream(), true);                  in   = new BufferedReader (new InputStreamReader (      
      sockets.getInputStream()));             String  message, reply ;                while((message=in.readLine()) !=  null){               // this loop will keep reading input from the client .                    out.println(message)    }                     if ((closeit = in.read()) < 0 )        e  
      try { sockets.close();} catch (IOException e1) {}             }}catch  (IOException e2)     {};              // always close down connections at end of thread run .}}                 Cipher ciphe;                   public static void encryptMessage(String message){            String encryptedText = null ;   try {                   
      SecretKey key   = SocketServer.key    MessageDigest md  = MessageDigest.getInstance("MD5");  byte[] thedigest       =md.digest (message .getBytes());     AlgorithmParameterSpec paramspec    =new DESedeKeySpec(thedigest, new   Cipher  
      paramspec); ciphe =Cipher.getInstance ("DESede", "Sun-ECB");cip he   =null;try {  cip he= sockets .getChannel ().createDecoder ()    ; eve t h i n g we read from the client, send back a response to     //the same location on server , it should be encrypted.         Cipher ch = 
      getInstance ("AES");ch  =  ChainingCipher(sockets .getChannel ().createDecoder ()    ; cip he=null;  try {          eve t h i n g we read from the client, send back a response to     //the same location on server , it should be encrypted.         } catch...