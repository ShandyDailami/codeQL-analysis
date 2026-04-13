import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_13210_SocketServer_A03 {

    private static final int PORT = 8080;
    private static ExecutorService executor;

    public static void main(String[] args) {
        executor = Executors.newFixedThreadPool(10);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            while (true) {
                Socket socket = server.accept();
                System.out.println("New client connected");
                Handler handler = new Handler(socket);
                executor.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }

    static class Handler implements Runnable {

        private Socket socket;

        public java_13210_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()) {
                DataInputStream dis = new DataInputStream(in);
                DataOutputStream dos = new DataOutputStream(out);
                String clientMessage = dis.readUTF();
                System.out.println("Received: " + clientMessage);
                String serverMessage = "Hello, client!";
                dos.writeUTF(serverMessage);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}