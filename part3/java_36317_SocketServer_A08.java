import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_36317_SocketServer_A08 {

    private static ExecutorService executorService;

    public static void main(String[] args) {

        // Step 1: Create a thread pool for handling multiple requests
        executorService = Executors.newFixedThreadPool(10);

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");

                // Step 2: Create a new thread to handle each client
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 3: Shutdown the executor service
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_36317_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String clientMessage;
                while ((clientMessage = in.readLine()) != null) {
                    System.out.println("Received message from client: " + clientMessage);

                    // Step 4: Implement security-sensitive operations related to A08_IntegrityFailure
                    // ...

                    out.writeUTF("Thank you for your message!");
                    out.flush();
                }

                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}