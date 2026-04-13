import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_21786_SocketServer_A08 {
    private int port;
    private ExecutorService executor;

    public java_21786_SocketServer_A08(int port) {
        this.port = port;
        this.executor = Executors.newCachedThreadPool();
    }

    public void startServer() throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port: " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());
            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_21786_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream input = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(input);

                String message = dataInputStream.readUTF();
                System.out.println("Received: " + message);

                OutputStream output = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(output);
                dataOutputStream.writeUTF("Message received: " + message);
                dataOutputStream.flush();

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(5000);
        server.startServer();
    }
}