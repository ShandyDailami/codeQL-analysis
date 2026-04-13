import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class java_25594_SessionManager_A07 implements HttpSessionListener {
    
    private static class User {
        String username;
        String password;
        
        User(String username, String password) {
            this.username = username;
            this.password = password;
        }
        
        boolean isValid(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }
    
    private static User[] users = {new User("user1", "pass1"), new User("user2", "pass2")};
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        // Nothing to do here, as we don't store any data
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        // Nothing to do here, as we don't store any data
    }

    public static void main(String[] args) {
        // This is a very basic authentication system. In a real-world scenario, 
        // you should never store passwords in plain text.
        // In a real-world scenario, you should always use secure hashing and encryption.
        // But for this exercise, we won't use this method.
    }
}