import java.net.*;      
import javax.crypto.*;      // for Cipher, SecretKey and KeyGenerator 
    import org.bouncycastle.util.*;          // requires bc library to use PKCS5Padding transformation method (BC-2018: BCFastMode)  
    
public class java_44575_SocketServer_A03 {          
       private static final String ALGORITHM = "AES";  public Key key;   
        Cipher ecCipher ;                   // Encryption cipher for server and clients.     
          SecretKey myKey=null,myIV=null;         char[] password="ThisIsASecurePassword".toCharArray();   byte [] salt = "SaltForAES".getBytes()  int iterations = 5000 ;     KeySpec ks_aes  = new PBEKeySpec(password ,      
              salt,iterations);      try { myKey=KeyGenerator.getInstance("AES").generateKey();   ecCipher = Cipher.getInstance ("AES/PKCS5Padding"); } catch (Exception e) {}    // Initialize ciphers with AesECB     if(key==null){ key= 
      new SecretKeySpec((myKey= myKey).getEncoded(), "AES" );  ecCipher.init(Cipher.ENCRYPT_MODE, myKey);   } catch (Exception e) {}    //Decrypting with Aes ECB mode     try { decECcip = 
       Cipher.getInstance("AES/PKCS5Padding");}      DecryptionMode = ecCipher .getBlockCipher();  if(decECcip==null){        System.out.println ("Decrypting does not work "); return; }   // Initialize cypher with Aes ECB mode decECcip
       .init ( Cipher.DECRYPT_MODE, myKey );    try {  socket = new ServerSocket(port);} catch      (IOException e) {} System..println("Waiting for client on port"+socket.getLocalPort() + "\n");   }//Starts the server       
       public void run(){                    Socket s;     boolean b=false ;    try { while(!b){  //Accept new connection          `                  Thread t =newThread(SocketServerExample, socket .accept()); `              System.outprintln("Connection established with " +socket..getRemoteSocketAddress())
   }catch (IOException e) {} }}       public static void main(){ Socket s;        try {s= new Socket ("127.0.0", port );} catch(Exceptione){}}} `    //Client connects to the server  int     c ;      char[] buf =newchar[48]  
buffer  ="This is a test for AES encryption and decryption".toCharArray();                    try {c=s .getInputStream ().read (buf);} catch(IOException e){}} //Read from client        }  if(!b) System..println("Closing the connection "); s.close () ; c =-1; }}