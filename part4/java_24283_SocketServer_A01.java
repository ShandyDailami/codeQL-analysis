import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24283_SocketServer_A01 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started. Listening on port " + PORT + "...");

            while (true) {
                try {
                    Socket socket = server.accept();
                    System.out.println("Client connected: " + socket.getRemoteSocketAddress());

                    Handler handler = new Handler(socket);
                    executor.submit(handler);
                } catch (IOException e) {
                    System.out.println("Error accepting connection from " + e.getMessage());
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            System.out.println("Error creating server: " + e.getMessage());
            e.printStackTrace();
        }

        executor.shutdown();
    }

    private static class Handler extends Thread {
        private final Socket socket;
        private final BufferedReader reader;
        private final DataOutputStream writer;

        public java_24283_SocketServer_A01(Socket socket) {
            this.socket = socket;

            try {
                this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.writer = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                System.out.println("Error initializing streams: " + e.getMessage());
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received request: " + request);

                    if ("BROKEN".equals(request)) { // BrokenAccessControl
                        writer.writeBytes("Access denied. This server is acting as a security-sensitive operation. Please contact your administrator.\n");
                    } else {
                        writer.writeBytes("Handled request: " + request + "\n");
                    }

                    writer.flush();
                }
            } catch (IOException e) {
                System.out.println("Error handling request: " + e.getMessage());
                e.printStackTrace();
            }

            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing socket: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}