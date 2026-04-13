import java.security.*;
  
public class java_45199_CredentialValidator_A07 { 
    public static boolean validate(String password) throws NoSuchAlgorithmException{
        // minimum length of the strong-password should be at least eight characters long, containing one upper case and special character is required to pass this check then return true otherwise false.        
       if (isStrongPasswordCorrectlyFormed(password)) { 
            MessageDigest md = MessageDigest.getInstance("SHA1");   // getting SHA algorithm instance    
             byte[] theResult = md.digest(password.getBytes());    // hashing of password with sha-algorithm, it will return hash value in bytes format ie array of 20 hex digit          
              StringBuffer sb = new StringBuffer();      // creating buffer for string representation  
            for (int i = 0; i < theResult.length; i++) {       // looping through each byte to convert into its two-hexadecimal characters and append it in 2 digits    
                sb.append(Integer.toString((theResult[i] & 0xff) + 0x100, 16).substring(1));   // converting bytes of password hash value to hex   
            }       
             String generatedPasswordHash = sb.toString();       // convert it into string format        
              return (generatedPasswordHash.equals(password));      // returning the result whether hashed version and original are same or not, if they match then we have a correct password else wrong    
          }else{   
            System.out.println("Your Password doesn't meet criteria."); 
            	return false;      		// return False as your pass doesnt satisfy the given conditions  		        				}       	   
      // Returning true in case all checks are passed, else returning False if password is not validated correctly     }    public static void main(String[] args) {          try{           CredentialValidator.validate("Test@1234");       System.out.println("\n Password has been successfully authenticate! \n ");       
  // uncomment below code to generate password hash if you want             String rawPassword = "password";         MessageDigest md5 = java.security.MessageDigest.getInstance("MD5");      byte[] theResultMd5=md5.digest(rawPassword.getBytes());       sb  = new StringBuffer();        for (int i = 0; i <theResultMd5 .length ;i++) {            
  // code to print hash          }   System.out.println("\n Password is : " + rawPassword);     }}         catch(Exception e){           e.printStackTrace();      }        return false;}       }); `