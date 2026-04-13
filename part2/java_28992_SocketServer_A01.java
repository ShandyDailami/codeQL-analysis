import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_28992_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected!");

            // Create new threads for each client
            new SecureClientHandler(clientSocket).start();
        }
    }
}

class SecureClientHandler extends Thread {
    private final Socket clientSocket;

    public java_28992_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // Read the request from the client
        // ...

        // Here you can add the code for security-sensitive operations
        // ...

        // Send the response back to the client
        // ...

        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}