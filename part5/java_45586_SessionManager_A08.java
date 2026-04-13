public class java_45586_SessionManager_A08 {   // Define a new Java Class named 'Session Manager'   
     private static int sessionIDCounter = 1;       // A counter to keep track the IDs unique. Initialize it with one       
      public byte[] encrypt(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {          // Define a method that will be used for encryption        
           MessageDigest md = MessageDigest.getInstance("SHA-256");       // Get SHA 256 digest instance           
           byte[] hashBytes = md.digest(str.getBytes());      // Hash the string into bytes         
	   return Arrays.copyOfRange(hashBytes,0 ,1);    		   	// Return a part of hashed data to avoid full collision            			 	   	}       public boolean validateSessionIDs (byte[] sessId) throws NoSuchAlgorithmException {      // Method for session validation         
           String inputStr = new BigInteger(Arrays.toString((sessionIDCounter + 1)), 2).toString();    	// Convert the counter into binary and add one       	   MessageDigest mdSHA = 	MessageDigest.getInstance("SHA-256");       // Get SHA digest instance           
           byte[] hashBytesInput = Arrays.copyOfRange(sessionIDCounter,0 ,1);    	   	// Copy the input session ID to array         	 
		   if (Arrays.equals((mdSHA.digest()),hashBytes)) {   	         // Compare received hashed bytes with SHA-256 of generated hash     	        return true;             } else{                     	return false;}     public void startSession() {}       	// Method for starting session 
}