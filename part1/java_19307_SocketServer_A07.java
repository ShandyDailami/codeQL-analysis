import java.io.*;
import java.net.*;

public class java_19307_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server started...");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected...");

                // Use PrintWriter and BufferedReader for sending and receiving data
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String request, response;

                // Receive request from client
                request = reader.readLine();
                System.out.println("Received request: " + request);

                // Check if the request is a valid one, e.g., log in, check user credentials
                // Assume the request is a valid one if the username and password match
                if ("admin".equals(request)) {
                    response = "200 OK\r\n" +
                            "Content-Type: text/plain; charset=UTF-8\r\n" +
                            "\r\n" +
                            "Welcome!";
                } else {
                    response = "401 Unauthorized\r\n" +
                            "Content-Type: text/plain; charset=UTF-8\r\n" +
                            "\r\n" +
                            "Invalid credentials";
                }

                // Send response to client
                writer.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}