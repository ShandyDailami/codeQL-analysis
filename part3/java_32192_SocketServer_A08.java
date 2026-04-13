import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_32192_SocketServer_A08 {
    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);

        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected!");
                executor.execute(new ClientHandler(socket));
            }
        } catch (IOException e) {
            System.err.println("Server failed to listen on port " + PORT);
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_32192_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {

                DataInputStream dis = new DataInputStream(in);
                DataOutputStream dos = new DataOutputStream(out);

                String clientMessage = dis.readUTF();
                System.out.println("Received message from client: " + clientMessage);

                String serverMessage = "Hello, client!";
                dos.writeUTF(serverMessage);
                System.out.println("Sent message to client: " + serverMessage);

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}