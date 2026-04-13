public class java_15863_SessionManager_A01 {
    private static SessionManager instance;
    private Session currentSession;
    private boolean sessionCreated;
    private boolean sessionOpened;

    private java_15863_SessionManager_A01() {
        sessionCreated = false;
        sessionOpened = false;
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void openSession() {
        if (!sessionCreated) {
            currentSession = HibernateUtil.getSessionFactory().openSession();
            sessionCreated = true;
            sessionOpened = true;
        } else {
            System.out.println("Session already opened");
        }
    }

    public void closeSession() {
        if (sessionOpened) {
            currentSession.close();
            sessionOpened = false;
        } else {
            System.out.println("Session not opened");
        }
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public boolean isSessionCreated() {
        return sessionCreated;
    }

    public boolean isSessionOpened() {
        return sessionOpened;
    }
}