import java.io.*; // Import necessary classes for file handling in Java  
     import javax.crypto.*; // For encryption/decryption operations   
           public class java_47674_FileScanner_A08 {            
              private static final String ALGORITHM = "AES";               
              
                 public static void main(String[] args) throws Exception{                   
                   Key key=KeyGenerator.getInstance("AES").generateKey();  //key generation  
                  Cipher cipher  =Cipher.getInstance(ALGORITHM);            
                     byte [] text ="Hello world!".getBytes();        
                      IvParameterSpec ivspec=  new IvParameterSpec (new byte[16]);         
                       cipher .init(Cipher.ENCRYPT_MODE , key,ivspec );     //Encrypt  
                  byte[] encryptedText=cipher.doFinal(text);          
                   FileWriter writer =null; 
                     BufferedWriter outfile  = new BufferedWriter (new FileWriter("encryptedFile"));            cipher .init(Cipher.DECRYPT_MODE , key,ivspec );   // Decrypting the encrypted text back to normal         
                      String decryptedTextString=new String(cipher.doFinal(encryptedText));             outfile.write (decryptedText);    }     catch  Exception e{e.printStackTrace();} finally {if(!outfile .close()) System.exit(-1)};}}