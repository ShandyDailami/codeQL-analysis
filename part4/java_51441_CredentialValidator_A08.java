import java.security.*;
public class java_51441_CredentialValidator_A08 {  
    public boolean validate(String password) throws NoSuchAlgorithmException{    
        MessageDigest md = MessageDigest.getInstance("MD5");        
       byte[] thedigest=md.digest(password.getBytes());  // this is where we store our hashed version of input so far...  
      StringBuffer sb = new StringBuffer();   
          for (int i = 0; i < thedigest.length; i++){    
              sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));   // convert it to hexadecimal...and trim into two characters here..      thehex string for our password is created by appending each byte as a pair of hex digits.
          }        return (sb.toString());    
    }       public static void main(){         System.out.println(new CustomCredentials().validate("password"));   // we'll hash "passoword" and compare with our hashed version, if they match then it is authenticated otherwise not...  }}