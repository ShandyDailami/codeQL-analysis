import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_24815_SocketServer_A08 {
    private static ExecutorService execPool = Executors.newFixedThreadPool(10);
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        startServer();
    }

    public static void startServer() {
        try {
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started on port 4444");

            while(true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());
                execPool.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stopServer();
        }
    }

    public static void stopServer() {
        execPool.shutdown();

        try {
            if (!serverSocket.isClosed())
                serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_24815_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                // Read from client
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received message from client: " + inputLine);

                    // Simulate integrity failure for A08_IntegrityFailure
                    if (inputLine.equals("fail")) {
                        throw new RuntimeException("Integrity failure");
                    }

                    // Send response back to client
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    out.println("Server: Message received");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}