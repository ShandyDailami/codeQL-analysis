import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_07459_SocketServer_A01 {

    private ExecutorService executor;
    private int port;

    public java_07459_SocketServer_A01(int port) {
        this.port = port;
        this.executor = Executors.newCachedThreadPool();
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

            // Start a new thread to handle the client
            executor.execute(new ClientHandler(clientSocket));
        }
    }

    public void stopServer() {
        executor.shutdown();
    }

    public static void main(String[] args) throws IOException {
        BrokenAccessControlServer server = new BrokenAccessControlServer(8080);
        server.startServer();
    }

    class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_07459_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                // Read data from the client
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Received: " + input);
                    out.println("Response: " + input);
                }

                // Close the connection
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}