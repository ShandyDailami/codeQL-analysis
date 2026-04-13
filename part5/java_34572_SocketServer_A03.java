import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34572_SocketServer_A03 {
    private ServerSocket serverSocket;

    public java_34572_SocketServer_A03(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server started. Listening on port: " + serverSocket.getLocalPort());

        while (!serverSocket.isClosed()) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);

                // Perform security-sensitive operations related to A03_Injection here.
                // For example, removing the message from the database if it contains harmful code.

                String serverMessage = "Server received: " + clientMessage;
                writer.println(serverMessage);
            }

            clientSocket.close();
        }

        serverSocket.close();
    }

    public static void main(String[] args) {
        try {
            SecureServer server = new SecureServer(8000);
            server.startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}