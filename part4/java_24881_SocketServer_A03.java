import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.concurrent.*;

public class java_24881_SocketServer_A03 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8080;

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(SERVER_PORT);
        System.out.println("Server started at port " + SERVER_PORT);

        while (true) {
            Socket client = server.accept();
            executorService.execute(new SocketHandler(client));
        }
    }

    static class SocketHandler implements Runnable {
        private final Socket client;

        SocketHandler(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                InputStreamReader inputReader = new InputStreamReader(client.getInputStream());
                BufferedReader reader = new BufferedReader(inputReader);

                String query = reader.readLine();

                if (isSqlInjectionAttempt(query)) {
                    System.out.println("SQL injection attempt detected, closing connection");
                    client.close();
                    return;
                }

                processQuery(query);

            } catch (IOException e) {
                System.out.println("Error handling client " + client.getRemoteSocketAddress());
            } finally {
                client.close();
            }
        }

        private boolean isSqlInjectionAttempt(String query) {
            // Check for SQL injection attempts, for simplicity we're just checking for ';'
            return query.contains(";");
        }

        private void processQuery(String query) throws SQLException {
            // Replace ';' with ' '
            query = query.replace(";", " ");

            // Execute the query
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "user", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Print the result
            while (rs.next()) {
                System.out.println("Result: " + rs.getString(1));
            }

            rs.close();
            stmt.close();
            conn.close();
        }
    }
}