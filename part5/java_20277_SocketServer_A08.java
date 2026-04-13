import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_20277_SocketServer_A08 {
    private static ExecutorService executor =
      Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("Server started at port 8000");
            while (true) {
                try {
                    Socket socket = serverSocket.accept();
                    System.out.println("Connection accepted from " + socket.getRemoteSocketAddress());
                    Handler handler = new Handler(socket);
                    executor.execute(handler);
                } catch (Exception e) {
                    e.printStackTrace();
                    continue;
                }
            }
        } finally {
            serverSocket.close();
        }
    }

    private static class Handler implements Runnable {
        private final Socket socket;

        public java_20277_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(input);
                String data = dataInputStream.readUTF();
                System.out.println("Received: " + data);
                OutputStream output = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(output);
                dataOutputStream.writeUTF("Hello, client!");
                System.out.println("Sent: " + "Hello, client!");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}