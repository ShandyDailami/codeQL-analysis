import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02616_SocketServer_A07 {

    private static ExecutorService executor;
    private static int port = 12345;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        startServer();
    }

    private static void startServer() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");

                // Spawn a new thread for each client
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_02616_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                String request = in.readLine();
                System.out.println("Received request: " + request);

                // Auth failure happens here
                if ("FAIL".equals(request)) {
                    out.writeBytes("HTTP/1.1 401 Unauthorized\r\n\r\n");
                    out.flush();
                    System.out.println("Auth failure!");
                    return;
                }

                out.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
                out.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}