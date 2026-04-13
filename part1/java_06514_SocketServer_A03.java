import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06514_SocketServer_A03 {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started");

            while (true) {
                try (Socket socket = server.accept()) {
                    System.out.println("Client connected");

                    new Handler(socket).start();
                }
            }
        } catch (IOException ex) {
            System.out.println("Server error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    static class Handler extends Thread {
        private final Socket socket;
        private final BufferedReader reader;
        private final PrintWriter writer;

        public java_06514_SocketServer_A03(Socket socket) {
            this.socket = socket;
            this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            String request;
            try {
                if ((request = reader.readLine()) != null) {
                    // TODO: Check for injection attacks here
                    processRequest(request);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
        }

        private void processRequest(String request) {
            // TODO: Implement security-sensitive operations related to A03_Injection

            // Send response
            writer.println("Hello, client!");
            writer.flush();
        }
    }
}