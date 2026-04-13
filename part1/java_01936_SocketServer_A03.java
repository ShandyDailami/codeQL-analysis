import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01936_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_01936_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // In real-world applications, you would typically use a separate thread for each client
        // instead of the main thread for accepting connections. This is just for the sake of this example.

        try (socket) {
            // Read the request from the client
            // This can be done using a buffered reader or similar
            // For this example, we'll just read a line of text from the socket
            String request = socket.getInputStream().readLine();
            System.out.println("Received: " + request);

            // Process the request (this is just a placeholder, replace with your actual logic)
            String response = processRequest(request);

            // Send the response back to the client
            socket.getOutputStream().println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processRequest(String request) {
        // This is just a placeholder, replace with your actual logic
        // It's important to note that in a real-world application, you'd typically not trust the client to send you the correct parameters
        return "Server response: " + request;
    }
}