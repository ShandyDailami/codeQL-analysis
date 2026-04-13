import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_14866_SocketServer_A07 {
    private static final String CLIENT_IP_RANGE = "192.168.1.0/24";
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        ServerSocket server = new ServerSocket(PORT, 100, InetAddress.getByName("192.168.1.1"));
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());
                Handler handler = new Handler(socket, executor);
                handler.start();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                continue;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;
        private ExecutorService executor;

        public java_14866_SocketServer_A07(Socket socket, ExecutorService executor) {
            this.socket = socket;
            this.executor = executor;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();

                while (true) {
                    int data = input.read();
                    if (data == -1) {
                        break;
                    }
                    output.write(data);
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}