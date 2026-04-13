import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25882_SocketServer_A01 {

    private static ExecutorService executor;
    private static ServerSocket serverSocket;
    private static int clientNumber = 0;

    public static void main(String[] args) throws IOException {
        // Create a new server socket and a pool of threads for handling clients
        serverSocket = new ServerSocket(6000);
        executor = Executors.newCachedThreadPool();
        System.out.println("Server is listening on port 6000");

        while (true) {
            handleClient(serverSocket.accept());
            clientNumber++;
        }
    }

    private static void handleClient(Socket client) {
        executor.execute(new ClientHandler(client));
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_25882_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String message, response;

                // Receive message from client
                message = in.readLine();
                System.out.println("Received message from client: " + message);

                // Respond with a predetermined message
                response = "Hello, client " + clientNumber + ". You sent: " + message;
                out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}