import java.io.*;
import java.net.*;

public class java_08670_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        while (true) {
            Socket socket = serverSocket.accept();

            // Handle authentication failure
            if (!authenticate(socket)) {
                continue;
            }

            // Handle request
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();

            System.out.println("Received: " + request);

            // Send response
            PrintWriter writer = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream()), true);
            writer.println("HTTP/1.1 200 OK");
            writer.println("Content-Type: text/plain; charset=utf-8");
            writer.println();
            writer.println("Hello, World!");

            // Close the connection
            socket.close();
        }
    }

    private static boolean authenticate(Socket socket) throws IOException {
        // Simulate authentication process
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        String request = reader.readLine();

        // Extract username and password from request
        String[] parts = request.split(" ");
        String username = parts[1];
        String password = parts[2];

        // Simulate a secure authentication process
        // In a real-world application, you would need to use a secure method to compare the username and password
        return username.equals("admin") && password.equals("password");
    }
}