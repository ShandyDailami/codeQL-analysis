import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_04085_SocketServer_A08 {
    private static final String LOCAL_HOST = "127.0.0.1";
    private static final int PORT = 5000;
    private static ExecutorService executorService;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at " + serverSocket.getLocalSocketAddress());
            executorService = Executors.newCachedThreadPool();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected at " + clientSocket.getRemoteSocketAddress());
                executorService.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
            executorService.shutdown();
        } finally {
            serverSocket.close();
            executorService.shutdown();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public java_04085_SocketServer_A08(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                while (true) {
                    String message = in.readUTF();
                    System.out.println("Received message from client: " + message);
                    out.writeUTF("Message received");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}