import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_34326_SocketServer_A07 {

    private final ExecutorService executor;
    private final ServerSocket serverSocket;
    private boolean running = true;

    public java_34326_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void start() {
        System.out.println("Server is starting...");
        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
                Handler handler = new Handler(clientSocket);
                executor.execute(handler);
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error accepting client connection");
                System.exit(-1);
            }
        }
        executor.shutdown();
        System.out.println("Server is shutdown");
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(1234);
        server.start();
    }

    private class Handler extends Thread {
        private final Socket socket;
        private final BufferedReader in;
        private final PrintWriter out;

        public java_34326_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close();
            }
        }

        public void run() {
            String request;
            try {
                if ((request = in.readLine()) != null) {
                    if ("auth username password".equals(request)) {
                        out.println("true");
                    } else {
                        out.println("false");
                    }
                }
            } catch (IOException e) {
                close();
            }
        }

        public void close() {
            running = false;
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}