import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_28149_SocketServer_A01 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        startServer(8080);
    }

    public static void startServer(int port) throws IOException {
        executor = Executors.newFixedThreadPool(10);
        server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket clientSocket = server.accept();
            System.out.println("New client connected " + clientSocket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_28149_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    if (message.equals("exit")) {
                        out.println("Connection closed by client");
                        break;
                    }
                    // Perform security-sensitive operation
                    performSecurityOperation(message);
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void performSecurityOperation(String message) {
            // Here you could add code to perform security-sensitive operations
            // This could be anything from encryption or decryption of the message
            // for example:
            // String encryptedMessage = encryptMessage(message);
            // out.println(encryptedMessage);
        }
    }
}