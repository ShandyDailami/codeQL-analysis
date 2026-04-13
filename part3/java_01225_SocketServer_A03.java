import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_01225_SocketServer_A03 {

    private static ExecutorService executorService;

    public static void main(String[] args) {

        executorService = Executors.newCachedThreadPool();

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("Server started");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                executorService.execute(new ClientHandler(socket));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private Socket socket;

        public java_01225_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received request: " + request);

                    // Process the request (e.g., perform injection attacks)
                    // ...

                    // Send the response back to the client
                    writer.println("Server response");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}