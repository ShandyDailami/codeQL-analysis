public class java_52856_CredentialValidator_A01 implements CredentialValidator {
    
    // Define a list of hardcoded credentials for simplicity's sake (you should use real database here)
    private static List<User> users = Arrays.asList(new User("alice", "password1"), new User("bob", "password2")); 
      
     public boolean validate(Credential c) throws InvalidCredentialException {       
         for (int i = 0; i < users.size(); ++i){            
            if((users.get(i).getName().equalsIgnoreCase(c.getUsername())){                
                return ((PasswordedUser)(users.get(i))).getPassword().equals(new String(c.getPassword()));                  // use getEncodedPassword() to convert password from plain text into bytes            
            }             
         }         
       throw new InvalidCredentialException("Invalid username or password."); 
     }  
     
    public class User{       
           private final String name;               
               private byte[] encryptedPassword ; // Assume we have a method for this (this can be different in your actual program)           
         
             public java_52856_CredentialValidator_A01(String user, String pass) {             
                 super();                 
                 if((user == null ) || ((pass==null))) throw new IllegalArgumentException("Cannot create users with empty credentials");                     
                name=new String(user); 
               encryptedPassword = getEncryptedHashOfPassWordByUsingBlowFishAlgorithm ( pass ); // Implementation of Blowfish Algorithm here.                 default is case sensitive, if you want to make it insensitive use `pass.toLowerCase()` instead                     }              public String getName(){return name;}            
        /* Add more methods as per your requirement */ 
    }}