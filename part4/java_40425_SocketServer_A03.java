import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_40425_SocketServer_A03 {

    private static final int DEFAULT_PORT = 8080;

    private int port;
    private ServerSocket server;
    private ExecutorService executor;

    public java_40425_SocketServer_A03(int port) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(50);
    }

    public void startServer() {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is started on port " + port);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getRemoteSocketAddress() + " connected");
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                executor.execute(new ClientHandler(in, out, client));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
            try {
                if (server != null) {
                    server.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class ClientHandler implements Runnable {

        private DataInputStream in;
        private DataOutputStream out;
        private Socket client;

        public java_40425_SocketServer_A03(DataInputStream in, DataOutputStream out, Socket client) {
            this.in = in;
            this.out = out;
            this.client = client;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received: " + message);
                    out.writeUTF("Message received");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(DEFAULT_PORT).startServer();
    }
}