import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01946_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create a new thread for each connection
            Thread thread = new Thread(new SocketHandler(socket));
            thread.start();
        }
    }
}

class SocketHandler implements Runnable {
    private Socket socket;

    public java_01946_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can implement your security-sensitive operations
            // For example, you can use SSL/TLS to encrypt the data between the client and the server
            // Then you can use a simple authentication mechanism like passwords or certificates
            // For the simplicity of this example, we just print the received data

            System.out.println("Received: " + socket.getInputStream().read());

            // Send a response to the client
            socket.getOutputStream().write("Thank you for connecting!".getBytes());
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}