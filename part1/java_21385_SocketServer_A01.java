import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class java_21385_SocketServer_A01 {

    private static ExecutorService executorService = Executors.newCachedThreadPool();
    private static ServerSocket serverSocket;
    private static boolean stopServer = false;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(6000);
        System.out.println("Server started at " + serverSocket.getLocalSocketAddress());

        while (!stopServer) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted from " + clientSocket.getRemoteSocketAddress());

                // Secure the communication
                SecureSocketClientHandler clientHandler = new SecureSocketClientHandler(clientSocket);
                executorService.execute(clientHandler);
            } catch (IOException e) {
                if (!stopServer) {
                    System.out.println("Client connection refused: " + e.getMessage());
                }
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        serverSocket.close();
    }

    public static void stopServer() {
        stopServer = true;
        serverSocket.close();
        executorService.shutdown();
    }

    static class SecureSocketClientHandler implements Runnable {

        private final Socket clientSocket;

        public java_21385_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (InputStream input = clientSocket.getInputStream();
                 OutputStream output = clientSocket.getOutputStream()) {

                // Read data from client
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String data;
                while ((data = reader.readLine()) != null) {
                    System.out.println("Received data: " + data);

                    // Secure the data with a secure method, e.g., hash the data or sign it
                    // For simplicity, let's just reverse the data
                    String reversedData = new StringBuilder(data).reverse().toString();
                    output.write(reversedData.getBytes());
                    output.newLine();
                    output.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}