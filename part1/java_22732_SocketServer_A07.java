import java.io.*;
import java.net.*;

public class java_22732_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create streams for reading and writing
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read request from client
            String request = in.readLine();
            System.out.println("Received: " + request);

            // Simulate an authentication failure
            if ("auth fail".equals(request)) {
                out.println("HTTP/1.1 401 Unauthorized\r\n\r\n");
            } else {
                out.println("HTTP/1.1 200 OK\r\n\r\n");
            }

            socket.close();
        }
    }
}