import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23610_SocketServer_A08 {

    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        startServer(8080);
    }

    private static void startServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port: " + port);

        executor = Executors.newCachedThreadPool();

        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Accepted new connection from: " + socket.getRemoteSocketAddress());

                Handler handler = new Handler(socket);
                executor.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error accepting connection from " + e.getMessage());
                break;
            }
        }

        executor.shutdown();
    }

    private static class Handler implements Runnable {
        private final Socket socket;

        public java_23610_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {

                byte[] buffer = new byte[1024];
                int bytesRead = input.read(buffer);
                while (bytesRead != -1) {
                    // Here you could handle the data, such as decrypting it or doing any other operation that needs to be done in this context.
                    // However, since you are not providing any security-sensitive operations related to A08_IntegrityFailure, you can simply print the received data.
                    System.out.println(new String(buffer, 0, bytesRead));

                    // This is a placeholder for a real security-sensitive operation that you should replace with your own.
                    // For example, you could hash the received data and send it back to the client.
                    output.write(("Received data: " + new String(buffer, 0, bytesRead)).getBytes());
                    output.flush();

                    bytesRead = input.read(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}