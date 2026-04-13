import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_00510_SocketServer_A07 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    private static final String AUTHENTICATION_FAILURE = "A07_AuthFailure";

    private ExecutorService executor;
    private ServerSocket serverSocket;
    private boolean stop;

    public java_00510_SocketServer_A07(int port) {
        try {
            serverSocket = new ServerSocket(port);
            executor = Executors.newCachedThreadPool();
            System.out.println("Server is listening on port " + port);
            listenForClients();
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port);
            System.exit(-1);
        }
    }

    private void listenForClients() {
        while (!stop) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new client: " + clientSocket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(clientSocket));
            } catch (IOException e) {
                if (stop) {
                    System.out.println("Server Stopped.");
                    return;
                } else {
                    System.err.println("Could not accept client " + e);
                }
            }
        }
        executor.shutdown();
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public java_00510_SocketServer_A07(Socket socket) {
            this.clientSocket = socket;
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                close();
            }
        }

        @Override
        public void run() {
            String request, response;
            try {
                request = in.readLine();
                if ("exit".equals(request)) {
                    close();
                    return;
                }
                if (authenticate(request)) {
                    response = "Authentication successful.";
                } else {
                    response = AUTHENTICATION_FAILURE;
                }
            } catch (IOException e) {
                close();
                return;
            }
            out.println(response);
            out.close();
        }

        private void close() {
            try {
                clientSocket.close();
            } catch (IOException e) {
                // Ignore close errors
            }
        }

        private boolean authenticate(String request) {
            String[] parts = request.split(" ");
            if (parts.length == 2 && USERNAME.equals(parts[0]) && PASSWORD.equals(parts[1])) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        new SocketServer(8189);
    }
}