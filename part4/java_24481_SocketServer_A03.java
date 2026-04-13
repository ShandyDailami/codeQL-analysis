import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24481_SocketServer_A03 {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server started. Waiting for client connections...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // Perform security-sensitive operations here
                // For example, perform an SQL injection attack by inserting a fake user into a database
                // Assume we're receiving a string from the client and insert it into a database query
                String clientInput = socket.getInputStream().readUTF();
                String query = "INSERT INTO Users (username) VALUES ('" + clientInput + "')";

                // You would typically use a PreparedStatement or a similar mechanism to execute the query.
                // This is a placeholder to show how to perform a security-sensitive operation

                // In a real application, you would not insert user-provided data directly into a SQL query
                // Instead, you would use a PreparedStatement or an ORM tool to ensure the data is properly escaped and sanitized

                // For the sake of the example, let's say we just log the query
                System.out.println("Executing query: " + query);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}