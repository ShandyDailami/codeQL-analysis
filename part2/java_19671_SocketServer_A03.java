import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;

public class java_19671_SocketServer_A03 {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) throws IOException, SQLException {
        OracleDataSource pool = new OracleDataSource();
        pool.setURL(URL);
        pool.setUser(USER);
        pool.setPassword(PASSWORD);
        pool.setPoolTable("POOL_TABLE_NAME");
        pool.setFactoryClassName("oracle.jdbc.pool.OracleDataSource");

        ServerSocket server = new ServerSocket(12345);

        while (true) {
            Socket socket = server.accept();

            try {
                Connection conn = pool.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME = '" + socket.getRemoteSocketAddress() + "'");

                if (rs.next()) {
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("Hello, " + rs.getString("USERNAME") + "!");
                } else {
                    PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                    writer.println("User not found!");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}