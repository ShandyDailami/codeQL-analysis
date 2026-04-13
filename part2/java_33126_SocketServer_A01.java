import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33126_SocketServer_A01 {
    private int port;

    public java_33126_SocketServer_A01(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            while (true) {
                Socket client = server.accept();
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed: " + e.getMessage());
        }
    }

    private class ClientHandler extends Thread {
        private Socket client;

        public java_33126_SocketServer_A01(Socket client) {
            this.client = client;
        }

        public void run() {
            // handle client communication here
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).start();
    }
}