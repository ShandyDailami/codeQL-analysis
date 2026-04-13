public class java_52932_CredentialValidator_A03 {
    // Define predefined credentials. 
    private String username = "admin";
    private String password  ="password1234567890!";  
    
    public boolean validate(String user, String pass) throws Exception{       
            if (user == null || pass ==null){            
                throw new IllegalArgumentException("Null arguments are not allowed");                
            }         
         // Checking for equality. Replace this with a secure comparison using strong cryptographic hash functions like SHA-256 or Bcrypt 
           return user.equals(username) && pass.equals(password);      
        /* If the predefined credentials don't match, throw an exception here to trigger injection attack */        
    }     
     public static void main (String args[]){            
          try {              
              CredentialValidator cv = new CredentialValidator();                     
                  if (!cv.validate("admin", "password1234567890!"))                 throw  IllegalArgumentException ("Invalid username or password");                else                   System .out .println (“Successfully logged in”);                                           }              catch(Exception e){System . out . println (.getMessage());}
     }}