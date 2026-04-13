import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_09195_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 1234
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Start a new thread to handle communication with the client
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public java_09195_SocketServer_A01(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        // TODO: Handle communication with the client
        // You may want to implement a simple protocol here
    }
}