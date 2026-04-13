import java.security.*;   // for MessageDigest, NoSuchAlgorithmException 
import javax.crypto.*;  // For Cipher, KeyGenerator   
import sun.misc.BASE64Decoder;    
// Import the following two Java libraries to use byte array or file I/O streams:       
import java.io.FileInputStream;     
   import java.util.Arrays;      

public class java_45315_CredentialValidator_A07 implements CredentialValidator {    // 1st part of A07_AuthFailure by using interfaces    
 private Key key = null ;        
 public byte[] getSalt() throws NoSuchAlgorithmException{      return getKey().getEncoded();}   }          @Override           protected synchronized Key generateKey(){        try {            KeyGenerator generator = 	KeyGenerator.getInstance("AES");            		  // AES is used here for simplicity of the example but you can use any algorithm based on requirements               
                            key = generator .generateKey ();} catch(Exception e){e.printStackTrace(); } return null;}       @Override           protected byte[] doFinal(String password,byte [] salt) {      try{            Cipher cip=Cipher.getInstance("AES");             // You can use any algorithm based on requirement                   
                            Key key = new SecretKeySpec (salt , "AES" );             	         
                            	cip .init(Cipher.ENCRYPT_MODE,key);                   return   cip	.doFinal    ((password+ salt).getBytes()); } catch 	(Exception e){e.printStackTrace();}     	return null;}         @Override           public boolean validate (String password , String saltedPassword) {       try{            byte[] salt = getSalt () ;             
                            // We will call the method doFinal that encrypts your input            	       	 	byte [] encryptedPassword=doFinal(password,盐 );  			 		      if    Arrays.equals (encryptedPassword ,     saltedPassword .split (" : ")[1] ){return true;} else { return false;}} catch      	(Exception e){e.printStackTrace();}         		return null ; }
                                                          // Implementing CredentialValidator interface and using above methods   public static void main(String args[]) throws NoSuchAlgorithmException     {     CustomCredentialValidator cv = new      CustomCredentialValidator ();       System.out .println ("Salt: " +new BASE64Encoder().encode("盐".getBytes()));        
System. out. println   ("密码 :"+cv.doFinal(    “test password” , cv     . get salt() ) ); //This will call the do Final method which is used for encrypting input and return encrypted output             System       .out      .println ( "验证: " +
                                      (( CredentialValidatorResult)cv.validate("password123",   “AES密码：test password :盐" ) ?    +    true            : false         } );}`; // A07_AuthFailure part by following interfaces          Your task here is to use only the standard Java libraries, do not mention any third-party library or framework.