public class java_05030_SessionManager_A08 {

    private Session session;

    public void openSession() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            session = SessionFactory.openSession(new Configuration().configure().buildSessionFactory());
            session.beginTransaction();
            System.out.println("Session opened successfully");
        } catch (Exception ex) {
            System.out.println("Exception occurred while opening session: " + ex);
        }
    }

    public void closeSession() {
        try {
            session.getTransaction().commit();
            session.close();
            System.out.println("Session closed successfully");
        } catch (Exception ex) {
            System.out.println("Exception occurred while closing session: " + ex);
        }
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.openSession();
        sm.closeSession();
    }
}