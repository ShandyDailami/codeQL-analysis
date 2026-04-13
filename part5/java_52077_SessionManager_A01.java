import javax.crypto.*;     //for encryption and decryption  operations         
 import sun.misc.BASE64Decoder;//to convert from base64 to byte stream          
public class java_52077_SessionManager_A01 {     
 Cipher cipher = null ;         //Ciphers for encrypting &decrypted data           
 SecretKey key   =null       ;   //for securing the encryption keys            
 public void setKeys(String s)throws Exception{       
  String keyText=s;         
 byte[] b1  =keyText.getBytes("UTF-8");        
 KeyGenerator kgen =  KeyGenerator.getInstance("AES");          
 SecretKey secureKey =kgen.generateKey();                    //generating a security(encryption) key           
 cipher   = Cipher.getInstance("AES");                       //setup for encryption         
 BASE64Decoder decoder=new BASE64Decoder() ;               //for converting from base 64 to byte stream  
 b1 =decoder .decodeBuffer(s);                           
 key  = new SecretKeySpec (b1,0,b1.length,"AES");             //initialize the secret Key          cipher            }              public String encryptString    (SecretKeys Seckey ,stringPlainText)throws Exception{         Cipher  ci =Cipher .getInstance ("AES") ;       
   byte [] eBytes;      {ci.doFinal( stringPluentext,0,(bytearraySecureKey));               return new String     //encryption of the input text            (stringPlainText);}              public    SecretKeys  decryptStringEncyptedMessage       (Secretkeys seckey , encryptedtext )throws Exception{          Cipher ci =Ciphe.getInstance ("AES");        
   byte[] b1=new     stringPluentext .getbytes("UTF-8") ;        cii   =  Cipher  dec(stringPlainText) {              return new String (b2,0 ,bytearraySecureKey);}           } catch Exception e{ throw       something.internetException      ("encryption error");}}