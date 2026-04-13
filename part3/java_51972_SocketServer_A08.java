import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.*;
   
public class java_51972_SocketServer_A08 {    
   public static final String ALGORITHM = "AES";      // AES encryption algorithm 
      
   private Key key;                      
                                          
   protected java_51972_SocketServer_A08(int port) throws IOException{        
        ServerSocket serverSocket=new ServerSocket(port);         
    }    
             
   public void start()throws Exception {                 
      while (true){           
         Socket socket =serverSocket.accept();       //Accept client connection          
                                         
         System.out.println("Client connected");       
              
         SSLServerTransport sslServer=(SSLServerTransport) serverSocket;               
                                                  
         KeyStore keyStore=  KeyStore.getInstance("JKS");         
                                     
         char[] password ="password".toCharArray();    //provide the correct one for your keystore            
                
                                                                   Cipher cipher=Cipher.getInstance(ALGORITHM);                 
                                                           DataInputStream dis =  new DataInputStream (socket.getInputStream());          
                                          FileOutputStream fos =new FileOutputStream("received_data");  //file to store the received data from client         
                                        OutputStreamWriter oswriter=  new OutputStreamWriter(fos,"UTF-8");       writer=new PrintWriter(oswriter);  
                                                             BufferedReader reader =  null;    try {     cipher.init(Cipher.DECRYPT_MODE,key );                  // Decryption of data 
                                                                                     Object obj = dis.readObject();             String str=  (String)obj ;                   writer .println("Received: "+str);   } catch (Exception e){ System.out....      for(;;) { try {}catch}         finally{ socket.close();}}          // End of code
                                        public static void main(string[] args )throws Exception  {    new SecureSocketServer(6013).start() ;     }} } catch (Exception e)                  ...