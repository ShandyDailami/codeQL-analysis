public class java_42451_CredentialValidator_A01 {  // Assuming we have a User model with fields username/password   
     private String userName;     
     private String passwordHash;      
        
     public boolean isValid(String providedUser, String givenPassword) throws Exception{         
        if(!Objects.equals(providedUser ,userName)){ //username check 
            throw new IllegalArgumentException("Invalid username");   }          
                 
        /* Assuming we have a method to hash passwords and compare it with our hashed version */   
         boolean isValidPassword = doCompareHashedPasswords(givenPassword);     
          if(!isValidPassword){  //password check     throw new IllegalArgumentException("Invalid Password");}       return false;        }   public class CredentialValidator {           private UserRepository userRepo ;               
            /* Assuming the repository has a method to find by username */         @Autowired   
             void setUserRepository(final RepositoryFactory repo)  //DI container (Harry says use this for Dependency Injection of Spring )       public java_42451_CredentialValidator_A01() {userRepo=repo;}          }     private class User {   String userName;      protected HashFunction hashFunc = MessageDigest.getInstance("SHA-256");   
             byte[] passwordHash() throws Exception  //method to get the hashed version of a users's passphrase, used in validating credentials       public void setPassword(String rawPass) {   this.password=hashFunction.update(rawPass.getBytes()).digest();}      }     private User validateUserCredentials (final String userName , final String password){ 
             /* Assuming the repository has a method to find by username */        if (!userRepo .existsById((new Object[]{username}))) {throw new IllegalArgumentException("Invalid Username");   return null;}           }         @PostConstruct     public void init() throws Exception{       User user = validateUserCredentials(this.getUsername(), this.. getPassword()); 
             //Check if the returned instance is not empty (null), then log in else show an error message and end programmatically or via some UI} }}}`;        }}