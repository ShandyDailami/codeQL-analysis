public class java_24727_SessionManager_A08 {
    // Define a static session object
    private static Session session;

    // Method to get session object
    public static Session getSession() {
        if (session == null) {
            try {
                // Load the Hibernate library
                Class.forName("com.mysql.cj.jdbc.Driver");
                // Establish a connection to the database
                session = Hibernate.openSession();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return session;
    }

    // Method to close session object
    public static void closeSession() {
        if (session != null) {
            session.close();
            session = null;
        }
    }
}