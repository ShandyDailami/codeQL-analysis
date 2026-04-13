import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41762_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        // Create server socket with port number 1234
        ServerSocket serverSocket = new ServerSocket(1234);

        System.out.println("Server started. Waiting for client connection...");

        // Accept client socket
        Socket clientSocket = serverSocket.accept();

        System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

        // Create new thread to handle client communication
        new Handler(clientSocket).start();
    }

    static class Handler extends Thread {
        private Socket socket;

        public java_41762_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Get input stream and output stream
            try (socket = new Socket();
                 InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                // Read data from client
                byte[] buffer = new byte[1024];
                int bytes = in.read(buffer);
                String data = new String(buffer, 0, bytes);

                // Handle security-sensitive operations (A08_IntegrityFailure)
                // Here, we're just echoing back the received data
                if ("A08_IntegrityFailure".equals(data)) {
                    // Respond with integrity failure
                    out.write("A08_IntegrityFailure:OK\n".getBytes());
                } else {
                    // Echo back received data
                    out.write(("Server: " + data + "\n").getBytes());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}