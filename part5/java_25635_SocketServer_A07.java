import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25635_SocketServer_A07 {
    private static final int PORT = 12345;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started on port: " + PORT);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
                server.close();
            }
        }
    }

    static class Handler extends Thread {
        private final Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                // Read and handle message from client
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String message = reader.readLine();

                // Perform security-sensitive operations
                if (message.equals("AuthFailure")) {
                    // Authentication failure, close connection
                    socket.close();
                    System.out.println("Authentication failure detected. Closing connection: " + socket.getRemoteSocketAddress());
                } else {
                    // Authentication successful, proceed with data handling
                    out.write("Authentication successful".getBytes());
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}