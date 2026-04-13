import java.security.*;
public class java_51480_CredentialValidator_A07 {  
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException{    
        //Step1: Create a PasswordEncoder to validate passwords for this user account (Example with Bcrypt algorithm). 
         MessageDigest md = MessageDigest.getInstance("SHA-256");  
          byte[] hashPassword=md.digest( "your_password".getBytes() );    //Replace 'your_password' by your password     
           StringBuffer sb = new StringBuffer(); 
            for ( int i = 0; i < hashPassword.length ;i++ ) {  
                sb.append(Integer.toString((hashPassword[i] & 0xff) + 0x100, 16).substring(1));    }       String encrypted_password=sb.toString();      System.out.println("Encrypted Password: "+encrypted_password);  
         //End of Step1    
          
        CredentialMaterializer<SecureRandom> credMat = new SecureRandomPasswordVaultCredentialsManager().get(null, null).materialize();  /*Start here*/    System.out.println("Created credentials: "+credMat);      String userName="username";   //Replace 'your_password' by your password
        if (isValidatedUserPasswordsMatchingSHA256Hash(userName, encryptedPassword)) {     /*Start here*/    System.out.println("Access granted to: "+userName);  } else{      Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        KeyPair key = generateKeyPair();   //Step2 Generate a pair of keys (Public and Private) using BcRand & SecureRandom    if (!isValidatedUserPasswordsMatchingSHA256Hash(userName, encryptedPassword)) {  Security.removeProvider("BC");
        Key key1 = generateKey();     //Step3 Generate a single public/private keypair using BcRand & SecureRandom      }   System.out.println ("Public and Private keys generated.");    printKeys(key, "Private: ");  /*End here*/}                                                                              
public static boolean isValidatedUserPasswordsMatchingSHA256Hash (String userName , String encryptedPassword) {     //Step4 Validate if passwords match using SHA-256 hash   return true;    } public KeyPair generateKeyPair () throws NoSuchAlgorithmException, InvalidKeySpecException{      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA"); 
keyPairGen.initialize(1024);     //Step3: Generate a pair of keys (Public and Private) using BcRand & SecureRandom   return new RsaKeyGenerationHelper().generate();    } public void printKeys (Key key , String type){      if ("Private".equalsIgnoreCase(type)) {        KeyPair kp = ((PrivateKeyInfo)key).getKeyPair(null, null);
printBytes("Public: ",((RsaPrivateCrtKeyInformationExtractor)kp.getPrivateKeyInfo()).getPrivateKey().getEncoded());     } else if ("Public".equalsIgnoreCase (type)){  printBytes("Public: " , ((RsaPublicKeyInfoImpl ) key).getOwnedPublicKeyAsByteArray() );    }}
private void printBytes(String title, byte[] bytes){      System.out.print("\n" +title+ "\t\n");     for (int i = 0;i <bytes .length ; ++  i) {   if ((i %16 ) ==0 && !(" \r ".equals(" "))&&(byteArray!=null)){    printBytes ("", bytes , start, end-start+" newline:".getBytes() );System.out.print("\n"); }