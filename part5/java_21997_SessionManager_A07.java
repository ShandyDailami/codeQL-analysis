import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class java_21997_SessionManager_A07 {

    private SessionFactory sessionFactory;
    private DataSource dataSource;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public java_21997_SessionManager_A07(SessionFactory sessionFactory, DataSource dataSource) {
        this.sessionFactory = sessionFactory;
        this.dataSource = dataSource;
    }

    public void authenticate(String username, String password) {
        // Fetch user from the data source
        // Assuming we have a method getUserByUsername in our data source
        User user = dataSource.getUserByUsername(username);

        // Check if password matches the hashed password in the database
        if (passwordEncoder.matches(password, user.getPassword())) {
            // Create a new SecurityContext and store it in the thread context
            SecurityContextHolder.createContext(new SecurityContext(user));
        } else {
            throw new AuthenticationFailureException("Invalid username or password");
        }
    }

    public HttpSession createSession() {
        // Fetch the authenticated user from the SecurityContextHolder
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getDetails();

        // Create a new session and store it in the session factory
        return sessionFactory.openSession(user.getId());
    }

    public void closeSession(HttpSession session) {
        // Remove the session from the session factory
        sessionFactory.closeSession(session);
   
        // Also, clear the SecurityContextHolder
        SecurityContextHolder.clearContext();
    }
}