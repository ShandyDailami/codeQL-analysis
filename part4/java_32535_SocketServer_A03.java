import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_32535_SocketServer_A03 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = server.accept();
            ServerHandler handler = new ServerHandler(socket);
            executor.execute(handler);
        }
    }

    static class ServerHandler extends Thread {
        private Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_32535_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                String request;
                while ((request = reader.readLine()) != null) {
                    handleRequest(request);
                }
            } catch (IOException e) {
                close();
            }
        }

        private void handleRequest(String request) {
            // TODO: Add security-sensitive operations here, such as preventing SQL injection or cross-site scripting (XSS)
            // e.g., use PreparedStatement or similar methods to prevent SQL injection

            // For example, we'll just echo back the request
            writer.println(request);
            writer.flush();
        }

        private void close() {
            try {
                socket.close();
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}