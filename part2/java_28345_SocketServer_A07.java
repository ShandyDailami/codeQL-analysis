import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_28345_SocketServer_A07 {
    private static final int PORT = 8080;
    private static final int CORE_POOL_SIZE = 10;
    private ExecutorService executorService;

    public java_28345_SocketServer_A07() {
        executorService = Executors.newFixedThreadPool(CORE_POOL_SIZE);
    }

    public void start() {
        System.out.println("Server started on port: " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());
                DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

                Runnable worker = new SocketHandler(inputStream, outputStream);
                executorService.execute(worker);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class SocketHandler implements Runnable {
        private DataInputStream inputStream;
        private DataOutputStream outputStream;

        public java_28345_SocketServer_A07(DataInputStream inputStream, DataOutputStream outputStream) {
            this.inputStream = inputStream;
            this.outputStream = outputStream;
        }

        @Override
        public void run() {
            try {
                String message = inputStream.readUTF();
                System.out.println("Received: " + message);

                if ("exit".equals(message)) {
                    outputStream.writeUTF("Goodbye!");
                    outputStream.flush();
                    inputStream.close();
                    outputStream.close();
                } else {
                    outputStream.writeUTF("Hello, client!");
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer().start();
    }
}