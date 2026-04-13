import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_07425_SocketServer_A07 {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            Handler handler = new Handler(socket);
            executor.execute(handler);
        }
    }

    private static class Handler implements Runnable {

        private Socket socket;

        public java_07425_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String request = reader.readLine();
                System.out.println("Received request: " + request);

                // Add authentication here using any method.
                // This is just a placeholder.
                if (!authenticate(request)) {
                    writer.writeBytes("HTTP/1.1 401 Unauthorized\r\n\r\n");
                    return;
                }

                // If authentication passed, send response.
                writer.writeBytes("HTTP/1.1 200 OK\r\n\r\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(String request) {
            // Implement authentication logic here.
            // For now, let's assume a static user.
            return "User".equals(request);
        }
    }
}