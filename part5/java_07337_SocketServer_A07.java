import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_07337_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Here, we're creating a new thread to handle communication with the client
            new Thread(new ClientHandler(socket)).start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_07337_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Read the message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);

            // Reply with a simple text message
            String response = "Hello, client, your message was: " + message;
            socket.getOutputStream().write(response.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}