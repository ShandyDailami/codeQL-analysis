import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41117_SocketServer_A07 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getInetAddress().getHostAddress());

            // Handle the client in a new thread
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_41117_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO: Handle the client
        // You can use InputStream and OutputStream to read/write data
        // from/to the client

        // Example:
        try {
            // TODO: Handle the client
            // Read a message from the client
            // You can use a BufferedReader to read the message
            // from the InputStream

            // TODO: Handle the client
            // Send a message to the client
            // You can use a PrintWriter to send the message
            // to the OutputStream

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}