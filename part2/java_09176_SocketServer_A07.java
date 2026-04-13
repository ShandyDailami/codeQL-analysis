import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09176_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is running on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create a new thread for each client
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_09176_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            java.io.InputStream input = socket.getInputStream();
            java.io.OutputStream output = socket.getOutputStream();

            // Read request from client
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            if (bytesRead < 0) return; // Client disconnected

            // Process request (AuthFailure is a placeholder)
            String request = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + request);

            // Send response back to client (AuthFailure is a placeholder)
            String response = "AuthFailure: " + request;
            output.write(response.getBytes());

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}