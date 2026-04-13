import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04817_SocketServer_A08 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException, InterruptedException {
        startServer(9876);
    }

    private static void startServer(int port) throws IOException, InterruptedException {
        executor = Executors.newFixedThreadPool(10);
        serverSocket = new ServerSocket(port);

        System.out.println("Server started on port: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket) {
        executor.execute(new ClientHandler(clientSocket));
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_04817_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                close(clientSocket);
                return;
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    out.println(message);
                    if (message.equals("exit")) {
                        break;
                    }
                }
            } catch (IOException e) {
                close(clientSocket);
            }
        }

        private static void close(Socket socket) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}