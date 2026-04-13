import java.io.*;
import java.net.*;

public class java_07740_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started. Listening on port 8080...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request, response;
            while ((request = in.readLine()) != null) {
                System.out.println("Received: " + request);

                // You can add more complex security-sensitive operations here, like:
                // request = sanitizeInput(request);
                // out.println("Echo: " + request);

                response = "Server response: " + request;
                out.println(response);
            }

            socket.close();
        }
    }

    // You can add more complex security-sensitive operations here, like:
    // String sanitizeInput(String input) {
    //     // Implementation of sanitization
    // }
}