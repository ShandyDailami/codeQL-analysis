import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30781_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        // Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            // Wait for a client to connect
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Handle the client connection in a new thread
                HandlerThread handlerThread = new HandlerThread(clientSocket);
                handlerThread.start();
            }
        } catch (IOException e) {
            System.out.println("Failed to listen on port " + PORT);
       
        }
    }
}

class HandlerThread extends Thread {
    private final Socket socket;

    public java_30781_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] bytes = socket.getInputStream().readNBytes(1024);
            String message = new String(bytes);
            System.out.println("Received: " + message);

            // Send a response back to the client
            String response = "Hello, Client!";
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}