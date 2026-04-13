import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_17105_SocketServer_A08 {
    private static final int PORT = 4445;
    private static ExecutorService pool = Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        while (true) {
            Socket client = server.accept();
            pool.execute(new ClientHandler(client));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket client;

        public java_17105_SocketServer_A08(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                InputStream in = client.getInputStream();
                DataInputStream dis = new DataInputStream(in);

                byte[] buffer = new byte[1024];
                int bytesRead = dis.read(buffer);
                if (bytesRead < 0) {
                    client.close();
                    return;
                }

                String message = new String(buffer, 0, bytesRead);
                System.out.println("Received: " + message);

                // Simulate integrity failure
                if (message.contains("failure")) {
                    throw new RuntimeException("Simulated integrity failure");
                }

                OutputStream out = client.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);
                dos.writeUTF("Message received successfully");
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}