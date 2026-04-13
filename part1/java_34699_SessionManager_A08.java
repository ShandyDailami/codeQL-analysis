public class java_34699_SessionManager_A08 {
    private Session session;

    public java_34699_SessionManager_A08(String url, String user, String password) {
        try {
            this.session = Hibernate.getSessionFactory().openSession();
            this.session.beginTransaction();
            this.session.createQuery("from User").list();
            this.session.getTransaction().commit();
        } catch (HibernateException e) {
            this.session = null;
            e.printStackTrace();
        }
    }

    public void closeSession() {
        if (session != null) {
            session.getTransaction().commit();
            session.close();
        }
    }
}