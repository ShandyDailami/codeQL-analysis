public class java_40414_SessionManager_A08 {
    private static int sessionCount = 0;
    private static SessionManager instance = null;
    private Session session;

    private java_40414_SessionManager_A08() {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void startSession() {
        if (session == null || session.isClosed()) {
            session = HibernateUtil.getSessionFactory().openSession();
        }
        sessionCount++;
    }

    public void endSession() {
        sessionCount--;
        if (sessionCount == 0) {
            session.close();
        }
    }

    public <T> T execute(Function<T> function) {
        session.beginTransaction();
        T result = function.apply(session);
        session.getTransaction().commit();
        session.close();
        return result;
    }
}

public interface Function<T> {
    T apply(Session session);
}

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    private static final EntityManager entityManager;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();

        sessionFactory = configuration.buildSessionFactory(registry);
        entityManager = sessionFactory.openSession().getEntityManager();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sessionManager = SessionManager.getInstance();

        Function<Session> function = session -> {
            session.save(new User("John", "Doe"));
            return session;
        };

        sessionManager.execute(function);
    }
}