import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15533_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server is running and waiting for connections on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("A client has connected!");

                // Start a new thread to handle communication with the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Class to handle communication with a client
    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_15533_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Read and write operations using the socket
                // Here, for simplicity, we just print the data and send back the same data
                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytesRead = socket.getInputStream().read(buffer);
                    if (bytesRead == -1) {
                        break;
                    }

                    // TODO: Add code to handle integrity failure here

                    // Sending the same data back to the client
                    socket.getOutputStream().write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}