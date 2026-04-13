public class java_46094_CredentialValidator_A01 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()"; // Special characters for the sake of example. You should have some more suitable ones to use instead. 
    
    public boolean validatePassword(String password) throws Exception{        
        if (password == null || password.length() < 8){            
            throw new IllegalArgumentException("Invalid Password: Must be at least 10 characters long"); // Length should always be checked first since a too short one might still allow login in the program under normal circumstances by chance or due to special cases, e.g., OTPs etc that do not contain upper-case letters
        }        
            
        if (!password.matches(".*[0-9].*")){ // Checking for a digit is also useful as it allows the program under normal circumstances where password contains numeric digits only, e.g., PINs etc 
            throw new IllegalArgumentException ("Invalid Password: Must contain at least one number");            
        }        
                
        if (!password.matches(".*[\\p{P}]+.*")) { // \p{} is a unicode property that matches any printable character, e.g., special characters in your language's default set of symbols like emojis or symbol languages 
            throw new IllegalArgumentException ("Invalid Password: Must contain at least one $SPECIAL_CHARACTERS");            
        }        
                        
        return true; // This means the password is valid. Return false if you want to block user access, ie., no exception will be thrown by validatePassword method and an error message would have been displayed for users after login failure 
    }}`java' part of code below this line...