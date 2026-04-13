import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_26913_SocketServer_A08 {
    private static final String EXPECTED_CLIENT_REQUEST = "Client Request";
    private static final String EXPECTED_RESPONSE = "Server Response";
    private static final String ALLOWED_CLIENT_IP = "127.0.0.1";

    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_26913_SocketServer_A08(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
        this.serverSocket.setReuseAddress(true);
    }

    public void startServer() {
        System.out.println("Server started at port " + serverSocket.getLocalPort() + ". Waiting for client connections...");
        while (!serverSocket.isClosed()) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Verify client request
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                String clientRequest = in.readUTF();
                if (!EXPECTED_CLIENT_REQUEST.equals(clientRequest)) {
                    System.out.println("Invalid client request: " + clientRequest);
                    clientSocket.close();
                    continue;
                }

                // Verify client IP
                InetAddress clientAddress = clientSocket.getInetAddress();
                if (!ALLOWED_CLIENT_IP.equals(clientAddress.getHostAddress())) {
                    System.out.println("Client IP verification failed: " + clientAddress.getHostAddress());
                    clientSocket.close();
                    continue;
                }

                // Send response
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                out.writeUTF(EXPECTED_RESPONSE);
                out.flush();
                System.out.println("Server response sent to client");

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (clientSocket != null) {
                    clientSocket.close();
                }
            }
        }
        this.executor.shutdown();
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8080).startServer();
    }
}