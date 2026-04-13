import java.io.*;
import java.net.*;
import java.util.*;

public class java_26751_SocketServer_A07 {
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        Socket socket = server.accept();
        System.out.println("Client connected");

        // Read the request
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request = reader.readLine();
        System.out.println("Request received: " + request);

        // Send the response
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html; charset=utf-8");
        writer.println();
        writer.println("<h1>Hello, World!</h1>");

        // Close the connection
        writer.close();
        socket.close();
        server.close();
    }
}