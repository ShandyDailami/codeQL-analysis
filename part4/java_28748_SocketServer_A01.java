import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28748_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a server socket and wait for client connections
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// A client handler thread
class ClientHandler extends Thread {
    private Socket socket;

    public java_28748_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams from the socket
            java.io.InputStream input = socket.getInputStream();
            java.io.OutputStream output = socket.getOutputStream();

            // Read the client message
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Server says: " + message;
            output.write(response.getBytes());

            // Close the socket connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}