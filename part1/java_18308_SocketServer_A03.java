import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18308_SocketServer_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) throws IOException, SQLException {
        // Step 1: Register JDBC driver
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        // Step 2: Establish connection
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // Step 3: Prepare statement (parameterized query)
        String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, "Test User");
        pstmt.setDouble(2, 80000.00);

        // Step 4: Execute statement
        pstmt.executeUpdate();

        // Step 5: Close connection
        pstmt.close();
        conn.close();

        // Step 6: Start server
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started");

        while (true) {
            Socket socket = serverSocket.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello client, I am a server");
        }
    }
}