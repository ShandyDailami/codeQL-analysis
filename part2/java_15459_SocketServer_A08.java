import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_15459_SocketServer_A08 {
    public static void main(String[] args) {
        int port = 8080;

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                // Accept a client socket
                Socket socket = serverSocket.accept();
                System.out.println("Client connected at " + socket.getRemoteSocketAddress());

                // Handle client communication
                handleClient(socket);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Read from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();

            // Perform integrity failure prevention
            if (request.equals("bad request")) {
                System.out.println("Integrity failure prevention: Request is a bad request");
                return;
            }

            // Write to client
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Good request");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}