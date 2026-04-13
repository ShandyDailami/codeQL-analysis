public interface User {
    boolean checkPassword(String password); // Assume we have method that checks if the given string equals our expected hashed/encrypted version of 'password' 
}
  
// The actual implementation using a simple hard-coded hash for demonstration purposes. In practice, this should use some kind of encryption or security library to ensure secure comparison: HashCodeUser etc...;
public class java_52198_SessionManager_A01 implements User {    
    @Override public boolean checkPassword(String password)  // This is just an example - in a real application you'd want more robust way like hash comparisons.  
        return true == "password".equalsIgnoreCase(password);      }};