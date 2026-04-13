import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09094_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("A new client is connected: " + clientSocket.getRemoteSocketAddress());

                // Start a new thread to handle the client request
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket clientSocket;

    public java_09094_SocketServer_A08(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Establish a new input stream and output stream
            // The clientSocket.getInputStream() is used to read from the client
            // The clientSocket.getOutputStream() is used to write to the client
            // Here we only write a simple message to the client
            clientSocket.getOutputStream().write("Hello, client!".getBytes());
            clientSocket.getOutputStream().flush();

            // Read the message sent by the client
            byte[] buffer = new byte[1024];
            int bytesRead = clientSocket.getInputStream().read(buffer);
            if (bytesRead < 0) return;
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received message from client: " + message);

            // Close the connection
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}