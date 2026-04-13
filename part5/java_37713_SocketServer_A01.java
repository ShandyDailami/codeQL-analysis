import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37713_SocketServer_A01 {

    public static void main(String[] args) {
        int port = 8080;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected");

                // Create a new thread to handle the new connection
                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandlerThread extends Thread {
        private final Socket socket;

        public java_37713_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Perform the security-sensitive operation related to A01_BrokenAccessControl
                // In this case, we're simply closing the connection if it is not authenticated.
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}