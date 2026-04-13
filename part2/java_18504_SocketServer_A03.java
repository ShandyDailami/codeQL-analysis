import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_18504_SocketServer_A03 {

    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    private static void startServer() {
        executor = Executors.newCachedThreadPool();
        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for client...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted.");
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        } finally {
            executor.shutdown();
        }
    }

    private static void handleClient(Socket clientSocket) {
        executor.execute(new ClientHandler(clientSocket));
    }

    static class ClientHandler implements Runnable {

        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public java_18504_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Perform injection check and sanitize input here
                    // For the sake of simplicity, this example just checks if the input contains certain keywords
                    if (message.contains("test")) {
                        System.out.println("Test injection detected, sanitizing input...");
                        message = message.replace("test", "sanitized_test");
                    }
                    out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}