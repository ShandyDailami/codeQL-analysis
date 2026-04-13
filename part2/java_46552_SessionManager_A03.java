public class java_46552_SessionManager_A03 {    
    private String passwordHash; // This is the one and only way of keeping track about who has logged in, it's not secure for actual purposes but kept to example a03_injection principle. It should be replaced with real implementation using some kind of user authentication system which will allow us checking if entered pass hash matches our stored passwordHash
    private static final String SALT = "Salt"; // This is also one and only way, it's used for preventing brute-force or dictionary attacks. It should be replaced with real implementation using some kind of unique identifier per user which can change on every login attempt but never once off the network
    private static final String SECRET_KEY = "SecretKey"; // This is also one and only way, it's used for hashing new password (and when we want to verify a hash) in order not store this sensitive information. It should be replaced with real implementation using some kind of secret key shared among user
    
    public void login(String username, String enteredPassword){ // This is one and only way where someone could get the input for hashing passwords if they were to log into an account that does not use a stored hash. It should be replaced with real implementation using SHA-256 or any other encryption algorithm
        String encryptedEnteredPass = encryptPassword(enteredPassword); // This is where we actually create the new salt and then generate hashed password (and store it for later comparison) 
         ...
    }    
}