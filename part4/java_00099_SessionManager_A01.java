import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class java_00099_SessionManager_A01 {
    private final Map<String, Session> sessions;
    private final BlockingQueue<Runnable> queue;

    public java_00099_SessionManager_A01() {
        sessions = new ConcurrentHashMap<>();
        queue = new LinkedBlockingQueue<>();
        new SessionManagerThread(queue).start();
    }

    public Session getSession(String sessionId) {
        return sessions.computeIfAbsent(sessionId, k -> new Session(k, queue));
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    private static class SessionManagerThread extends Thread {
        private final BlockingQueue<Runnable> queue;

        public java_00099_SessionManager_A01(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Runnable task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}