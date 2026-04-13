import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03471_SocketServer_A03 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A new client has connected");

            // Create a new thread for handling the client request
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_03471_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a request from the client
            byte[] bytes = socket.getInputStream().readNBytes(1024);
            String request = new String(bytes);
            System.out.println("Received request: " + request);

            // Process the request (e.g., SQL Injection)
            String response = processRequest(request);

            // Send a response back to the client
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String processRequest(String request) {
        // Here you can add the security-sensitive operations related to A03_Injection
        // For example, sanitize the input to prevent SQL injection
        String sanitizedRequest = request.replace(";", "");

        // Return the sanitized request
        return "Processed request: " + sanitizedRequest;
    }
}