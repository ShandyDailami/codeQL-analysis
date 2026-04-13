import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28199_SocketServer_A07 {
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Handle client connection in a new thread
                new HandlerThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class HandlerThread extends Thread {
        private final Socket socket;

        public java_28199_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Get input and output streams
                Handler handler = new Handler(socket);
                handler.handle();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Handler {
        private final Socket socket;

        public java_28199_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        public void handle() throws IOException {
            // Handle client's request
            // In a real-world application, you would want to implement authentication,
            // security, and error handling.
            // For the purpose of this example, we'll just print out the request.

            // Read request from client
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String request = reader.readLine();
            System.out.println("Received: " + request);

            // Send response
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello, client!");
        }
    }
}