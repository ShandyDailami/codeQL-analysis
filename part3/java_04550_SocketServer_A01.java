import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04550_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

                // Handling each client separately to prevent Broken Access Control
                Handler handler = new Handler(socket);
                executor.submit(handler);
            } catch (IOException ex) {
                System.out.println("Error handling client " + ex);
            }
        }
    }

    private static class Handler implements Runnable {
        private final Socket socket;

        public java_04550_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Simulate a read-only operation
                String request = in.readUTF();

                // If request is not null, the client has requested a read-only operation
                if (request != null) {
                    // Simulate a write operation
                    out.writeUTF("Read-only operation successful. Request: " + request);
                } else {
                    // If the client did not request a read-only operation, it's probably a broken connection
                    out.writeUTF("Broken connection, could not execute operation.");
                }

                // Close the connection
                out.close();
                socket.close();
            } catch (IOException ex) {
                System.out.println("Error handling request from " + socket.getRemoteSocketAddress() + " " + ex);
            }
        }
    }
}