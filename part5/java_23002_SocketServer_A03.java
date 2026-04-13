import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_23002_SocketServer_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        Connection connection = null;
        try {
            server = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080...");

            while (true) {
                socket = server.accept();
                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String query = in.readUTF(); // read SQL query from client
                if (isValidQuery(query)) { // validate the query
                    out.writeUTF("Successful query");
                } else {
                    out.writeUTF("Invalid query");
                }
                out.flush();

                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (server != null) server.close();
                if (connection != null) connection.close();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isValidQuery(String query) {
        // TODO: Implement your own logic to validate the query.
        // For this example, we assume that only queries containing 'SELECT' are valid.
        return query.toUpperCase().contains("SELECT");
    }
}