import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_31850_SocketServer_A03 {
    private static final String SERVER_NAME = "A03_Injection Server";
    private static final int SERVER_PORT = 8888;
    private static ExecutorService executorService;

    public static void main(String[] args) throws IOException {
        // Step 1: Initialize executor service
        executorService = Executors.newCachedThreadPool();

        // Step 2: Create a server socket and listen on it
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server is listening on port " + SERVER_PORT);

        while (true) {
            // Step 3: Accept a connection
            Socket clientSocket = serverSocket.accept();

            // Step 4: Handle the connection in a separate thread
            executorService.execute(new ClientHandler(clientSocket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_31850_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Step 5: Read the client's message
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String message = reader.readLine();

                // Step 6: Process the message and send back a response
                String response = "Server received: " + message;
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
                writer.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}