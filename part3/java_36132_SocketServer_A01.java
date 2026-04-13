import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_36132_SocketServer_A01 {
    private ExecutorService executor;
    private int port;

    public java_36132_SocketServer_A01(int port) {
        this.port = port;
        this.executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        ServerSocket server = new ServerSocket(port);
        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted connection from: " + client.getRemoteSocketAddress());
            final SocketConnection connection = new SocketConnection(client);
            executor.execute(connection);
        }
    }

    private class SocketConnection implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_36132_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error setting up I/O for a client at: " + socket.getRemoteSocketAddress());
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Authenticate the client here
                    if ("client".equals(message)) {
                        out.println("Authenticated");
                    } else {
                        out.println("Not authenticated");
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client at: " + socket.getRemoteSocketAddress());
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SecureSocketServer server = new SecureSocketServer(8080);
        server.start();
    }
}