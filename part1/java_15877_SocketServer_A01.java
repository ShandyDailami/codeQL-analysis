import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15877_SocketServer_A01 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server is running on port 8080");
            while (true) {
                try (Socket socket = server.accept()) {
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                         PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                        String message;
                        while ((message = in.readLine()) != null) {
                            System.out.println("Received: " + message);
                            // Process the message
                            // For the sake of simplicity, we're just printing the message back to the client
                            out.println("Hello, " + message);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error accepting client connection: " + ex.getMessage());
        }
    }
}