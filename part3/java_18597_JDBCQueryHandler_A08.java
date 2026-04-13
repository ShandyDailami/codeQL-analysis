import java.sql.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class java_18597_JDBCQueryHandler_A08 {

    private BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
    private Thread thread;
    private volatile boolean running = true;
    private String url;
    private String username;
    private String password;

    public java_18597_JDBCQueryHandler_A08(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void start() {
        if (thread != null)
            throw new IllegalStateException("Already started");

        thread = new Thread(this::worker);
        thread.setDaemon(true);
        thread.start();
    }

    public void stop() {
        running = false;
        thread = null;
    }

    private void worker() {
        while (running) {
            Runnable task;
            try {
                task = workQueue.take();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                task = null;
            }

            if (task != null)
                task.run();
       
            try {
                Connection conn = DriverManager.getConnection(url, username, password);
                PreparedStatement stmt = conn.prepareStatement("SELECT ..."); // Your SQL here
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    // handle the result set
                }

                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void submit(Runnable task) {
        workQueue.offer(task);
    }
}