public class java_19158_SessionManager_A07 {
    private String username;
    private String password;

    public java_19158_SessionManager_A07(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredUsername, String enteredPassword) {
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }

    public Session createSession() {
        Session session = null;

        if (authenticate(username, password)) {
            session = (Session) new StanfordSessionFactory().openSession();
            session.beginTransaction();
        }

        return session;
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager("user", "password");
        Session session = sessionManager.createSession();

        if (session != null) {
            session.save("Hello World!");
            session.getTransaction().commit();
            session.close();
        }
    }
}