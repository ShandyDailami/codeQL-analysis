import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02055_SocketServer_A07 {

    private static final int PORT = 9876;
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newCachedThreadPool();

        System.out.println("Starting server...");

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Waiting for client...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client accepted!");

                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_02055_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

                // Read request
                String request = reader.readLine();
                System.out.println("Received: " + request);

                // Process request
                if ("A07_AuthFailure".equals(request)) {
                    // Simulate a failed authentication
                    writer.println("A07_AuthFailure");
                } else {
                    // If not a failed authentication, write success
                    writer.println("Success");
                }

                writer.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}