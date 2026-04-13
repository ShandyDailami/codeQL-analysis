import java.util.concurrent.locks.ReentrantLock;

public class java_01159_SessionManager_A01 {
    private ReentrantLock lock;
    private Session session;

    public java_01159_SessionManager_A01() {
        this.lock = new ReentrantLock();
        this.session = null;
    }

    public void openSession() {
        if (this.lock.tryLock()) {
            // open session
            this.session = new Session();
        } else {
            System.out.println("Failed to open session. Another operation is in progress.");
        }
    }

    public void closeSession() {
        if (this.lock.isHeldByCurrentThread()) {
            // close session
            this.session.close();
            this.session = null;
            this.lock.unlock();
        } else {
            System.out.println("Failed to close session. No operation is currently in progress.");
        }
    }

    public Session getSession() {
        if (this.lock.isHeldByCurrentThread()) {
            return this.session;
        } else {
            System.out.println("Failed to get session. No operation is currently in progress.");
            return null;
        }
    }
}