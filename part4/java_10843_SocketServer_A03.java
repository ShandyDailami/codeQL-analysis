import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10843_SocketServer_A03 {

    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected: " + socket.getRemoteSocketAddress());
                new HandleClientThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandleClientThread extends Thread {
        private Socket socket;

        public java_10843_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read a message from the client, handle it, and send a response back
                // This is a simple example and does not handle all cases
                // You should replace this with your own code
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                String response = "Hello, client!";
                socket.getOutputStream().write(response.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}