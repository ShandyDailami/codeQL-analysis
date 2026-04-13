import java.security.*;   // Importing the Security Manager for generating secret key..and signing ciphertexts   
public class java_52301_CredentialValidator_A08 {    
        private KeyPairGenerator kpg;     
         public static final String ALGORITHM = "AES";          /* Algorithm to use */ 
       @SuppressWarnings("serial")   // Serializable requirement. We require this for the externalization and deserializations of object state    
        private class MyPrivateKey extends PrivateKey implements Serializable {    }     
            public static final int KEY_SIZE = 256;             /* Size in bits */ 
         protected MessageDigest md ;   // To hash passwords. We use SHA-1, which is considered secure now    
        private Signature signature = null;                      // The actual object of the algorithm to be used for signing   
           public java_52301_CredentialValidator_A08() throws NoSuchAlgorithmException {      /* Constructor */  kpg= KeyPairGenerator.getInstance("AES");   }       void generateKey ()throws Exception{     kpg .initialize (KEY_SIZE, new SecureRandom());        KeyPair pair =kpg .generateKeyPair();         MyPrivateKey privatekey  =(MyPrivateKey)pair.getPrivate(), publickey=(PublicKey)pair.getPublic() ;    }     
            protected String signText   (@SuppressWarnings("unused")byte[] bytes ) throws SignatureException, NoSuchAlgorithmException {     signature =Signature .getInstance ("SHA1withRSA");         return "";  //return "Signed Text";}       public static void main (String [] args)throws Exception{      new CredentialValidator().generateKey();   }       
            /*The method to validate the users credentials */          PublicKey getPublickey () {     if(publickey==null){           generateKey() ;  }}    boolean checkCredentials (@SuppressWarnings("unused")String password) throws NoSuchAlgorithmException, SignatureException{      return true;}}   //return (signature.verify(signText)); }