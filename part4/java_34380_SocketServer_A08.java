import javax.net.ssl.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_34380_SocketServer_A08 {
    private static final int PORT = 8080;
    private static final SSLServerSocketFactory sslServerSocketFactory = SSLServerSocketFactory.create(new SSLServerSocketFactory(new javax.net.ssl.SSLServerSocketFactory()));

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try (ServerSocket serverSocket = sslServerSocketFactory.createServerSocket(PORT)) {
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection accepted from " + clientSocket.getRemoteSocketAddress());

                executorService.execute(new SocketHandler(clientSocket));
            }
        } catch (IOException e) {
            System.err.println("Failed to establish connection with " + PORT);
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

class SocketHandler implements Runnable {
    private final Socket socket;

    public java_34380_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (SSLServerSocket sslServerSocket = (SSLServerSocket) socket;
             SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(sslSocket.getInputStream()))) {

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Simulate receiving a response
                String response = "Hello, client!";
                out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}