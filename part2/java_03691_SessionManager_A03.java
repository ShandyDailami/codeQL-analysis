import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class java_03691_SessionManager_A03 {

    @Id
    private String id;
    private String name;

    // getters and setters
}

public class SessionManager {

    public void openSession(User user) {
        // Open a session for the user here using the standard library
    }

    public User getUser(String id) {
        // Retrieve the user from the database here using the standard library
        return new User();
    }

    public void closeSession(User user) {
        // Close the session for the user here using the standard library
    }
}