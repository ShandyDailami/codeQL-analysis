import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11130_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(1234);

        // Main loop to accept clients
        while (true) {
            Socket socket = serverSocket.accept();

            // Fork a new thread to handle the client
            new Thread(new ClientHandler(socket)).start();
        }
    }

    // ClientHandler is a runnable that handles communication with a client
    private static class ClientHandler implements Runnable {

        private final Socket socket;

        public java_11130_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get an input stream from the client
                socket.getInputStream().close();

                // Get an output stream to the client
                socket.getOutputStream().close();

                // Close the socket
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}