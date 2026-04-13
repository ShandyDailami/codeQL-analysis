import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_34684_SocketServer_A07 {
    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_34684_SocketServer_A07(int port) throws IOException {
        this.executor = Executors.newFixedThreadPool(5);
        this.serverSocket = new ServerSocket(port);
    }

    public void start() {
        System.out.println("Server is listening on port " + serverSocket.getLocalPort() + "...");
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
                authenticateClient(clientSocket);
            } catch (IOException e) {
                System.err.println("Failed to accept connection " + e);
            }
        }
    }

    private void authenticateClient(Socket clientSocket) {
        executor.submit(new ClientHandler(clientSocket));
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_34684_SocketServer_A07(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                InputStream input = clientSocket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(input);
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Received: " + clientMessage);

                if (clientMessage.equals("username") && "password".equals(dataInputStream.readUTF())) {
                    output.writeUTF("Authentication successful");
                    System.out.println("Authentication successful");
                } else {
                    output.writeUTF("Authentication failed");
                    System.out.println("Authentication failed");
                }
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Failed to process the client " + e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureSocketServer(8080).start();
    }
}