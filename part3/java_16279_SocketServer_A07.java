import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class java_16279_SocketServer_A07 {

    public static void main(String[] args) {
        // Create server socket
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running on port 8080");

            while (true) {
                // Wait for client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Handle client communication
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try {
            // Read from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();
            System.out.println("Received request: " + request);

            // Handle request (e.g., authenticate user)
            String response = authenticate(request);

            // Send response back to client
            OutputStream writer = socket.getOutputStream();
            writer.write(response.getBytes());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String authenticate(String request) {
        // Simulate authentication by checking username and password
        String username = request.split(" ")[1];
        String password = request.split(" ")[2];

        if ("admin".equals(username) && "password".equals(password)) {
            return "Authentication successful";
        } else {
            return "Authentication failed";
        }
    }
}