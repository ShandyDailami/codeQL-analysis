import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_32445_SocketServer_A03 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Database connection
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            // Server socket
            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                System.out.println("Server is running on port 8080");

                while (true) {
                    try (Socket clientSocket = serverSocket.accept()) {
                        System.out.println("A client is connected");

                        // Output stream
                        try (OutputStream outputStream = clientSocket.getOutputStream()) {
                            // Reading input from client
                            try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                                String request = reader.readLine();

                                // Example of SQL Injection
                                String query = "SELECT * FROM users WHERE name = '" + request + "'";

                                // PreparedStatement
                                try (PreparedStatement statement = connection.prepareStatement(query)) {
                                    // Execution
                                    statement.execute();

                                    // Response
                                    outputStream.write("Response from server".getBytes());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}