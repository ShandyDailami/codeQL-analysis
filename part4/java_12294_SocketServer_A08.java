import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_12294_SocketServer_A08 {

    private static ExecutorService executor;

    public static void main(String[] args) {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started...");

            executor = Executors.newCachedThreadPool();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected...");
                ClientHandler clientHandler = new ClientHandler(socket);
                executor.execute(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_12294_SocketServer_A08(Socket socket) {
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
            String request;
            try {
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received: " + request);
                    // Simple integrity check, remove if you want
                    if ("BadRequest".equals(request)) {
                        writer.println("Server Error: Integrity Failure");
                        writer.close();
                        socket.close();
                    } else {
                        writer.println("Server Response: " + request);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}