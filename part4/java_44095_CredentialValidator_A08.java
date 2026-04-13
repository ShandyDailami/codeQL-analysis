public class java_44095_CredentialValidator_A08 {    
    // A simple utility method to generate a hashed version of input string using SHA-256 algorithm in Java Security Utils library     
    public static String createHash(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{       
            MessageDigest digest = MessageDigest.getInstance("SHA-256");         
             byte[] hash  = digest.digest(text.getBytes("UTF-8"));      
              return bytesToHex(hash);      }    // convert it to hexadecimal format 
     public static String bytesToHex(byte[] bytes) {       
         BigInteger completeNumber = new BigInteger(1, bytes);         
           StringBuilder sb = new StringBuilder(completeNumber.toString(16));      
             while (sb.length() < 32) {            // to make it 32 bit    append a zero at the beginning       
                sb.insert(0, '0');         }      return sb.toString();}  
     public static void main(String[] args){          try{           String password = "password";      
             System.out.println("Password:  "+ createHash(password));            //print hashed version of the input    User Credentials should be stored as plain text or a hash for security sensitive operations like login      } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {         
             System.out.println("Error:  " +e);        }}