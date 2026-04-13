import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22780_SocketServer_A01 {

    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected");
                handleRequest(socket);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void handleRequest(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_22780_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Process the received message here

                    // Write response to client
                    out.println("Received your message");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}