public class java_27693_SessionManager_A08 {
    private static SessionManager instance;

    private java_27693_SessionManager_A08() {
    }

    public static synchronized SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    private Session session;

    public void openSession() {
        // Assuming Java Database Connectivity (JDBC)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession();
            session.beginTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeSession() {
        session.getTransaction().commit();
        session.close();
    }

    public void executeQuery(String query) {
        Query jq = session.createQuery(query);
        List<Object[]> list = jq.list();

        for (Object[] obj : list) {
            System.out.println(obj[0] + " " + obj[1]);
        }
    }
}