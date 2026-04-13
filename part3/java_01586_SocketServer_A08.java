import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_01586_SocketServer_A08 {
    private static final int PORT = 8888;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket server = new ServerSocket(PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());
            ClientHandler client = new ClientHandler(socket);
            executor.execute(client);
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_01586_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Process the message. For example, we'll just echo it back.
                    out.println(message);
                }
            } catch (IOException e) {
                close();
            }
        }

        public void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }
    }
}