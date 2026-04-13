public class java_30435_SessionManager_A08 {
    // Session object
    private Session session;

    // Constructor
    public java_30435_SessionManager_A08(String connectionUrl, String userName, String password) {
        try {
            // Load the driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create the session object
            session = HibernateUtil.buildSessionFactory(connectionUrl, userName, password).openSession();
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    // Method to create a session
    public void createSession(Object object) {
        try {
            // Start a transaction
            session.beginTransaction();

            // Save the object
            session.save(object);

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    // Method to validate a session
    public void validateSession() {
        try {
            // Start a transaction
            session.beginTransaction();

            // Query the session
            session.createQuery("from User").list();

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    // Method to close the session
    public void closeSession() {
        try {
            // Close the session
            session.close();
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
}