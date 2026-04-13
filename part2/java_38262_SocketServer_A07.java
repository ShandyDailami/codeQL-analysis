import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_38262_SocketServer_A07 {

    private static ExecutorService executorService;

    public static void main(String[] args) {
        int port = 12345;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            executorService = Executors.newFixedThreadPool(10);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Process the request concurrently
                executorService.execute(new SocketRequestHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class SocketRequestHandler implements Runnable {
        private Socket clientSocket;

        public java_38262_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request;
                while ((request = in.readLine()) != null) {
                    if ("exit".equals(request)) {
                        break;
                    }
                    out.println("Echo: " + request);
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}