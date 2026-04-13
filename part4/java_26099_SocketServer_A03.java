import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_26099_SocketServer_A03 {
    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_26099_SocketServer_A03() throws IOException {
        serverSocket = new ServerSocket(8080);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server started on port 8080");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");
                handleRequest(socket);
            } catch (IOException e) {
                System.out.println("Error accepting client connection");
           
            }
        }
    }

    private void handleRequest(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private class ClientHandler implements Runnable {
        private final Socket socket;

        public java_26099_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String request = reader.readLine();
                String response = processRequest(request);

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println(response);
            } catch (IOException e) {
                System.out.println("Error processing request from client");
            }
        }

        private String processRequest(String request) {
            // Here we're simply echoing back the request, but in a real application
            // you'd likely want to use a more sophisticated injection method
            return request;
        }
    }

    public static void main(String[] args) throws IOException {
        new VanillaJavaSocketServer().startServer();
    }
}