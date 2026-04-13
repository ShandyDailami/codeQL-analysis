import java.net.ServerSocket;
import java.net.Socket;

public class java_01828_SocketServer_A01 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Handle the client in a new thread
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_01828_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Receive a message from the client
            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            String message = new String(buffer);

            System.out.println("Received message: " + message);

            // Send a response back to the client
            String response = "Hello, client!";
            socket.getOutputStream().write(response.getBytes());

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}