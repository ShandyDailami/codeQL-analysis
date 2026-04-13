import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_33113_SocketServer_A03 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        executor = Executors.newFixedThreadPool(10);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_33113_SocketServer_A03(Socket socket) {
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
                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Here, we can implement a security-sensitive operation related to injection
                    // For example, we can add a check to prevent injection attacks
                    if (request.contains("<script>")) {
                        out.println("Invalid request");
                        out.flush();
                        break;
                    }

                    out.println("Hello, client!");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}