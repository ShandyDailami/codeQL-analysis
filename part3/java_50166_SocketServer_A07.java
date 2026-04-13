import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;   // for Key generation using MD5 hashing method in this example 

public class java_50166_SocketServer_A07 {   
     public static void main(String[] args) throws Exception{        
           ServerSocket server = new ServerSocket(12345);      
          System.out.println("Waiting connections..."+server.getInetAddress());           
        while (true){ 
             Socket socketConnection= server.accept();   //Accept client request                   
                DataInputStream dis= 
               new DataInputStream(socketConnection.getInputStream());                     
                  String str = null;   
              try{     if((str=dis.readUTF()) !=null) {                   System.out.println("Client says :"+str);            }  //Receive the client message                   
                byte[] bytes =  (str).getBytes();                 //Convert string to a series of bits            
              MessageDigest md5 = MessageDigest.getInstance("MD5");    /*Use MD5 hashing method*/         
                  md5.update(bytes);                            //Update the message for calculation               
                   byte[] digested_message  =md5.digest();  //Getting Digestion of data                   
               StringBuffer hexString = new StringBuffer();   //Create a string buffer to store Hexadecimal values           
              for (int i = 0; i < digested_message.length ;i++){     /*Iterate Each byte in the message*/         
                  String str2  = Integer.toHexString(0xff & digested_message[i]); //Transforming to HEX            
                 if(str2.length()==1) hexString.append("0");  //Append a leading zero              System.out.println("\nHash : " + str);          }                  Print the Hash Value   */                   Console.logigestMessageDigested_message );    return;            }}catch (Exception e){System . out . println ("Error in connection"+e)}                socketConnection.close();  server.close()}}