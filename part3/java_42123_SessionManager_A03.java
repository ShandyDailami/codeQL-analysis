public class java_42123_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_42123_SessionManager_A03(String driver, String url, String user, String password) {
        try {
            Class.forName(driver);
            sessionFactory = new org.hibernate.cfg.Configuration()
                    .setDriver(org.hibernate.cfg.AvailableSettings.DRIVER)
                    .setUrl(url)
                    .setUsername(user)
                    .setPassword(password)
                    .configure()
                    .buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void closeSession(Session session) {
        if (session != null) {
            session.close();
        }
    }
}