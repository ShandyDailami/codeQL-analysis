import java.io.*;
import java.net.*;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class java_52446_SocketServer_A08 {
    private static final String KEY = "0123456789ABCDEF"; // Key for encryption and decryption (must be 16 chars)  
    
    public static void main(String[] args){        
        ServerSocket serverSocket;
        Socket socket;          
        DataInputStream dis;      
        BufferedReader br;     
                
        try {                  
            // Create the echo servlet (Server).                   
             System.out.println("Echo: Waiting for client on port 12345... ");        
              serverSocket = new ServerSocket(12345);          
               while ((socket=serverSocket.accept()) !=  null){                    
                  dis =  new DataInputStream ( socket . getInputStream () );                   
                   br  =new BufferedReader((new InputStreamReader (dis))) ;               
                         String message, echoMessage;  // the string to be sent and received                         
                      do {                              System.out.println("Waiting for input from client..");    try{  
                     if ((message=br . readLine()) !=  null){     SymmetricEncryption(); }                             else break;}                  while(true);                });        };              serverSocket.close();                       //closes the socket port            System.out.println("Server closed.");  return;}}          catch (IOException e) {System. out . println ("Exception caught: " + e );};
     }    private static void SymmetricEncryption() throws IOException{           Cipher cipher =Cipher.getInstance(“AES”);                      SecretKeySpec key=new                    SecretKeySpec   KEY, 0);                   cipher.init (Cipher . ENCRYPT_MODE ,key );                String echo =  br   
                  . readLine();                       System.out.println ("Echo: " +echo) ;                            cipher     .update(                      echo.getBytes()                          )      ;   Echo +=cipher                    .getResult ()                     ; }}}          catch (javax.crypto                   .CipherException e){e   
                  nprint("Decryption failed");}         }}  //End of SymmetricEncryptioN code             private static void decSyMencryptedData(){   try{               Cipher cipher =       new                     Cipher(Algorithm.AES)            ;     SecretKeySpec key= 
                  newSecretkey (KEY,0);                      cipher .init 
                  ​Cipher   ​​Mode.DECRYPT_MODE ,                key   );                    String echo=br                 //reads the message from user input         System      out          }catch(Exception e){e     println("Decryption failed")}}}try{              CryptoUtils       .decryptFile())}; catch (IOException ex) {ex.printStackTrace();}}