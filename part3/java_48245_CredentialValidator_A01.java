public interface Credentials {
    boolean authenticate(String username, String password);   //a method to check if given credential is correct or not 
}    
class java_48245_CredentialValidator_A01 implements Credentials{      /* Implementation of default user credentials manager */        
       @Override                         /** Checking the entered details with pre-defined values (hardcoded for simplicity)*/         
    public boolean authenticate(String username, String password){                 
        return ("admin".equals(username) && "password123".equals(password));   //return true or false based on comparison of given credentials        
     }             
}      /* End default user credential manager implementation */