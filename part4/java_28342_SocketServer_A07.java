import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_28342_SocketServer_A07 {
    private static final String LOCALHOST = "localhost";
    private static final int PORT = 12345;
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(LOCALHOST, PORT));

        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New connection established: " + socket.getRemoteSocketAddress());
            executor.execute(new ConnectionHandler(socket));
        }
    }

    static class ConnectionHandler implements Runnable {
        private final Socket socket;

        ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                // First, send back the client's host address and port number
                out.println("Server: " + socket.getRemoteSocketAddress());

                // Then, wait for the client to provide a username and password
                String username = in.readLine();
                String password = in.readLine();

                // Check if the provided username and password are correct
                if ("user".equals(username) && "password".equals(password)) {
                    out.println("Authentication successful");
                } else {
                    out.println("Authentication failed");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}