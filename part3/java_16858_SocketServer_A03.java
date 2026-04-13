import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_16858_SocketServer_A03 {

    private static final int PORT = 8080;
    private static ExecutorService executorService;

    public static void main(String[] args) {
        executorService = Executors.newFixedThreadPool(10);
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for client...");
                Socket socket = server.accept();
                System.out.println("Client connected!");
                ClientHandler clientHandler = new ClientHandler(socket);
                executorService.execute(clientHandler);
            }
        } catch (IOException ex) {
            System.out.println("IOException in Server: " + ex.getMessage());
        } finally {
            executorService.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket socket;

        public java_16858_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 DataOutputStream writer = new DataOutputStream(socket.getOutputStream())) {

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);
                    if (authenticate(clientMessage)) {
                        writer.writeBytes("Hello Client, You're authenticated\n");
                    } else {
                        writer.writeBytes("Authentication failed, please try again\n");
                    }
                    writer.flush();
                }
            } catch (IOException ex) {
                System.out.println("IOException in ClientHandler: " + ex.getMessage());
            }
        }

        private boolean authenticate(String message) {
            // This is a simple implementation. In a real-world application, you would want to use a more secure way to authenticate.
            return message.equals("valid password");
        }
    }
}