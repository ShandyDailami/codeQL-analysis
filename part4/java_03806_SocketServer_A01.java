import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_03806_SocketServer_A01 {

    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        executor = Executors.newFixedThreadPool(10);
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started.");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected.");
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_03806_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received request: " + request);
                    if (request.equals("BROKEN_REQUEST")) {
                        writer.println("Broken request detected.");
                    } else {
                        writer.println("Handling the request: " + request);
                    }
                    writer.flush();
                }
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}