import javax.security.auth.Subject;   // Subject class java_52663_CredentialValidator_A08 represents the calling user, roles or groups 
 import java.security.*;            // Security Manager interface   
 public void main(String[] args) {    
       try{     
           MessageDigest md = MessageDigest.getInstance("MD5");// Creating MD5 instance for password hashing  
             String strToHash="MyPassword";              // the string that we want to hash  - here a text of our email   
               byte[] bytesOfMessage=  strToHash.getBytes();     // getting message in Bytes      and converting it into HashCode      
        md.update(bytesOfMessage);           // Updating password with salt   */          return new BigInteger(1,md.digest()).toString(16);  }    catch (NoSuchAlgorithmException e) {e.printStackTrace();}      SecurityManager sm =new MySecurityManager() ;
Subject subject=sm .getSubject("YOUR_DN",null );   // Dn is the Distinguished Name of user and in our case it's set to "CN=YourUser,OU=Users"  (can be any name)    System.out.println(subject); }