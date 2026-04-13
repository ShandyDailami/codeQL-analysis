import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33366_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Here you should add your authentication logic.
                // For simplicity, we'll just check if the client's username starts with "admin"
                String username = clientSocket.getRemoteSocketAddress().toString();
                if (!username.startsWith("admin")) {
                    System.out.println("Auth failure");
                    clientSocket.close();
                    continue;
                }

                // If authentication passes, we'll proceed with the communication with the client
                // This is a very basic example and might not be suitable for a production environment
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public java_33366_SocketServer_A07(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // TODO: Add your client communication logic here
        // For simplicity, we'll just print out the received data from the client
        try {
            byte[] buffer = new byte[1024];
            int bytesRead = clientSocket.getInputStream().read(buffer);
            if (bytesRead < 0) {
                clientSocket.close();
                return;
            }
            String message = new String(buffer, 0, bytesRead);
            System.out.println("Received: " + message);

            // TODO: Add your server response logic here
            // For simplicity, we'll just send back the received message
            String response = "Received your message: " + message;
            clientSocket.getOutputStream().write(response.getBytes());
            clientSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}