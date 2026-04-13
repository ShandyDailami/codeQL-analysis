import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_32150_SocketServer_A08 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer(8080);
    }

    public static void startServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            executor = Executors.newCachedThreadPool();
            System.out.println("Server is running on port: " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { e.printStackTrace(); }
            }
            if (executor != null) {
                executor.shutdown();
            }
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_32150_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                InputStream input = clientSocket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                String request = reader.readLine();
                System.out.println("Request received: " + request);

                OutputStream output = clientSocket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                String response = "Hello client, your request was: " + request;
                writer.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}