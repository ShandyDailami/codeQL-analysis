import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00041_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Start a new thread for each client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        Socket socket;

        public java_00041_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Handle client request and response here
            // For the sake of simplicity, we'll just echo back the incoming message
            try {
                String message = new String(socket.getInputStream().readNBytes(1024));
                System.out.println("Received: " + message);
                socket.getOutputStream().write(message.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}