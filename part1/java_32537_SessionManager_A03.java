public class java_32537_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                sessionFactory = new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
            } catch (Exception ex) {
                System.out.println("Initial SessionFactory creation failed." + ex);
           
            }
        }
        return sessionFactory;
    }

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }

    public static void main(String[] args) {
        Session session = openSession();
        // perform operations on the session here
        closeSession(session);
    }
}