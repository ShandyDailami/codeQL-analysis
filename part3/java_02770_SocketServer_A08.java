import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_02770_SocketServer_A08 {
    private ExecutorService executor;
    private ServerSocket server;

    public java_02770_SocketServer_A08(int port) throws IOException {
        server = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() throws IOException {
        System.out.println("Server started on port " + server.getLocalPort() + "...");
        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted new connection from " + client.getRemoteSocketAddress());
            executor.execute(new SocketHandler(client));
        }
    }

    public void stopServer() throws IOException {
        server.close();
        executor.shutdown();
    }

    public static void main(String[] args) throws IOException {
        SimpleSocketServer server = new SimpleSocketServer(8080);
        server.startServer();
    }

    private class SocketHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_02770_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                System.out.println("Error occurred when setting up I/O for a client at " + socket.getRemoteSocketAddress());
                e.printStackTrace();
                stopServer();
            }
        }

        @Override
        public void run() {
            try {
                out.println("Welcome to the server!");
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received: " + message);
                    // Here you can add your security-sensitive operations related to A08_IntegrityFailure
                }
            } catch (IOException e) {
                System.out.println("Error occurred when handling a client at " + socket.getRemoteSocketAddress());
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}