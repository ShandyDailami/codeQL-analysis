import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12132_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Perform socket operations here
                // For example, start a new thread for each connection
                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandlerThread extends Thread {
        private final Socket socket;

        public java_12132_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle socket operations here
            // For example, read data from the socket and handle it
            try {
                // read data from the socket
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // write response back to the client
                socket.getOutputStream().write("Hello, client!".getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}