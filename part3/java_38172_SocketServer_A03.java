import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_38172_SocketServer_A03 {
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        System.out.println("Server started on port " + SERVER_PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

            // Now you can start a new thread for each client
            new SecureSocketServerThread(clientSocket).start();
        }
    }
}

class SecureSocketServerThread extends Thread {
    private Socket clientSocket;

    public java_38172_SocketServer_A03(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // In this method, you can implement your secure server logic here.
        // For example, you can use SSL/TLS to encrypt the communication between the client and the server.

        // Now, you can use your standard libraries to handle the client socket, read/write data...
    }
}