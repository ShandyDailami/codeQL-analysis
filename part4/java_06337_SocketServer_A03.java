import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06337_SocketServer_A03 {
    private static final int PORT = 4445; // choose a non-privileged port

    public static void main(String[] args) throws IOException {
        // Create a ServerSocket to listen on the chosen port
        ServerSocket serverSocket = new ServerSocket(PORT);

        System.out.println("Server is listening on port " + PORT);

        while (true) {
            // Accept a client connection
            Socket socket = serverSocket.accept();

            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Handle the client connection in a new thread
            new ClientHandler(socket).start();
        }
    }
}

class ClientHandler extends Thread {
    private final Socket socket;

    public java_06337_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Get an input stream from the client
            // and output a message back to the client
            socket.getInputStream().read();
            socket.getOutputStream().write("Hello, Client!".getBytes());

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}