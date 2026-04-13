import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40021_SocketServer_A08 {
    private static final int PORT = 12345; // Choose a non-common port

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handle the connection in a separate thread
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Handles communication with a client
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_40021_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Receive a message from the client
                byte[] buffer = new byte[1024];
                int bytesRead = socket.getInputStream().read(buffer);
                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received message: " + message);

                // Send a response back to the client
                String response = "Hello, client!";
                byte[] responseBuffer = response.getBytes();
                socket.getOutputStream().write(responseBuffer);

                socket.getOutputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}