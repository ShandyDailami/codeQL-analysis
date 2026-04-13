import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_02702_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port: " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_02702_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle client request here. This is a very basic example and is not secure.
        // In a real-world scenario, you would need to implement a protocol to ensure data integrity and security.
        // For example, you could use SSL/TLS to encrypt data and verify the identity of the client.
        // In this example, we're not doing anything with the client's data, but you could do something like this:

        try {
            socket.getInputStream().read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}