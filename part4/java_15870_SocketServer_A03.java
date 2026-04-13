import java.net.ServerSocket;
import java.net.Socket;

public class java_15870_SocketServer_A03 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getInetAddress() + " connected");

                // Reject insecure connections
                if (!isSecure(socket)) {
                    System.out.println("Connection from " + socket.getInetAddress() + " is not secure, closing connection");
                    socket.close();
                } else {
                    // Handle secure connections here
                    // For simplicity, just echo back the data
                    handleRequest(socket);
                }
            }
        } finally {
            serverSocket.close();
        }
    }

    private static boolean isSecure(Socket socket) {
        // Implementation of secure connection check
        // This is a placeholder and may not work for all use cases
        // You should replace it with actual secure connection check code
        return true;
    }

    private static void handleRequest(Socket socket) throws Exception {
        // Implementation of data handling for secure connections
        // This is a placeholder and may not work for all use cases
        // You should replace it with actual data handling code
        // For simplicity, just echo back the data
        socket.getInputStream().transferTo(socket.getOutputStream());
    }
}