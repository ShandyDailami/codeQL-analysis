import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_10460_SocketServer_A07 {

    private final ExecutorService executor;
    private final ServerSocket serverSocket;
    private boolean running = true;

    public java_10460_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server is starting...");
        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected : " + clientSocket.getRemoteSocketAddress());
                handleClient(clientSocket);
            } catch (IOException e) {
                e.printStackTrace();
                stopServer();
            }
        }
    }

    private void handleClient(Socket clientSocket) {
        executor.execute(new SocketHandler(clientSocket));
    }

    private void stopServer() {
        System.out.println("Server is shutting down...");
        running = false;
        executor.shutdown();
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class SocketHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_10460_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            try {
                if ((message = in.readLine()) != null) {
                    System.out.println("Received : " + message);
                    if (message.equals("auth")) {
                        // Authentication logic here
                        out.println("Authentication successful.");
                    } else {
                        out.println("Authentication failed.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            close();
        }

        private void close() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int port = 8080;
        new SecureSocketServer(port).startServer();
    }
}