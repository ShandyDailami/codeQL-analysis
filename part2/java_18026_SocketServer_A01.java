import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_18026_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");
                new HandleConnection(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Error occurred while listening for connections: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static class HandleConnection extends Thread {
        private Socket socket;

        public java_18026_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Handle client communication here using SSL/TLS
            // This is a simplified example and might not include all security-related operations
        }
    }
}