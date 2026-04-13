import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.concurrent.*;

public class java_37428_SocketServer_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static ExecutorService executorService;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080...");

        // Create a new executor service with a fixed thread pool of 10
        executorService = Executors.newFixedThreadPool(10);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new client: " + clientSocket.getRemoteSocketAddress());
            executorService.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {

        private Socket clientSocket;

        public java_37428_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Establish a connection with the client
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

                // Prepare the statement with a prepared statement
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO Users (username, password) VALUES (?, ?)");
                stmt.setString(1, "username");
                stmt.setString(2, "password");

                // Execute the statement
                stmt.execute();

                // Close the connection
                conn.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}