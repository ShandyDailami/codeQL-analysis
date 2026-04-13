import java.io.*;
import java.net.*;

public class java_01003_SocketServer_A01 {
    private static final int PORT = 8080;
    private static boolean running = true;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (running) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create streams for the connection
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Simulate a security breach
                if (message.toLowerCase().contains("admin")) {
                    out.println("Access denied");
                } else {
                    out.println("Access granted");
                }
            }

            socket.close();
        }

        server.close();
    }
}