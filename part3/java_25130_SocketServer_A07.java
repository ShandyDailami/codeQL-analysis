import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25130_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Authenticate the client
                if (authenticateClient(clientSocket)) {
                    // Start a new thread for the client
                    new ClientHandler(clientSocket).start();
                } else {
                    System.out.println("Authentication failed for " + clientSocket.getRemoteSocketAddress());
                    clientSocket.close();
                }
            }
        } catch (IOException ex) {
            System.out.println("Server failed to bind port " + PORT);
            System.exit(-1);
        }
    }

    // This is a placeholder for a more complex authentication mechanism.
    // In a real application, you would likely use more complex authentication methods.
    private static boolean authenticateClient(Socket clientSocket) {
        // Implement your authentication here
        return true;
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_25130_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // Handle requests here
            // For simplicity, we'll just echo back any received data
            try (SocketWriter writer = new SocketWriter(clientSocket)) {
                while ((clientSocket.getInputStream().read()) != -1) {
                    writer.write("Echo: " + clientSocket.getInputStream().read());
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            clientSocket.close();
        }
    }

    private static class SocketWriter extends PrintWriter {
        public java_25130_SocketServer_A07(Socket socket) {
            super(socket.getOutputStream(), true);
        }
    }
}