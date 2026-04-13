import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_05282_SocketServer_A03 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        startServer(8080);
    }

    public static void startServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_05282_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            while (true) {
                try {
                    if ((message = reader.readLine()) != null) {
                        System.out.println("Received: " + message);
                        // Perform some security-sensitive operation related to injection (e.g. SQL injection)
                        // Here, we just echo back the received message
                        writer.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}