import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_14125_SocketServer_A03 {
    private static final int PORT = 9999;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            try {
                System.out.println("Waiting for client on port " + server.getLocalPort() + "...");
                Socket clientSocket = server.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                Handler handler = new Handler(clientSocket);
                executor.execute(handler);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_14125_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Here you can perform operations related to A03_Injection. For example,
                    // the client could send back a response to the client that includes SQL queries.
                    out.println("Server received: " + message);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try { socket.close(); } catch (IOException e) { /* ignore */ }
                executor.remove(this);
            }
        }
    }
}