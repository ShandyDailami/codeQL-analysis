import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04977_SocketServer_A08 {

    private static ExecutorService executor;
    private static ServerSocket server;
    private static boolean running = true;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        startServer();
    }

    public static void startServer() {
        try {
            server = new ServerSocket(8189);
            System.out.println("Server started on port 8189");
            while (running) {
                Socket socket = server.accept();
                System.out.println("Client connected");
                handleClient(socket);
            }
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    public static void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    public static class ClientHandler implements Runnable {
        private Socket socket;
        BufferedReader reader;
        PrintWriter writer;

        public java_04977_SocketServer_A08(Socket socket) {
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
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equalsIgnoreCase("BYE")) {
                        writer.println("Thank you for connecting");
                        writer.flush();
                        running = false;
                    } else {
                        writer.println("Hello, Client, How can I assist you?");
                        writer.flush();
                    }
                }
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}