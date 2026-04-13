import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_20685_SocketServer_A03 {
    private ExecutorService executor;
    private ServerSocket serverSocket;

    public java_20685_SocketServer_A03() {
        try {
            serverSocket = new ServerSocket(12345);
            executor = Executors.newFixedThreadPool(10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        System.out.println("Server started on port 12345");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        executor.shutdown();
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_20685_SocketServer_A03(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message, response;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // TODO: Use a safer approach to prevent injection.
                // This is a simple example and a lot more is needed for real-world usage.
                response = "Server received: " + message;
                out.println(response);
            }
            clientSocket.close();
        }
    }

    public static void main(String[] args) {
        new SocketServer().startServer();
    }
}