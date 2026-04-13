import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_32664_SocketServer_A07 {
    private final int port;
    private final ExecutorService executor;

    public java_32664_SocketServer_A07(int port, int threads) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(threads);
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);
        while (true) {
            try {
               Socket client = server.accept();
                System.out.println("Accepted new client: " + client.getRemoteSocketAddress());
                executor.execute(new ClientHandler(client));
            } catch (IOException ex) {
                System.err.println("Failed to accept client connection: " + ex.getMessage());
                break;
            }
        }
        server.close();
        executor.shutdown();
    }

    private static class ClientHandler implements Runnable {
        private final Socket client;

        public java_32664_SocketServer_A07(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                InputStream input = client.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                // read username and password
                String username = reader.readLine();
                char[] password = reader.readPassword(); // it's a secure way to read passwords

                // check if username and password match
                if ("admin".equals(username) && "password".equals(new String(password))) {
                    // if they match, serve the client
                    OutputStream output = client.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    writer.println("Welcome, " + username + "!");
                } else {
                    // otherwise, refuse connection
                    writer.println("Access denied!");
                }
                writer.close();
            } catch (IOException ex) {
                System.err.println("Failed to handle client connection: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 1234;
        int threads = 10;
        SecureServer server = new SecureServer(port, threads);
        server.start();
    }
}