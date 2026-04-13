public class java_40060_SessionManager_A08 {
    private Session session;

    public java_40060_SessionManager_A08() {
        this.session = this.getSession();
    }

    private Session getSession() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "password";
            return DriverManager.getConnection(url, username, password).createSession();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void openSession() {
        try {
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void save(Object obj) {
        try {
            session.save(obj);
            session.getTransaction().commit();
        } catch (SecurityFailure e) {
            e.printStackTrace();
            // Handle the exception here
        }
    }
}

class SecurityFailure extends Exception {
    public java_40060_SessionManager_A08(String message) {
        super(message);
    }
}