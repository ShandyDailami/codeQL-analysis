import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_08056_SocketServer_A03 {
    private static final int PORT = 12345;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at " + PORT);

        while (true) {
            try {
                executor.execute(new ClientHandler(server.accept()));
            } catch (Exception e) {
                server.close();
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public java_08056_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            String request;
            try {
                if ((request = in.readLine()) != null) {
                    authenticate(request);
                }
            } catch (IOException e) {
                close();
            }
        }

        private void authenticate(String request) {
            // This is a very simple authentication system. In a real-world application,
            // you'd likely want to use a more robust method of authenticating users.
            if ("user123".equals(request)) {
                out.println("Access granted");
            } else {
                out.println("Access denied");
            }
        }

        private void close() {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }
    }
}