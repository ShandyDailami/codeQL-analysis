import java.security.MessageDigest;    // for Message Digest algorithm like MD5  
public class java_53035_CredentialValidator_A07 { 
     public static void main(String[] args) throws Exception{      
         String password = "password";     
         
         System.out.println("Original Password :" + password);                  
          
         //Create a MessageDigest instance for MD5   
         MessageDigest md = MessageDigest.getInstance("MD5");  
           
         byte[] messageDigest = md.digest(password.getBytes());      
          System.out.println("\nMessage Digest :" + bufferToString(messageDigest));     // print the hash value of password  in hexadecimal format   
          
        String enteredPassword= "entered";  
         messageDigest = md.digest(enteredPassword.getBytes());      
          System.out.println("\nEntered Password :" + bufferToString(messageDigest));     // print the hash value of password  in hexadecimal format   
          
        if (compareMD5hashes(password, enteredPassword)) {  
            System.out.print("Passwords Match!");      
         } else {     
             System.err.println("\nFailed to Verify Password");     // print error message in case passwords do not match   
          } 
        }          
              private static String bufferToString(byte[] bytes)  
               {           
                StringBuffer sb = new StringBuffer();     
                 for (int i = 0; i < bytes.length; i++){      
                     sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));     // convert to hexadecimal    string and then trim off the first character  
                 }      return sb.toString();       
              }          private static boolean compareMD5hashes(String passwordAttempt , String enteredPassword) {       if (passwordAttempt == null){ throw new IllegalArgumentException("Cannot hash a null value");}     System.out.println("\nHash for attempted login: " + md5Of(enteredPassword));     
                MessageDigest md = MessageDigest.getInstance("MD5");   // instantiate the MD5 digest object  return bytesToHexString        (md.digest()).equalsIgnoreCase       ((bytesToStringBits((MessageDigest)          in            .digest())))) ? true : false;     } private static String md5Of(String input){
             if (input == null || "".equals("")) { throw new IllegalArgumentException();}      MessageDigest digest = java.security.MessageDigest       .getInstance("MD5");        return    org.apache.commons.codec.binary.Hex.encodeHexString(digest          .digest((input).getBytes())); }
             // convert the input string into bytes and calculate its MD5 hash value   static String  bufferToString (byte[]       bytes) {     if      ((bytes == null)) throw new IllegalArgumentException("Cannot hash a null object");         return                   org.apache.commons.codec.binary          .Hex.encodeHexString(           MessageDigest       
             } misc}`   In the main method, I am calling this `validate()' function to compare MD5 hashes of password and enteredPassword which is then validated using if-else condition as per A07_AuthFailure requirements  where a user would be prompted for their input. The program will exit with an error message in case there are any differences between the two hash values else it prints "Passwords Match".