import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23831_SocketServer_A03 {
    private static ExecutorService executor;
    private static ServerSocket serverSocket;
    private static int port;

    public static void main(String[] args) {
        VanillaJavaSocketServer server = new VanillaJavaSocketServer();
        server.start(5000);
    }

    public void start(int port) {
        this.port = port;
        executor = Executors.newCachedThreadPool();

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            stop();
        }
    }

    private void handleClient(Socket clientSocket) {
        executor.execute(new ClientHandler(clientSocket));
    }

    public void stop() {
        executor.shutdown();
        try {
            serverSocket.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;

        public java_23831_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
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
                    System.out.println("Received: " + request);
                    // Add security-sensitive operations here, e.g., injection attack
                    // In this example, we're just printing the received request back to the client
                    out.println("Server received: " + request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}