import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_35275_SocketServer_A08 {

    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("Accepted a new client: " + client.getRemoteSocketAddress());
                Handler handler = new Handler(client);
                executor.execute(handler);
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

    static class Handler implements Runnable {
        Socket client;

        public java_35275_SocketServer_A08(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(client.getInputStream());
                DataOutputStream out = new DataOutputStream(client.getOutputStream());
                String msg = in.readUTF();
                out.writeUTF("Hello, client, your message was: " + msg);
                out.flush();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}