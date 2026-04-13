import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20100_SocketServer_A03 {
    private static final int PORT = 6000;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server is listening on port " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            // Create new thread for handling the client
            Thread t = new Thread(new ClientHandler(socket));
            t.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_20100_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer, "UTF-8");
            System.out.println("Received: " + message);

            // Send a response to the client
            String response = "Hello, " + message + "!";
            socket.getOutputStream().write(response.getBytes("UTF-8"));
            System.out.println("Sent: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}