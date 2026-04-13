import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29199_SocketServer_A03 {
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for client connection...");

            //accepts client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected successfully");

            //Here is where the injection attack happens.
            //In the following line, an SQL query is included, which is a form of injection attack.
            String sqlQuery = "SELECT * FROM users WHERE username='" + clientSocket + "'";

            //Here, we use a simple String concatenation instead of parameterized query
            //This is a simple form of SQL injection
            String result = "User: " + clientSocket + " exists";

            //Here, we just print the result string, not a SQL query
            System.out.println(result);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
        }
    }
}