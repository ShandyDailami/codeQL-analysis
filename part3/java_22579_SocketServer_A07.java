import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_22579_SocketServer_A07 {
    private final ExecutorService executor;
    private final ServerSocket serverSocket;
    private boolean isRunning = true;

    public java_22579_SocketServer_A07(int port) throws IOException {
        this.executor = Executors.newCachedThreadPool();
        this.serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("Server is running on port " + serverSocket.getLocalPort() + "...");
        while (isRunning) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());
            ServerHandler serverHandler = new ServerHandler(clientSocket);
            executor.execute(serverHandler);
        }
        executor.shutdown();
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(5000);
        server.start();
    }

    private class ServerHandler extends Thread {
        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_22579_SocketServer_A07(Socket socket) throws IOException {
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
        }

        @Override
        public void run() {
            String message;
            try {
                message = in.readUTF();
                if (message.equals("exit")) {
                    socket.close();
                    System.out.println("Closed connection from " + socket.getRemoteSocketAddress());
                } else {
                    sendMessage(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
                isRunning = false;
            }
        }

        private void sendMessage(String message) {
            try {
                out.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}