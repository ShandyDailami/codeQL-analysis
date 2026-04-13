import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_28923_SocketServer_A01 {
    private final ExecutorService executor;
    private final ServerSocket serverSocket;

    public java_28923_SocketServer_A01(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
    }

    public void startServer() {
        System.out.println("Server started on port " + serverSocket.getLocalPort());
        while (true) {
            try {
               Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
                ServerWorker worker = new ServerWorker(clientSocket);
                executor.execute(worker);
            } catch (IOException ex) {
                System.out.println("Failed to accept new connection from " + ex);
            }
        }
    }

    public void stopServer() {
        try {
            serverSocket.close();
            executor.shutdown();
        } catch (IOException ex) {
            System.out.println("Failed to close server " + ex);
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer(8080);
        server.startServer();
    }
}

class ServerWorker implements Runnable {
    private final Socket clientSocket;

    public java_28923_SocketServer_A01(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (InputStream in = clientSocket.getInputStream(); OutputStream out = clientSocket.getOutputStream()) {
            DataInputStream inFromClient = new DataInputStream(in);
            DataOutputStream outToClient = new DataOutputStream(out);

            String userInput = inFromClient.readUTF();
            System.out.println("Received: " + userInput);

            outToClient.writeUTF("Message from server: " + userInput);
        } catch (IOException ex) {
            System.out.println("Failed to handle client " + ex);
        }
    }
}