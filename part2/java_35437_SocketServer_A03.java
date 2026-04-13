import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_35437_SocketServer_A03 {
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");
            executor.execute(new ClientHandler(socket));
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_35437_SocketServer_A03(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                String message = dataInputStream.readUTF();

                System.out.println("Received message: " + message);

                PrintWriter outputStream = new PrintWriter(socket.getOutputStream(), true);
                outputStream.println("Message received");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}