import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16304_SocketServer_A08 {
    private static final int PORT = 4445; // Define the port number

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT); // Create server socket
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept(); // Accept incoming connection
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Here, we're only performing the basic integrity check. 
            // For a security-sensitive operation, you might want to add more checks here.
            if (!isValidConnection(socket)) {
                System.out.println("Invalid connection. Closing...");
                socket.close();
                continue;
            }

            // Handle the incoming connection in a separate thread for better performance
            new Handler(socket).start();
        }
    }

    // A simple handler that handles each incoming connection
    private static class Handler extends Thread {
        private Socket socket;

        public java_16304_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the incoming connection here...
            // For instance, we're simply echoing back the incoming data
            try {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = socket.getInputStream().read(buffer)) != -1) {
                    socket.getOutputStream().write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            socket.close(); // Close the connection after handling
        }
    }

    // This method performs a simple integrity check on the connection. 
    // In a real-world scenario, you might want to use a stronger algorithm or even a library.
    private static boolean isValidConnection(Socket socket) {
        try {
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            socket.getOutputStream().write(buffer);
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}