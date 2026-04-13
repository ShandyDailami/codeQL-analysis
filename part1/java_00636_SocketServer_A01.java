import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_00636_SocketServer_A01 {
    private static ExecutorService executor;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        executor = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = server.accept();
            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_00636_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (OutputStream out = new BufferedOutputStream(socket.getOutputStream())) {
                DataOutputStream dos = new DataOutputStream(out);
                dos.writeUTF("Hello, client!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}