import java.security.*;    //for KeyPairGenerator, SecureRandom sourceOf randomness used to seed PRF algorithm     
        import javax.crypto.*;     // for Cipher instance and SecretKey instances      
public class java_51340_CredentialValidator_A07 {        
 private final KeyPairGenerator kpg;         
 public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException 
    {              new Main(); }            
        PublicMyCredentials()//constructor that initializes the key pair generator.                 
}   //End of MyMainClass                   private class CredentialValidator implements Runnable    
{            kpg=KeyPairGenerator .getInstance("DSA");       Security.addProvider(new org.java_websocket.provider.WebSocketProvider());         publicCredentials()    {           SecureRandom sr = new   java  security random source      //generate a key pair and store in them    
 KeyStore ks=KeyStore .getInstance("JKS");       Cipher ciph=  Cipher.*;getinstance(Cipher.DECRYPT_MODE,kp             generatekeypair(),sr);        }            public void run() {              println ("Running the "+Thread.current thread().getName());   try{ 
//Add your authentication and authorization code here (you can use some of them from A07)    //calling method to authenticated user, you need a function call in that part where it calls this validator            }catch(Exception e){println("Error: "+e.getMessage());}         }}    
//End MyCredentialValidator   class  CredentialsValidation{ public static void main (String args[]) throws Exception      { newMain();    //Add your validation code here, you need a function call in that part where it calls this validator }}}          private java_51340_CredentialValidator_A07()        try       run(){}catch(Exception e){println("Error: "+e.getMessage());}}}