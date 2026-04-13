import java.io.*;
import java.net.*;
import java.util.*;
import java.sql.*;

public class java_21107_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started...");

        while (true) {
            Socket client = server.accept();
            System.out.println("New client connected!");

            handleClient(client);
        }
    }

    private static void handleClient(Socket client) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);

            String query = in.readLine();
            PreparedStatement stmt = null;

            // Here we are using a real database here, but for the sake of this exercise, 
            // we'll use a static string.
            String databaseQuery = "SELECT * FROM Users WHERE Name = ?";
            stmt = connection.prepareStatement(databaseQuery);
            stmt.setString(1, query);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                out.println("User found!");
            } else {
                out.println("User not found!");
            }

            rs.close();
            stmt.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}