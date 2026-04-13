import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_36862_SocketServer_A01 {

    private int port;
    private ServerSocket serverSocket;

    public java_36862_SocketServer_A01(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            stop();
        }
    }

    public void stop() {
        try {
            serverSocket.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;

        public java_36862_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            // Handle client connection and communication...
        }
    }

    public static void main(String[] args) {
        new SocketServer(1234).start();
    }
}