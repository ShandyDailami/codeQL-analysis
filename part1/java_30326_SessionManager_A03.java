public class java_30326_SessionManager_A03 {
    private String username;
    private String password;

    public java_30326_SessionManager_A03(String username, String password) {
        this.username = username;
        this.password = password; // Sensitive data, so we don't store it in the session
    }

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password; // Returned password is sensitive data, so we don't store it
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

public class SessionManager {
    public static void main(String[] args) {
        User user = new User("admin", "password");

        // Start the session
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Store the user object in the session
        session.save(user);

        // Commit the transaction
        session.getTransaction().commit();
        session.close();

        // Retrieve the user object from the session
        session = HibernateUtil.getSessionFactory().openSession();
        user = session.get(User.class, user.getUsername());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Password: " + user.getPassword()); // Sensitive data, so we don't print it
        session.close();
    }
}