import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_33992_SocketServer_A08 {
    private static ExecutorService execService = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        int port = 5555;
        try {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                Handler handler = new Handler(socket);
                execService.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            execService.shutdown();
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;

        public java_33992_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dis = new DataInputStream(input);
                OutputStream output = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(output);

                String message = dis.readUTF();
                String encryptedMessage = encryptMessage(message);
                dos.writeUTF(encryptedMessage);
                dos.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String encryptMessage(String message) {
            // Here you can implement your encryption logic.
            // For simplicity, we just return the message itself.
            return message;
        }
    }
}