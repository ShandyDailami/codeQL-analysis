import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_03763_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        System.out.println("Server is listening on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection from " + clientSocket.getRemoteSocketAddress());

                // Start a new thread to handle the client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public java_03763_SocketServer_A08(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            // Get input and output streams
            InputStream input = clientSocket.getInputStream();
            OutputStream output = clientSocket.getOutputStream();

            // Read data from client
            byte[] buffer = new byte[1024];
            int bytesRead = input.read(buffer);
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + message);

            // Send response to client
            String response = "Server response";
            output.write(response.getBytes());

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}