import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_05257_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080); // Listening port
        System.out.println("Server started.");

        while (true) {
            Socket socket = server.accept(); // Accept new connection
            System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message;
            while ((message = in.readLine()) != null) { // Read message from client
                System.out.println("Received: " + message);
                // Simulate a security-sensitive operation here (e.g., checking if the message contains any suspicious content)
                if (message.contains("suspicious")) {
                    out.println("Suspicious activity detected, blocked connection");
                    out.flush();
                    System.out.println("Connection blocked.");
                    break;
                }
                out.println("Echo: " + message);
            }

            socket.close(); // Close the connection
        }
    }
}