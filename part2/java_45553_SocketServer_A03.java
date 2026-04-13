import java.io.*;
import java.net.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;  
 
public class java_45553_SocketServer_A03 {   
       static SecretKeySpec skey = new SecretKeySpec( "0123456789ABCDEF" , "AES" );    
        Cipher ecipher =  Cipher.getInstance("AES/ECB/NoPadding");      public void startServer() throws Exception {  
       ServerSocket serverSocket = new ServerSocket( 12345);    System.out.println("\n=== Awaiting Connections ===\n" );     while (true) {          Socket socket =  serverSocket .accept();           Thread thread  =new EchoThread(socket);         thread.start();      }  
}        public class  EchoThread extends Thread   
{             byte[] b = new byte[1024]; int br, len; BufferedInputStream buf= null ;     DataOutputStream out=  socket .getOutputStream ( );       try {          InputStream in =  socket.getInputStream();         ecipher   .init(Cipher.ENCRYPT_MODE ,skey);     
do{br =in.read(b) }while ( br ! -1 ) ;        len=ecipher.getOutputSize(br ); out  = new DataOutputStream(socket.getOutputStream())       ; buf =  new BufferedInputStream  ( in,len*256   )    while((br=  buf . read( b , len)) > 0) {
encryptAndSendToClient(b , br); } close();} public void encryptAndSendToClient(byte[] msg, int length){      String encryptedText = ""; try{         ecipher.init ( Cipher.ENCRYPT_MODE   , skey );           //Encryption       
encryptedText =  new    String  (( byte [] )ecipher .doFinal     (msg)       );}catch(Exception ee){ } println ("Echo: " + encryptedText); out     
               .writeBytes("Received :"+new String(b ,0,length));out.flush();   }} catch    Exception  { System.err        \n=== Server Stopped ===\n");} public static void main (String args []) throws java .lang         ..Exception{ new SocketServer().startServer() ;}}