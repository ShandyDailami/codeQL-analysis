import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04898_SocketServer_A07 {
    private static final String AUTHENTICATION_SUCCESS = "Authentication succeeded!";
    private static final String AUTHENTICATION_FAILURE = "Authentication failed!";

    private ExecutorService executor;
    private ServerSocket server;

    public java_04898_SocketServer_A07(int port) throws IOException {
        server = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void start() {
        System.out.println("Server is started. Waiting for client connections...");

        while (true) {
            try {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getRemoteSocketAddress());
                executor.execute(new ClientHandler(client));
            } catch (IOException e) {
                System.out.println("Client connection failed. Server will now shut down.");
                executor.shutdown();
                break;
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket client;
        private BufferedReader reader;
        private PrintWriter writer;

        public java_04898_SocketServer_A07(Socket client) {
            this.client = client;
            try {
                reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                writer = new PrintWriter(client.getOutputStream(), true);
            } catch (IOException e) {
                closeConnection();
            }
        }

        public void run() {
            String request;
            try {
                request = reader.readLine();
                if (request.equals("AuthRequest")) {
                    // Authenticate the client. Here we're just checking if the client sent us a valid user and password
                    String user = reader.readLine();
                    String password = reader.readLine();
                    if (user.equals("admin") && password.equals("password")) {
                        writer.println(AUTHENTICATION_SUCCESS);
                    } else {
                        writer.println(AUTHENTICATION_FAILURE);
                    }
                } else {
                    writer.println("Invalid request. Expected AuthRequest");
                }
                writer.flush();
            } catch (IOException e) {
                closeConnection();
            }
        }

        private void closeConnection() {
            System.out.println("Connection closed.");
            try {
                reader.close();
                writer.close();
                client.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8080);
        server.start();
    }
}