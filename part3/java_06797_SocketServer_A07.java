import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06797_SocketServer_A07 {

    private static final int PORT = 1234;

    public static void main(String[] args) {
        System.out.println("Server started.");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected.");

                // For the sake of simplicity, we're going to use the legacy socket API
                new Thread(() -> handleRequest(clientSocket)).start();
            }
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) {
        // Here you can implement your request-response cycle for the clientSocket
        // For the sake of simplicity, we're going to echo back any message received
        try (clientSocket;
             Socket echoSocket = new Socket(clientSocket.getInetAddress(), clientSocket.getPort())) {

            byte[] bytes = new byte[1024];
            int bytesRead;
            while ((bytesRead = clientSocket.getInputStream().read(bytes)) != -1) {
                echoSocket.getOutputStream().write(bytes, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}