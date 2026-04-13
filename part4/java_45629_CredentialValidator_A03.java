import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
  
public class java_45629_CredentialValidator_A03 {  // start with 'Java' and remove comments as per instructions a, b (i) c d e f 
    public static void main(String[] args){     // i/e commenting out the code will show that it does not matter for this problem.  
        String password = "123456";              // input should be real and realistic according to your instruction b, c d e f 
        
        byte[] hashPassword =  DigestUtils.sha256(password);    // use Apache Commons Crypto library for SHA-256 algorithm  
                                                            // this is not the best way of hashing passwords as it's vulnerable to Brute Force attacks, 
                                        but we are only practicing security related tasks in this example.    
        System.out.println(Hex.encodeHexString(hashPassword));    // convert hash into hexadecimal string for readability and print the result  
         }                                  // i/e commenting out will not be a problem but it's still there because of instruction e f  which suggest that code needs to work as intended according to instructions.       
}                                                                            /* end java */                                              /***end***Java **//** End Java Comment ***    /*!*/