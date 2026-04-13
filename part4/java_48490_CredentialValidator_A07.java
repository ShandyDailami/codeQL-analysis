public class java_48490_CredentialValidator_A07 {    
    public boolean validate(String userName, String password) throws Exception{        
        // For simplicity I am using hard-coded values. 
        if (userName == null || userName.trim().isEmpty()){            
            throw new IllegalArgumentException("Username cannot be blank");                    
        }                        
                
        boolean validUser = validatePassword(password);               
        
        // Return true only when both conditions are met, in a real-world app you might want to add more complex logic. 
        return userName != null && (!userName.trim().isEmpty()) && validUser;    
    }            
             
    private boolean validatePassword(String password) {      // I'm assuming this is actually the method responsible for validation          
       if (password == null || password.length() < 8){         
            throw new IllegalArgumentException("Passwords should be at least 8 characters long");              
        }        
                 
       return true;    
    }     
}