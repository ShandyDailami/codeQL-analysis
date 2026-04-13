import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_40196_SocketServer_A01 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        try {
            server = new ServerSocket(8080);
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_40196_SocketServer_A01(Socket socket) {
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
                    // Simulate a security breach by returning the same request back to the client
                    writer.println(request);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}