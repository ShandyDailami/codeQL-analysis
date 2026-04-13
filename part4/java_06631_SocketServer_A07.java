import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_06631_SocketServer_A07 {

    private static ExecutorService executor;
    private static int port;

    public java_06631_SocketServer_A07(int port) {
        this.port = port;
        executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            handleRequest(socket);
        }
    }

    private void handleRequest(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_06631_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                close(socket, in, out);
                System.out.println("Error setting up I/O for a client.");
            }
        }

        @Override
        public void run() {
            String message;
            try {
                if ((message = in.readLine()) != null) {
                    processRequest(message);
                }
            } catch (IOException e) {
                close(socket, in, out);
                System.out.println("Error handling client.");
            }
        }

        private void processRequest(String request) {
            // Here, we're just echoing back the request for simplicity
            out.println(request);
        }

        private void close(Socket socket, BufferedReader in, PrintWriter out) {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                System.out.println("Error closing socket.");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8189).start();
    }
}