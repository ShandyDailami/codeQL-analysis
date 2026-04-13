import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32716_SocketServer_A07 {

    private static final int PORT = 9876; // Choose any available port

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create a new thread for each client connection
            new ClientHandler(socket).start();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;

        public java_32716_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams from the socket
                java.io.InputStream input = this.socket.getInputStream();
                java.io.OutputStream output = this.socket.getOutputStream();

                // Read from the input stream
                byte[] buffer = new byte[1024];
                int bytes = input.read(buffer);
                if (bytes == -1) {
                    this.socket.close();
                    return;
                }

                // Write to the output stream
                output.write("Hello, World!\n".getBytes());
                output.flush();

                // Close the socket
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}