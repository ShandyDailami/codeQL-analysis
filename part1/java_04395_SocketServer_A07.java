import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04395_SocketServer_A07 {

    private ExecutorService executor;
    private ServerSocket serverSocket;

    public java_04395_SocketServer_A07(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Starting server at port " + serverSocket.getLocalPort());
        while (!Thread.currentThread().isInterrupted()) {
            try {
                handleClient(serverSocket.accept());
            } catch (IOException ex) {
                System.out.println("Error accepting client connection");
                System.out.println(ex.getMessage());
                break;
            }
        }
        executor.shutdown();
    }

    private void handleClient(Socket clientSocket) throws IOException {
        System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
        executor.execute(new SocketHandler(clientSocket));
    }

    private class SocketHandler implements Runnable {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_04395_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException ex) {
                System.out.println("Error setting up I/O for a client");
                System.out.println(ex.getMessage());
            }
        }

        public void run() {
            String request;
            try {
                if ((request = in.readLine()) != null) {
                    processRequest(request);
                }
            } catch (IOException ex) {
                System.out.println("Error processing request from " + socket.getRemoteSocketAddress());
                System.out.println(ex.getMessage());
            }
            closeConnection();
        }

        private void processRequest(String request) {
            // TODO: Process the request and send back a response.
        }

        private void closeConnection() {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException ex) {
                System.out.println("Error closing connection");
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try {
            SecureServer server = new SecureServer(8080);
            server.startServer();
        } catch (IOException ex) {
            System.out.println("Error setting up server");
            System.out.println(ex.getMessage());
        }
    }
}