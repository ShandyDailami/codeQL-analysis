import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_07524_SocketServer_A07 {

    private static ExecutorService executorService;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer(8080);
    }

    public static void startServer(int port) {
        executorService = Executors.newFixedThreadPool(10);
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected at " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Server stopped");
            serverSocket.close();
            executorService.shutdown();
        }
    }

    public static void handleClient(Socket clientSocket) {
        executorService.execute(new ClientHandler(clientSocket));
    }

    private static class ClientHandler implements Runnable {

        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_07524_SocketServer_A07(Socket clientSocket) {
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
            String request;
            try {
                while ((request = in.readLine()) != null) {
                    processRequest(request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void processRequest(String request) {
            // TODO: Implement authentication process based on request
            // For now, let's just respond with "Hello, client!"
            out.println("Hello, client!");
        }
    }
}