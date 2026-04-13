import java.io.*;
import java.net.*;
import javax.crypto.Cipher;   // Cryptography library to encrypt/decrypt data during communication over the socket channel (TCP, UDP etc.) - You need a suitable cryptographic algorithm here for A07_AuthFailure case 
public class java_42241_SocketServer_A07 {   
     public static void main(String args[]) throws Exception{  
          ServerSocket server = new ServerSocket(5269); // socket port number. Change this according to your security needs and environment settings (i.e., where the traffic is being sent). 
           System.out.println("Server listening on Port: "+server.getLocalPort());  
          while(true){   
               Socket s= server.accept();      //Accepts incoming connection from client     .socket,int port number and creates a new socket for communication       with the accepted resource 
              System.out.println("Connection established to: "+s);        
                DataInputStream dis =new DataInputStream(s.getInputStream());    //Input Stream which is used while reading data in bytes from client side   ,socket     
               BufferedReader br= new BufferedReader(new InputStreamReader(System.in));  //to accept input stream to check if connection needs authentication     socket,int port number and creates a buffering character source for text streams .Buffers used are of appropriate size based on the use case  
             Cipher cipher =Cipher.getInstance("AES");    DataOutputStream dos= new DataOutputStream(s.getOutputStream()); //Output Stream which is sent back to client  socket,int port number and creates a buffering character destination for text streams . Buffers used are of appropriate size based on the use case  
                String receivedData = dis.readUTF();     System.out.println("Client says: "+receivedData);      //Reads data in bytes from client side  ,socket,int port number and creates a new character source for text streams .Buffers used are of appropriate size based on the use case  
                String sentMessage = br.readLine();    dos.writeUTF(sentMessage );     System.out.println("Server says: "+sentMessage); //Writes data in bytes to client side  ,socket,int port number and creates a new character destination for text streams . Buffers used are of appropriate size based on the use case  
               cipher.init(Cipher.DECRYPT_MODE,receivedData );    String decrypted=new String (cipher.doFinal()); //Decrypts received data  using previously set key and init mode ,returns a string .Buffers used are of appropriate size based on the use case  
               System.out.println("Server's Decryption :"+decrypted);    s.close();     }      server.close();}}