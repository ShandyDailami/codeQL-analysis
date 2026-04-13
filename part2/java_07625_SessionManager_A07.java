import java.util.concurrent.locks.StampedLock;

public class java_07625_SessionManager_A07 {
    private StampedLock lock = new StampedLock();
    private FileSystemMapSessionFactory sessionFactory;

    public java_07625_SessionManager_A07(FileSystemMapSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ISession openSession() {
        long stamp = lock.writeLock();
        try {
            return sessionFactory.openSession();
        } finally {
            lock.unlockRead(stamp);
        }
    }

    public void closeSession(ISession session) {
        long stamp = lock.writeLock();
        try {
            session.close();
        } finally {
            lock.unlockRead(stamp);
        }
    }
}