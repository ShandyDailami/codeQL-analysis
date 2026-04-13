import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15160_SocketServer_A01 {

    private static final int PORT = 9000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handling the connection in a separate thread
                new Thread(new SocketHandler(socket)).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start.");
            e.printStackTrace();
        }
    }
}

class SocketHandler implements Runnable {

    private Socket socket;

    public java_15160_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Reading a message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);
            System.out.println("Received message: " + message);

            // Sending a response
            byte[] response = "Hello, client!".getBytes();
            socket.getOutputStream().write(response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}