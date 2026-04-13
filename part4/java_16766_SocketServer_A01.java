import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16766_SocketServer_A01 {
    private static final int PORT = 4999;

    public static void main(String[] args) throws IOException {
        // Create a server socket and listen on the port.
        ServerSocket serverSocket = new ServerSocket(PORT);

        // Keep accepting incoming connections until an exception is thrown.
        while (true) {
            Socket socket = serverSocket.accept();

            // Once a connection is accepted, create a new thread for the client.
            ClientHandler clientHandler = new ClientHandler(socket);
            Thread thread = new Thread(clientHandler);
            thread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_16766_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Add code to securely handle the client connection.
        // This is a placeholder, you need to implement the secure handling.

        // Close the socket when the client handler is done.
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}