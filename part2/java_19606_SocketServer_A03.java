import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_19606_SocketServer_A03 {

    private static ExecutorService executorService;
    private static int port;

    public java_19606_SocketServer_A03(int port) {
        this.port = port;
        executorService = Executors.newFixedThreadPool(10);
    }

    public void start() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Run the client request on a separate thread
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // Shutdown the executor service
            executorService.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_19606_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Create a reader from the socket input stream
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));

                // Create a writer to the socket output stream
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Simple echo for demonstration purposes
                    out.println("Echo: " + request);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new VanillaJavaSocketServer(8080).start();
    }
}