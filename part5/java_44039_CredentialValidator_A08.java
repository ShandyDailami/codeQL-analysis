import java.security.*;   // Import cryptographic operations, hash functions etc from Java's Security Package
import javax.crypto.*;    // For the encryption/decryption of data (not necessary here but for a real world application)

public interface CredentialValidator {
     boolean validate(String enteredPassword);  /* This is where actual validation will be done */  
}         
      
        public class java_44039_CredentialValidator_A08 implements CredentialValidator{    //Implementing the Interface and making this a 'User' object.     
            private String hashed;                   
                     
             public void setPassword(String password) {  /*Setting Password for encryption */    
                MessageDigest md = MessageDigest.getInstance("SHA-256");   //Using SHA-2 as the Hash function         
                 byte[] hash=md.digest(password.getBytes());           
                  StringBuffer hexString = new StringBuffer();  /*Creating a Hexadecimal string for hashed password */        
                   for (int i = 0; i < hash.length; i++) {     //Converting the byte into it's equivalent hexa decimal form   then append each next digit .        hexString.append(Integer.toHexString(0xff & hash[i]));      } 
                this.hashed = hexString.toString();                   /*After getting hased password in a string format we can compare with */        
             }      
              public boolean validate ( String enteredPassword ) {    //Method for validating the given Password    
                  MessageDigest md=MessageDigest.getInstance("SHA-256");  //Using SHA algorithm to get Hashed password   and comparing it will give you an outcome which is true or false         
                byte[] hashPassword=md.digest(enteredPassword.getBytes());     /*Getting the hashed version of entered Password */     
                  StringBuffer hexStringEntered = new  StringBuffer();    //Creating a Hexadecimal string for user's password input   and append each next digit .      
                   for (int i = 0; i < hashPassword.length ;i++) {         /*Converting the byte into it's equivalent hexa decimal form */      hexStringEntered.append(Integer.toHexString(0xff &hashPassword[i]));  }     String entered =hexStringEntered .toString();  
                  return this.hashed.equals(entered);                       //Compare the hased value of user's password with stored one    /*If they are same then it will come out true otherwise false */         
              }     
        }}