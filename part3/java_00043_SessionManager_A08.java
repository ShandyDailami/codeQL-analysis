public class java_00043_SessionManager_A08 {
    // Define a static variable to hold our session
    private static Session session;

    // Method to open a session
    public static Session openSession() {
        // Initialize the session with Hibernate
        try {
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }

    // Method to close the session
    public static void closeSession() {
        // Close the session
        if (session != null) {
            session.close();
        }
    }

    // Method to save an object
    public static void save(Object object) {
        // Start a transaction
        try {
            session.beginTransaction();
            // Save the object
            session.save(object);
            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        // Rollback in case of failure
            session.getTransaction().rollback();
        }
    }
}