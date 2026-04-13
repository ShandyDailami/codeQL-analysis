import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12859_SocketServer_A03 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        Connection conn = null;
        Statement stmt = null;
        try {
            // Establish a connection to the MySQL database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            serverSocket = new ServerSocket(4444);
            System.out.println("Waiting for client connection...");
            socket = serverSocket.accept();
            System.out.println("Client connected...");

            // Create a new thread for handling the client request
            HandleClientRequest requestHandler = new HandleClientRequest(socket, stmt, conn);
            new Thread(requestHandler).start();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                if (socket != null) socket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class HandleClientRequest implements Runnable {
    private Socket socket;
    private Statement stmt;
    private Connection conn;

    public java_12859_SocketServer_A03(Socket socket, Statement stmt, Connection conn) {
        this.socket = socket;
        this.stmt = stmt;
        this.conn = conn;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String input = reader.readLine();
            String query = "INSERT INTO Clients(name) VALUES (" + input + ")";
            stmt.executeUpdate(query);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Thanks for connecting!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}