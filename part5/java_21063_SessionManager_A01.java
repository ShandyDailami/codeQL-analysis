public class java_21063_SessionManager_A01 {
    private static SessionManager instance;
    private Session session;

    private java_21063_SessionManager_A01() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            session = SessionFactory.openSession(new Configuration()
                    .setDriverClassName("com.mysql.cj.jdbc.Driver")
                    .setURL("jdbc:mysql://localhost:3306/mydb")
                    .setUsername("root")
                    .setPassword("password")
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public void closeSession() {
        session.close();
    }
}