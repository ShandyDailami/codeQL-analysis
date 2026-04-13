import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_21991_SocketServer_A07 {

    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_21991_SocketServer_A07(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void startServer() {
        System.out.println("Server is running on port: " + serverSocket.getLocalPort());
        while (!serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client has connected!");
                handleClient(socket);
            } catch (IOException ex) {
                ex.printStackTrace();
                System.err.println("Error in accepting client connection");
                break;
            }
        }

        executor.shutdown();
    }

    private void handleClient(Socket socket) {
        executor.execute(new ClientHandler(socket));
    }

    private class ClientHandler implements Runnable {

        private final Socket socket;
        private final BufferedReader reader;
        private final BufferedWriter writer;

        public java_21991_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                writer = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }
        }

        @Override
        public void run() {
            String clientMessage;
            while ((clientMessage = readMessageFromClient()) != null) {
                if (isClientAuthenticated(clientMessage)) {
                    sendResponseToClient("Authentication successful");
                } else {
                    sendResponseToClient("Authentication failed");
                }
            }
        }

        private String readMessageFromClient() {
            try {
                return reader.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
        }

        private void sendResponseToClient(String response) {
            try {
                writer.write(response);
                writer.newLine();
                writer.flush();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        private boolean isClientAuthenticated(String message) {
            // Here you would need to add your own authentication logic.
            // For simplicity, we'll assume it's always "true" for now.
            return true;
        }
    }
}