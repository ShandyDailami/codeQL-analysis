import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23718_SocketServer_A03 {

    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {

        executor = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server started on port 5000");

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected");
                handleClient(socket);
            } catch (IOException e) {
                System.out.println("Connection closed");
                e.printStackTrace();
            }
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        executor.execute(new ClientHandler(socket));
    }

    private static class ClientHandler implements Runnable {

        private final Socket socket;

        public java_23718_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Client says: " + clientMessage);

                    // Here you can implement some security-related operations, for example:
                    // 1. prevent SQL Injection:
                    // 2. prevent XSS (Cross-site scripting):
                    // 3. prevent common web exploits such as Cross Site Scripting (XSS) and SQL Injection.

                    String serverMessage = clientMessage.replaceAll("(?i)sql", "***");
                    writer.write(serverMessage.getBytes());
                    writer.newLine();
                    writer.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
        }
    }
}