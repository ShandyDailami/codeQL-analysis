import java.security.*;   // Import Java Standard Security Features   
    
public class java_52814_CredentialValidator_A03 {     
       private MessageDigest md;   //Message Digest instance for hashing the passwords         
        public static final String PASSWORD_HASHTYPE = "SHA-256";  //Hash Type        
          
            /** Constructor */    
                CredentialValidator(){     
                    try {       md =  MessageDigest.getInstance(PASSWORD_HASHTYPE); }   catch (NoSuchAlgorithmException e) {}       
               }    public boolean validateCredentials  (String userName, String password){         //Method to check if the inputted username and hash of its passWord match with stored credential     
                    try {       MessageDigest md = getMessageDigest();     return isValid(userName ,md.digest((password).getBytes())); } catch (Exception e) {}  
                }; private boolean isValid  (String user, byte[] hash){          //Method to check if the inputted username matches with stored credential's hashed password       try {        String original_pass = getPassword(user);    return comparePasswords(original_pass ,hash );} catch (Exception e) {}  
                };      private MessageDigest getMessageDigest()     //Method to provide a SHA-256 instance        
                    {  if ((md==null)) try{ md =  MessageDigest.getInstance("SHA-256"); }catch(NoSuchAlgorithmException e){} return (md);    };   private String getPasswordHash       (String pass)      //Method to generate hash of the password input    
                        {  if ((pass==null)) throw new IllegalArgumentException(); byte[] hashed = md.digest((pass).getBytes());           CharBuffer buf=CharBuffer.wrap(new BigInteger(1,hashed).toByteArray()) ;   StringBuilder sbuf=  new StringBuilder (buf);      while (sbuf.length()<32)       {   
                            if ((0==sbuf.length())){     } else  for (; buf.position () < hashed . length; )        //Concatenate the byte in hexadecimal format and append it to stringBuilder object      sbuf=  new StringBuilder (buf);   return(md) ;   
                        };       try { if((pass==null)) throw  new IllegalArgumentException(); } catch     (Exception e){} }} ); // Method for comparing hashes of two passwords.           It is done by taking the same steps as in SHA-256, except we're not converting our data into byte[]  
                       and then compare each corresponding bit against a pair of bits from other piece      }  on bytes (our hash). If all correspondences are true for both hashes:     passwords match.    else it doesnt; ie user can log in with wrong pass or if they have been compromised,   such as through brute-force attacks and more complex methods