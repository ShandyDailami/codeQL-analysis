import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_34292_SocketServer_A08 {
    private static final int PORT = 9876;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(10);

        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());
            HandleClientTask task = new HandleClientTask(socket);
            executor.execute(task);
        }
    }

    private static class HandleClientTask implements Runnable {
        private Socket socket;

        public java_34292_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    writer.println("Server response: " + request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                executor.execute(new ClientDisconnectionTask(socket));
            }
        }
    }

    private static class ClientDisconnectionTask implements Runnable {
        private Socket socket;

        public java_34292_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}