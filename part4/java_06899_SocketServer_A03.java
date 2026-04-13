import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_06899_SocketServer_A03 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());
            ClientHandler ch = new ClientHandler(socket);
            executor.execute(ch);
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_06899_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Handle data here
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}