import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_22058_SocketServer_A03 {
    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException {
        executor = Executors.newFixedThreadPool(5);
        server = new ServerSocket(12345);

        while (true) {
            Socket client = server.accept();
            executor.execute(new ClientHandler(client));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket client;

        public java_22058_SocketServer_A03(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                InputStream input = client.getInputStream();
                DataInputStream dis = new DataInputStream(input);
                String message = dis.readUTF();

                System.out.println("Received: " + message);

                OutputStream output = client.getOutputStream();
                DataOutputStream dos = new DataOutputStream(output);
                dos.writeUTF("Message received: " + message);

                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}