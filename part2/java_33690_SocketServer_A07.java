import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_33690_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_33690_SocketServer_A07(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Here you can handle client requests, for example, reading data from the client,
            // writing data to the client, or performing any other operations you need to do securely.
            // For the purpose of this example, we'll just echo back any data received from the client.
            while ((clientSocket.getInputStream().read()) != -1) {
                clientSocket.getOutputStream().write((clientSocket.getInputStream().read()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            clientSocket.close();
        }
    }
}