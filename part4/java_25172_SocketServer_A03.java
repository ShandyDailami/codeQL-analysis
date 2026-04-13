import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_25172_SocketServer_A03 {
    private static ExecutorService executor;
    private static ServerSocket server;

    public static void main(String[] args) throws Exception {
        startServer();
    }

    private static void startServer() throws Exception {
        executor = Executors.newCachedThreadPool();
        server = new ServerSocket(8000);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");
            executor.execute(new ClientHandler(socket));
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;

        public java_25172_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);

                String message = dataInputStream.readUTF();
                System.out.println("Received: " + message);

                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                dataOutputStream.writeUTF("Thank you for connecting to the server!");
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}