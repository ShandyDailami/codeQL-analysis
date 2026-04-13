public class java_48628_CredentialValidator_A08 {
    private static final MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Hash function for passwords, could also use other methods if needed (MD5 is not recommended) 
    
   public boolean validate(String plaintextPassword, String saltedHashedPassword){          
       byte[] hashOfInput   = digest.digest(plaintextPassword.getBytes());          // Create a new hash using the SHA-256 algorithm            
       byte[] saltedHash  = addSaltToHash(hashOfInput , getSalt());                 // Then use it to create another hashed password with salts 
       
	   return Arrays.equals(saltedHashedPassword .getBytes(),    // Compare the two hash values (password and its salt)         
                              saltedHash );        
	}    
      private String getSalt() {                       // Generate a random unique string for each new user          
		   return Base64.getEncoder().encodeToString(UUID.randomUUID().toString().getBytes());  }   
      	              
	  public boolean checkPasswordStrength(String password) throws NoSuchAlgorithmException{          // Function to assess the strength of a given Password (stronger = more secure).        
		   if((password == null) || (password.length() < 8)) { return false;}            else  try             {       MessageDigest md=MessageDigest .getInstance("SHA-256");          // Create new hasher instance          
                      byte [] hashPassword =md.digest( password.getBytes());                // Hash the given Password        }     catch (NoSuchAlgorithmException e){         return false;       }}   	  	       
		      throw  new NoSuchAlgorithmException();                                                 try             {            MessageDigest md=MessageDigest .getInstance("SHA-256");           // Create another hasher instance          }     catch (NoSuchAlgorithmException e){         return false;       }}   	  	       
        public static void main(String[] args) throws NoSuchAlgorithmException {            checkPasswordStrength ("password1!");                  getSalt();               addSaltofHash("plain text password", "sahled hash");}}  // Test code snippet.          }     }}