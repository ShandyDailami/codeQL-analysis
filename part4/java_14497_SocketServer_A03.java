import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14497_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected: " + client.getInetAddress().getHostAddress());
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket client;

        public java_14497_SocketServer_A03(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                // Here you can use the client socket to read and send data
                // For now, let's just print out the data
                byte[] buffer = new byte[1024];
                int bytesRead = client.getInputStream().read(buffer);
                while (bytesRead != -1) {
                    String received = new String(buffer, 0, bytesRead);
                    System.out.println("Received: " + received);
                    bytesRead = client.getInputStream().read(buffer);
                }
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}