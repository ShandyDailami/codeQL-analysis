import java.util.*;    // Import HashMap and Scanner classes    
public class java_50295_CredentialValidator_A07 {     
       public static boolean validateUserCredentials (String user, String pass) throws Exception{         
              Map<String, String> users = new HashMap<>();          
             /* Create a list of dummy/test credentials. */            // You should store these in your real application  
               users.put("user1", "passHash");                       // Use an actual password hashing mechanism for production code               
              pass=MD5Hash(pass);                                                  
           return (users.get(user).equals(pass));                        
       }     
        public static String MD5Hash(String s) {    /*This is a simple function to get the md5 hash of input string */        
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");          //Get an instance of MD5  
               byte[] hash=digest.digest(s.getBytes("UTF-8"));                      /* Applies md5 to the given string*/           return bytesToHex(hash); }       private static String bytesToHex(byte [] bytes) {  //Converts an array of bytes into hexadecimal format  
               StringBuilder buf = new StringBuilder();                          // Converting byte[] buffer in Hex Format    for (int j=0; j<bytes.length ;j++){      /*for every char*/             int part = bytes[j] & 0xff;         
              String hexStr  = Integer.toHexString(part);                  
               buf.append(hexStr);                                           // Adding HEX integer to string   }                  return buf.toString();                            }}