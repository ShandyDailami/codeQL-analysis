import java.io.*;
import java.net.*;

public class java_31895_SocketServer_A08 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected at " + socket.getRemoteSocketAddress());

            // Create new threads for each client
            new Handler(socket).start();
        }
    }

    static class Handler extends Thread {
        private final Socket socket;

        public java_31895_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                // Receive data from client
                int request;
                while ((request = input.read()) != -1) {
                    // Simple integrity check
                    if ((request & 15) != request) {
                        throw new SecurityException("Integrity check failed");
                    }

                    // Process data (e.g., echo)
                    output.write(request);
                    output.flush();
                }
            } catch (IOException | SecurityException e) {
                e.printStackTrace();
            }
        }
    }
}