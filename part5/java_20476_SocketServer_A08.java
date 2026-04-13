import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_20476_SocketServer_A08 {

    private ExecutorService executor;
    private int port;

    public java_20476_SocketServer_A08(int port) {
        this.port = port;
        this.executor = Executors.newCachedThreadPool();
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port " + port);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());
            Handler handler = new Handler(socket);
            executor.execute(handler);
        }
    }

    public void stop() {
        executor.shutdown();
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(8080);
        server.start();
    }

    class Handler implements Runnable {
        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public java_20476_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try {
                String message = in.readUTF();
                System.out.println("Received: " + message);
                message = "Hello from server, message is: " + message;
                out.writeUTF(message);
                out.flush();
                System.out.println("Sent: " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}