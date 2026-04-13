import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_10070_SocketServer_A07 {
    private final ExecutorService executor;
    private final ServerSocket server;

    public java_10070_SocketServer_A07(int port) throws IOException {
        server = new ServerSocket(port);
        executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected!");
            executor.execute(new ClientHandler(client));
        }
    }

    public void stop() throws IOException {
        server.close();
        executor.shutdown();
    }

    private class ClientHandler implements Runnable {
        private final Socket client;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_10070_SocketServer_A07(Socket client) {
            this.client = client;
            try {
                in = new DataInputStream(client.getInputStream());
                out = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received message: " + message);
                    out.writeUTF("Message received");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(5000);
        server.start();
    }
}