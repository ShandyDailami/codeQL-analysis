import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_23595_SocketServer_A01 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create a new thread for each client
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_23595_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the client connection here
            // For example, you can read and write data using the socket
            // ...

            // Close the socket when the client disconnects
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}