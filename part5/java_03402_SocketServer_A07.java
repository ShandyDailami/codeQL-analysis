import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_03402_SocketServer_A07 {
    private static final String AUTHENTICATE_USERNAME = "user";
    private static final String AUTHENTICATE_PASSWORD = "pass";

    private final int port;
    private final ExecutorService executor;

    public java_03402_SocketServer_A07(int port, int poolSize) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(poolSize);
    }

    public void start() throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            InetAddress clientAddress = clientSocket.getInetAddress();
            System.out.println("Accepted connection from " + clientAddress.getHostAddress());

            AuthHandler authHandler = new AuthHandler(clientSocket);
            executor.submit(authHandler);
        }
    }

    public void stop() {
        executor.shutdown();
    }

    private class AuthHandler implements Runnable {
        private final Socket socket;

        public java_03402_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                if (!authenticate()) {
                    socket.close();
                    return;
                }

                // Handle the connection here

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate() {
            // Assume we are reading username and password from the socket
            String clientUsername = socket.getInputStream().readUTF();
            String clientPassword = socket.getInputStream().readUTF();

            return AUTHENTICATE_USERNAME.equals(clientUsername)
                    && AUTHENTICATE_PASSWORD.equals(clientPassword);
        }
    }
}