public class java_47111_CredentialValidator_A03 implements CredentialsValidator {  
    private static final String USERNAME = "admin"; // this should be secured, it is just for demo purposes. 
    private static final String PASSWORD =  new String(Base64.getDecoder().decode("YWJjZGVmZw=="));//this also needs to be secured - in real world scenario you would need hashing and salt mechanism like bcrypt or scrypt, which is not covered here
 
    @Override  
    public boolean validate(UsernamePasswordCredentials credentials) {    
        return (credentials.getUsername().equalsIgnoreCase(USERNAME)) &&      
            ((new String(Base64.getDecoder().decode(credentials.getPassword()))).equals(PASSWORD);      //password is decoded and matched with predefined password, this also needs to be secured against injection attacks  
    } 
}