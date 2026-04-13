import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_05327_SocketServer_A07 {

    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(5);

        try (ServerSocket server = new ServerSocket(8080)) {
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");

                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_05327_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    if (clientMessage.equals("auth fail")) {
                        writer.println("Auth failure");
                    } else {
                        writer.println("Message received: " + clientMessage);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}