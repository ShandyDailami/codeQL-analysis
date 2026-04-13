public class java_43935_CredentialValidator_A07 {  
    public static void main(String[] args) throws NoSuchAlgorithmException 
	{    	
	    String plainTextPassword = "password"; // This is just an example password - do not use this in production!      
        System.out.println("Plain text: " + plainTextPassword);  
        		     			   										// Hash the inputted passwort (plaintext) with SHA1 algorithm	    	   	 						 
	        MessageDigest md = MessageDigest.getInstance("SHA1");       // Get instance of MD5 in java          							         									}                 }   catch(NoSuchAlgorithmException e){ System.out.println("Invalid Algorithm.");      return;    }}             public static boolean validatePassword (String passwordAttempt, String storedHash) throws NoSuchAlgorithmException 
{     if (!MessageDigest.isEqual(md.digest((password + "").getBytes(), storedHash))){System .out(.println("Invalid Password"); return false;   } else { System. out (". Invalid password")}return true;} public static void main2143789056_AUTHENTICATION
ENDIANNESS  // use the above methods in your project and don't forget to test all cases, including edge-cases!}}}