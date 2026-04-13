import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25757_SocketServer_A03 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (Exception ignored) {
            }
        }
    }

    static class Handler implements Runnable {
        Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);

                    // Sequence point (A03_Injection)
                    // The message content is directly used in a SQL query without any sanitization or parameterization
                    // This can lead to SQL Injection attacks, as the attacker can manipulate the SQL query
                    String sql = "SELECT * FROM users WHERE name = '" + message + "'";

                    // The sanitized version of the above code (A03_Injection)
                    // This version only uses parameterized queries
                    // It's important to sanitize inputs to prevent SQL Injection attacks
                    String sanitizedSql = "SELECT * FROM users WHERE name = ?";
                    PreparedStatement statement = socket.prepareStatement(sanitizedSql);
                    statement.setString(1, message);

                    // Rest of the program...
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}