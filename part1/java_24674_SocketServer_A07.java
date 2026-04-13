import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_24674_SocketServer_A07 {

    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) {
        executor = Executors.newCachedThreadPool();
        startServer(5000);
    }

    private static void startServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);
            while(true) {
                Socket client = server.accept();
                System.out.println("Client connected from " + client.getRemoteSocketAddress());
                handleClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket client) {
        executor.execute(new ClientHandler(client));
    }

    private static class ClientHandler implements Runnable {
        private Socket client;
        private DataInputStream in;
        private DataOutputStream out;

        public java_24674_SocketServer_A07(Socket client) {
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
                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received message: " + message);
                    // Perform security sensitive operations related to A07_AuthFailure here
                    // For example, checking the message for suspicious activity or sending response back
                    out.writeUTF("Server received your message: " + message);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}