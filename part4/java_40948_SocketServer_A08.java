import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_40948_SocketServer_A08 {

    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("Server is running on port " + port);
            while (true) {
                try {
                    Socket client = server.accept();
                    System.out.println("Client " + client.getRemoteSocketAddress() + " connected");
                    executor.execute(new SocketHandler(client));
                } catch (IOException e) {
                    System.out.println("Error accepting client " + e);
                }
            }
        } catch (IOException e) {
            System.out.println("Error creating server " + e);
        }
    }

    private static class SocketHandler implements Runnable {

        private Socket socket;

        public java_40948_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()) {
                DataInputStream dis = new DataInputStream(input);
                DataOutputStream dos = new DataOutputStream(output);
                String message = dis.readUTF();
                System.out.println("Received: " + message);
                String response = "Hello, client, your message was: " + message;
                dos.writeUTF(response);
                System.out.println("Sent: " + response);
            } catch (IOException e) {
                System.out.println("Error handling client " + e);
            }
        }
    }
}