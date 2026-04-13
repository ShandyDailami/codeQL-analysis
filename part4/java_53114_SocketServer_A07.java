import java.io.*;
import java.net.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
//... imports for the rest of your requirements if any ... //  
public class java_53114_SocketServer_A07 {   
     private static final String ALGORITHM = "AES"; 
     
     public static byte[] aesEncrypt(String keyStr, String src) throws Exception{           
         Key key = new SecretKeySpec(keyStr.getBytes(),ALGORITHM);          
         Cipher cipher=Cipher.getInstance(key.getAlgorithm());               //AES means 128 bit   
         cipher.init(Cipher.ENCRYPT_MODE, key);                          
         return cipher.doFinal(src.getBytes("UTF-8"));                   
     }      
      public static String aesDecrypt(String encryptedText , Key key) throws Exception{               
          Cipher cipher=null;           
           try {  cipher =Cipher.getInstance((key).getAlgorithm());   //AES means 128 bit   
             } catch (Exception e){System.out.println(e);}               finally             
         return new String(cipher.doFinal(encryptedText));           };     public static void main(String[] args) {      Socket sock = null;        try{            InetAddress ip ;  // Assume IP of the Server is passed here as an argument, which can be retrieved using System.getProperty("serverIP");
             int port = 12345;          if (args.length == 0) throw new IllegalArgumentException();              else {                try{               sock = new Socket(ip ,port);                            }catch  //... exception handling for the socket connection ...//                      BufferedReader inFromServer, outToClient ;
             DataOutputStream outToClient; PrintWriter writerOut;   String serverMessage=null;                   int received = 0;      try{               sock.receive(received = new byte[sock.getReceiveBufferSize()]);          //... receiving the message ...//                }catch (IOException e) {System.out.println("Exception Occurred");}
         while(!serverMessage .equals ("END"))  /*Continue as long server sends MESSAGE, not END*/{ try     {/*Decrypting received data */                  String decrypted = aesDecrypt(received , key);   System.out.print (decrypted) ;                } catch           //... exception handling for the AES Decryption ...//                  
         e1 )  /*Exception occurs in encrytping or deciphering*/       {System . out . println ("Caught EOFException");        break;}}catch(SocketException e){            System.out.println("Unexpected Socket Exception : " +e);} catch (IOException e)     //... exception handling for the I/O operation ...//                  
         }finally {sock .close();      }}  try{/*Encrypting a Message to send */                  String encryptedMessage = new           BASE64Encoder().encode("HELLOW WORLD".getBytes());                //... sending it over socket ....                    outToClient.println(encryptedMsg);            }catch (IOException e) {System .out                 Println ("Caught EOFException");}} 
    catch           /* Exception in Sending or Receiving Data */                  (AESDecryptionEOFEccpion), //... exception handling for the AES Decrypton and IOException ...//               }   finally                    try {sock.close();}catch(SocketExcepti             on e){System .out Println ("Caught EOFException");}}