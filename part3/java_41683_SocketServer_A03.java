import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_41683_SocketServer_A03 {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public java_41683_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String response = "Hello, Client!";
                socket.getOutputStream().write(response.getBytes());

                // Receive a message from the client.
                byte[] bytes = new byte[1024];
                socket.getInputStream().read(bytes);
                String message = new String(bytes);
                System.out.println("Received message from client: " + message);

                // Send a response back to the client.
                String responseToClient = "Server says: " + message;
                socket.getOutputStream().write(responseToClient.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}