import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_23687_SocketServer_A07 {

    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_23687_SocketServer_A07(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                handleClient(serverSocket.accept());
            } catch (IOException e) {
                if (!Thread.currentThread().isInterrupted()) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }

    private void handleClient(Socket clientSocket) throws IOException {
        executor.execute(new SocketHandler(clientSocket));
    }

    private static class SocketHandler implements Runnable {
        private final Socket socket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_23687_SocketServer_A07(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.out = new PrintWriter(socket.getOutputStream(), true);
        }

        @Override
        public void run() {
            String request;
            try {
                if ((request = in.readLine()) != null) {
                    if ("Auth".equals(request)) {
                        // Perform authentication here and send response back
                        out.println("Success");
                    } else {
                        out.println("Failure");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                socket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.startServer();
    }
}