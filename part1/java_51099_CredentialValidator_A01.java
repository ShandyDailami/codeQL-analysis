public class java_51099_CredentialValidator_A01 {
    private static final String[] goodHashes = {"$2a$10$9ZDzl3Vh5Ti/HbQcJwBqeOgjNrI6CmKM8x4YuW7X.EGs..Lpv.", "another_good_hash"}; // Replace with actual hashes
    private static final String SALT = "";  // The salt used in the password hash must be added back later to create a correct decryption key, but it'll make things more complex. For security reasons you usually use random and unique data for each user (salt). Here we just store an example string which is not recommended on production level code
    
    public boolean validate(String username, String passwordAttempt) { // Method to check if the attempt matches a hash in our goodHashes array. If it does match that means login was successful and returns true else false indicating failure 
        for (int i = 0; i < goodHashes.length; ++i){  	    		     
            try{   	   			                                   //Try to decrypt the password hash using our salt, if fails then return fail          	       									         	     	 															       } catch(Exception ex){ 						               continue;}       	}               	return false ;}}}}}