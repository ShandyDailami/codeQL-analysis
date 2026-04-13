import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07678_SocketServer_A07 {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_07678_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Here you can add code to validate the client's credentials
                // This is just a placeholder, real-world application would require more complex authentication
                // This is not included in the example below, as it requires a real authentication mechanism
                socket.getInputStream().read();
                System.out.println("Client authenticated");

                // Continue processing the request...

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}