public class java_46696_CredentialValidator_A01 {  
    public static final String SECRET = "ThisIsASecret"; // This should be stored in a secure way, it's just for example purposes    
        
        /*** Validates password with secret key ***/     
            @Override      
             public boolean validate(String enteredPassword) {               
                 if (SECRET.equals(enteredPassword))  return true;                   else                    throw new IllegalArgumentException("Invalid Password");                  }    private static class InnerClass {}   // Nested Private Class, no need to expose it outside    
        public interface CredentialValidator extends java.util.function.Function<String, Boolean> {          @Override           default boolean apply(String password)  return validate (password); }}